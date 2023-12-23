package authorizationTests;

import enums.SiteUrl;
import initWebDriver.SelenideInit;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pom.MainPageLogic;

import static com.codeborne.selenide.Selenide.open;

public class EmailValidationTest extends SelenideInit {
    private final String ALERT_EMAIL_TITLE = "There was a problem";
    private final String ALERT_EMAIL_TEXT = "We cannot find an account with that email address";
    private final String ALERT_PHONE_TITLE = "Incorrect phone number";
    private final String ALERT_PHONE_TEXT = "We cannot find an account with that mobile number";
    private final String EMPTY_EMAIL_EXPECTED_ERROR = "Enter your email or mobile phone number";
    private final String INCORRECT_EMAIL = "sa@mail";
    private final String INCORRECT_PHONE = "544";

    @Test
    @Owner("Max")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test checking validation on the first authorization page")
    public void authorizationWithEmptyDataTest(){
        open(SiteUrl.MAIN.url);
        changeCookie();
        new MainPageLogic().openAccountPopUp()
                .clickSignInBtn(true)
                .clickContinueBtnWithIncorrectData()
                .checkValidationEmptyField(EMPTY_EMAIL_EXPECTED_ERROR)
                .fillEmailInput(INCORRECT_EMAIL)
                .clickContinueBtnWithIncorrectData()
                .checkIncorrectDataAlert(ALERT_EMAIL_TITLE, ALERT_EMAIL_TEXT)
                .fillEmailInput(INCORRECT_PHONE)
                .clickContinueBtnWithIncorrectData()
                .checkIncorrectDataAlert(ALERT_PHONE_TITLE, ALERT_PHONE_TEXT);
    }
}
