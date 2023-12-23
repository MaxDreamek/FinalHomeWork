package pom;

import com.codeborne.selenide.Condition;
import interfaces.IAuthorization;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class AuthorizationSecondPage extends AuthorizationSecondPageLocators implements IAuthorization {

    @Step("Fill the password input with value")
    public AuthorizationSecondPage fillPasswordInput(String password) {
        fillAuthorizationInputI(passwordEmail, password);
        return this;
    }

    @Step("Submit the form with password and Sing In")
    public MainPageLogic clickSignInBtn() {
        submitAuthorizationFormI(signInButton);
        return page(MainPageLogic.class);
    }

    @Step("Click Sing In button with incorrect data")
    public AuthorizationSecondPage clickSignInBtnWithIncorrectData() {
        submitAuthorizationFormI(signInButton);
        return this;
    }

    @Step("Checking that the validation error is displayed")
    public AuthorizationSecondPage checkValidationEmptyField(String expectedMessage) {
        checkEmptyValidationErrorI(emptyValidationError, emptyValidationIcon, expectedMessage);
        return this;
    }

    @Step("Checking the display of the empty validation error when the field is empty")
    public AuthorizationSecondPage checkValidationEmptyField() {
        checkEmptyValidationErrorI(emptyValidationError, emptyValidationIcon);
        return this;
    }

    @Step("Checking that the \"Empty field\" validation error has disappeared")
    public AuthorizationSecondPage checkDisappearEmptyValidationPlate() {
        checkDisappearEmptyValidationPlateI(emptyValidationError);
        return this;
    }

    @Step("Check the Alert \"incorrect data\" elements are displayed adn text match")
    public AuthorizationSecondPage checkIncorrectDataAlert(String alertTitle, String alertText) {
        checkIncorrectDataAlertI(alertTitle, alertText);
        return this;
    }

    @Step("Checking that a captcha is displayed after an incorrectly entered password")
    public AuthorizationSecondPage checkCaptchaDisplay() {
        captchaImg.shouldBe(Condition.visible);
        return this;
    }
}
