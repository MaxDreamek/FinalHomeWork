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

public class ErrorDisappearedTest extends SelenideInit {
    private final String SYMBOL_FOR_EMAIL = "a";
    private final String SYMBOL_FOR_PASSWORD = "1";
    private final String EMPTY_VALUE = "";
    @Test
    @Owner("Max")
    @Severity(SeverityLevel.NORMAL)
    @Parameters("email")
    @Description("Test checking validation plates disappeared on the authorization pages")
    public void checkDisappearedValidationPlates(String email) {
        open(SiteUrl.MAIN.url);
        changeCookie();
        new MainPageLogic()
                .clickSignInBtn(false)
                .clickContinueBtnWithIncorrectData()
                .checkValidationEmptyField()
                .fillEmailInput(SYMBOL_FOR_EMAIL)
                .checkDisappearEmptyValidationPlate()
                .clickContinueBtnWithIncorrectData()
                .checkIncorrectDataAlertPresent()
                .fillEmailInput(EMPTY_VALUE).clickContinueBtnWithIncorrectData()
                .checkDisappearIncorrectDataAlert()
                .checkValidationEmptyField()
                .fillEmailInput(email).clickContinueBtn()
                .clickSignInBtnWithIncorrectData().checkValidationEmptyField()
                .fillPasswordInput(SYMBOL_FOR_PASSWORD).checkDisappearEmptyValidationPlate();
    }
}
