package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private static Faker fakerEn = new Faker(new Locale("en"));
    private static Faker fakerRu = new Faker(new Locale("ru"));

    private DataHelper() {
    }

    public static String getLastYear(int minusOneYear) {
        return LocalDate.now().minusYears(minusOneYear).format(DateTimeFormatter.ofPattern("yy"));
    }


    public static String generateHolderName() {
        return fakerEn.name().lastName() + " " + fakerEn.name().firstName();
    }

    public static String generateMonth(int month) {
        return LocalDate.now().plusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear(int year) {
        return LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("yy"));
    }


    @Value
    public static class CardInfo {
        String number;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static String getApprovedCardNumber() {
        return ("4444 4444 4444 4441");
    }

    public static String getDeclinedCardNumber() {
        return ("4444 4444 4444 4442");
    }

    public static CardInfo getValidDataWithApprovedCard() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }

    public static CardInfo getValidDataWithDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(),
                generateMonth(0),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }

    public static CardInfo getCardInfoWithEmptyFields() {
        return new CardInfo(
                null,
                null,
                null,
                null,
                null);
    }

    public static CardInfo getCardInfoWithEmptyNumber() {
        return new CardInfo(null,
                generateMonth(0),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }


    public static CardInfo getCardInfoWithRandomNumber() {
        return new CardInfo(fakerEn.numerify("#### #### #### ####"),
                generateMonth(0),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }


    public static CardInfo getCardInfoWith15() {
        return new CardInfo(fakerEn.numerify("#### #### #### ###"),
                generateMonth(0),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }


    public static CardInfo getCardInfoWithNullMonth() {
        return new CardInfo(getApprovedCardNumber(),
                null,
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }

    public static CardInfo getCardInfoWithMonthWithTwoZero() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("00")),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }

    public static CardInfo getCardInfoWithMonthWithZero() {
        return new CardInfo(getApprovedCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("0")),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }


    public static CardInfo getCardInfoWith13Month() {
        return new CardInfo(getApprovedCardNumber(),
                "13",
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("###"));
    }


    public static CardInfo getCardInfoWithNullYear() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                null,
                generateHolderName(),
                fakerEn.numerify("###"));
    }

    public static CardInfo getCardInfoWithLastYear() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                getLastYear(1),
                generateHolderName(),
                fakerEn.numerify("###"));
    }


    public static CardInfo getCardInfoWith1NumberYear() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                fakerEn.numerify("#"),
                generateHolderName(),
                fakerEn.numerify("###"));
    }

    public static CardInfo getCardInfoWithNullOwner() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                generateYear(0),
                null,
                fakerEn.numerify("###"));
    }


    public static CardInfo getCardInfoWithOwnerWithNumbers() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                generateYear(0),
                "2342432",
                fakerEn.numerify("###"));
    }

    public static CardInfo getCardInfoWithOwnerCyrillic() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                generateYear(0),
                fakerRu.name().firstName() + " " + fakerRu.name().lastName(),
                fakerEn.numerify("###"));
    }

    public static CardInfo getCardInfoWithOwnerSpecialCharacters() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                generateYear(0),
                ")(*&^%$#@!@",
                fakerEn.numerify("###"));
    }

    public static CardInfo getCardInfoWithEmptyCVC() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                generateYear(0),
                generateHolderName(),
                null);
    }


    public static CardInfo getCardInfoWithCVC2Numbers() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("##"));
    }

    public static CardInfo getCardInfoWithCVC1Numbers() {
        return new CardInfo(getApprovedCardNumber(),
                generateMonth(0),
                generateYear(0),
                generateHolderName(),
                fakerEn.numerify("#"));
    }

}
