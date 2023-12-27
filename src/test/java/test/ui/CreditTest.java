package test.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataBaseHelper;
import data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditTest {
    DashboardPage page = open("http://localhost:8080/", DashboardPage.class);

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Card with APPROVED status")
    void shouldSuccessPaymentByCard() {
        var creditPage = page.creditButtonClick();
        var cardInfo = DataHelper.getValidDataWithApprovedCard();
        creditPage.inputData(cardInfo);
        creditPage.getSuccessNotification();
        var actual = DataBaseHelper.getStatusCreditRequest();
        assertEquals("APPROVED", actual);
    }

    @Test
    @DisplayName("Card with DECLINED status")
    void shouldDeclinePaymentByCard() {
        var creditPage = page.creditButtonClick();
        var cardInfo = DataHelper.getValidDataWithDeclinedCard();
        creditPage.inputData(cardInfo);
        creditPage.getErrorNotification();
        var actual = DataBaseHelper.getStatusCreditRequest();
        assertEquals("DECLINED", actual);
    }

    @Test
    @DisplayName("Card with empty fields")
    void shouldFailValidationCardWithEmptyFields() {
        var creditPage = page.creditButtonClick();
        var cardInfo = DataHelper.getCardInfoWithEmptyFields();
        creditPage.inputData(cardInfo);
        creditPage.checkingEmptyField();
    }
    @Test
    @DisplayName("Card with empty number")
    void shouldFailValidationWithEmptyCardNumber() {
        var creditPage = page.creditButtonClick();
        var cardInfo = DataHelper.getCardInfoWithEmptyNumber();
        creditPage.inputData(cardInfo);
        creditPage.checkingWrongFormat();
    }
    @Test
    @DisplayName("Card with random number")
    void shouldDeclineTransactionCardWithRandomNumber() {
        var creditPage = page.creditButtonClick();
        var cardInfo = DataHelper.getCardInfoWithRandomNumber();
        creditPage.inputData(cardInfo);
        creditPage.getErrorNotification();
    }
    @Test
    @DisplayName("Card with 15 numbers")
    void shouldFailValidationWithCard15Numbers() {
        var creditPage = page.creditButtonClick();
        var cardInfo = DataHelper.getCardInfoWith15();
        creditPage.inputData(cardInfo);
        creditPage.checkingWrongFormat();
    }


}
