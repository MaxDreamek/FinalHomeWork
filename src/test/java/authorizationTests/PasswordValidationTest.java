package authorizationTests;

import enums.SiteUrl;
import initWebDriver.SelenideInit;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.MainPageLogic;

import static com.codeborne.selenide.Selenide.open;

public class PasswordValidationTest extends SelenideInit {
    private final String EMPTY_PASSWORD_EXPECTED_ERROR = "Enter your password";
    private final String INCORRECT_PASS = "123";

    @Test
    @Owner("Max")
    @Severity(SeverityLevel.NORMAL)
    @Parameters("email")
    @Description("Test checking validation on the second authorization page")
    public void authorizationWithEmptyDataTest(String email) {
        open(SiteUrl.MAIN.url);
        changeCookie();
        new MainPageLogic().openAccountPopUp()
                .clickSignInBtn(true)
                .fillEmailInput(email)
                .clickContinueBtn()
                .clickSignInBtnWithIncorrectData()
                .checkValidationEmptyField(EMPTY_PASSWORD_EXPECTED_ERROR)
                .fillPasswordInput(INCORRECT_PASS)
                .clickSignInBtnWithIncorrectData()
                .checkCaptchaDisplay();
    }
}
