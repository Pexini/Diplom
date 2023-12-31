package test.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.gson.Gson;
import data.APIHelper;
import data.DataBaseHelper;
import data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;

import static data.DataBaseHelper.cleanDataBase;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditApiTest {
    private static DataHelper.CardInfo cardInfo;
    private static final Gson gson = new Gson();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    public void teardrop() {
        cleanDataBase();
    }


    @Test
    void shouldRespondWithStatusCode200WithApprovedCard() {
        cardInfo = DataHelper.getValidDataWithApprovedCard();
        var body = gson.toJson(cardInfo);
        APIHelper.sendRequest(body, 200, "/api/v1/credit");
        val actual = DataBaseHelper.getStatusCreditRequest();
        assertEquals("APPROVED", actual);
        val countOrder = DataBaseHelper.getCountOrderEntity();
        assertEquals(1, countOrder);
    }

    @Test
    void shouldRespondWithStatusCode200WithDeclinedCard() {
        cardInfo = DataHelper.getValidDataWithDeclinedCard();
        var body = gson.toJson(cardInfo);
        APIHelper.sendRequest(body, 200, "/api/v1/credit");
        val actual = DataBaseHelper.getStatusCreditRequest();
        assertEquals("DECLINED", actual);
        val countOrder = DataBaseHelper.getCountOrderEntity();
        assertEquals(1, countOrder);
    }

    @Test
    void shouldRespondWithStatus400IfAllFieldsAreEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyFields();
        var body = gson.toJson(cardInfo);
        APIHelper.sendRequest(body, 500, "/api/v1/credit");
        val countOrder = DataBaseHelper.getCountOrderEntity();
        assertEquals(0, countOrder);
    }

    @Test
    void shouldRespondWithStatus400IfCardNumberIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyNumber();
        var body = gson.toJson(cardInfo);
        APIHelper.sendRequest(body, 500, "/api/v1/credit");
        val countOrder = DataBaseHelper.getCountOrderEntity();
        assertEquals(0, countOrder);
    }

    @Test
    void shouldRespondWithStatus400IfFieldMonthIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithNullMonth();
        var body = gson.toJson(cardInfo);
        APIHelper.sendRequest(body, 400, "/api/v1/credit");
        val countOrder = DataBaseHelper.getCountOrderEntity();
        assertEquals(0, countOrder);
    }

    @Test
    void shouldRespondWithStatus400IfFieldYearIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithNullYear();
        var body = gson.toJson(cardInfo);
        APIHelper.sendRequest(body, 400, "/api/v1/credit");
        val countOrder = DataBaseHelper.getCountOrderEntity();
        assertEquals(0, countOrder);
    }

    @Test
    void shouldRespondWithStatus400IfFieldHolderIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithNullOwner();
        var body = gson.toJson(cardInfo);
        APIHelper.sendRequest(body, 400, "/api/v1/credit");
        val countOrder = DataBaseHelper.getCountOrderEntity();
        assertEquals(0, countOrder);
    }

    @Test
    void shouldRespondWithStatus400IfFieldCVCIsEmpty() {
        cardInfo = DataHelper.getCardInfoWithEmptyCVC();
        var body = gson.toJson(cardInfo);
        APIHelper.sendRequest(body, 400, "/api/v1/credit");
        val countOrder = DataBaseHelper.getCountOrderEntity();
        assertEquals(0, countOrder);
    }
}
