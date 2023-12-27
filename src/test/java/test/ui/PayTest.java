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

public class PayTest {
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
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getValidDataWithApprovedCard();
        paymentPage.inputData(cardInfo);
        paymentPage.getSuccessNotification();
        var actual = DataBaseHelper.getStatusPaymentRequest();
        assertEquals("APPROVED", actual);
    }

}
