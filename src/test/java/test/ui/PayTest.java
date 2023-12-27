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

    @Test
    @DisplayName("Card with DECLINED status")
    void shouldDeclinePaymentByCard() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getValidDataWithDeclinedCard();
        paymentPage.inputData(cardInfo);
        paymentPage.getErrorNotification();
        var actual = DataBaseHelper.getStatusPaymentRequest();
        assertEquals("DECLINED", actual);
    }

    @Test
    @DisplayName("Card with empty fields")
    void shouldFailValidationCardWithEmptyFields() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWithEmptyFields();
        paymentPage.inputData(cardInfo);
        paymentPage.checkingEmptyField();
    }

    @Test
    @DisplayName("Card with empty number")
    void shouldFailValidationWithEmptyCardNumber() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWithEmptyNumber();
        paymentPage.inputData(cardInfo);
        paymentPage.checkingWrongFormat();
    }

    @Test
    @DisplayName("Card with random number")
    void shouldDeclineTransactionCardWithRandomNumber() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWithRandomNumber();
        paymentPage.inputData(cardInfo);
        paymentPage.getErrorNotification();
    }

    @Test
    @DisplayName("Card with 15 numbers")
    void shouldFailValidationWithCard15Numbers() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWith15();
        paymentPage.inputData(cardInfo);
        paymentPage.checkingWrongFormat();
    }

    @Test
    @DisplayName("Card with empty month")
    void shouldFailValidationCardWithEmptyMonth() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWithNullMonth();
        paymentPage.inputData(cardInfo);
        paymentPage.checkingWrongFormat();
    }

    @Test
    @DisplayName("Card with two zero in month")
    void shouldFailValidationCardWithZeroInMonth() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWithMonthWithTwoZero();
        paymentPage.inputData(cardInfo);
        paymentPage.checkingWrongDateFormat();
    }

    @Test
    @DisplayName("Card with one zero in month")
    void shouldFailValidationCardWith1NumberMonth() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWithMonthWithZero();
        paymentPage.inputData(cardInfo);
        paymentPage.checkingWrongFormat();
    }

    @Test
    @DisplayName("Card with month number 13")
    void shouldFailValidationWithMonthAbove12() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWith13Month();
        paymentPage.inputData(cardInfo);
        paymentPage.checkingWrongDateFormat();
    }

    @Test
    @DisplayName("Card with empty year")
    void shouldFailValidationCardWithEmptyYear() {
        var paymentPage = page.paymentButtonClick();
        var cardInfo = DataHelper.getCardInfoWithNullYear();
        paymentPage.inputData(cardInfo);
        paymentPage.checkingWrongFormat();
    }
}
