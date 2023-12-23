package pom;

import interfaces.IAuthorization;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage extends AuthorizationPageLocators implements IAuthorization {
    @Step("Fill the email input with value")
    public AuthorizationPage fillEmailInput(String email) {
        fillAuthorizationInputI(emailInput, email);
        return this;
    }

    @Step("Click on the Continue button and go to the next authorization page")
    public AuthorizationSecondPage clickContinueBtn() {
        submitAuthorizationFormI(continueBtn);
        return page(AuthorizationSecondPage.class);
    }

    @Step("Click Continue button and stay on the page")
    public AuthorizationPage clickContinueBtnWithIncorrectData() {
        submitAuthorizationFormI(continueBtn);
        return this;
    }

    @Step("Checking that the validation error is displayed")
    public AuthorizationPage checkValidationEmptyField(String expectedErrorText) {
        checkEmptyValidationErrorI(emptyValidationError, emptyValidationIcon, expectedErrorText);
        return this;
    }

    @Step("Checking the display of the empty validation error when the field is empty")
    public AuthorizationPage checkValidationEmptyField() {
        checkEmptyValidationErrorI(emptyValidationError, emptyValidationIcon);
        return this;
    }

    @Step("Check the Alert \"incorrect data\" elements are displayed adn text match")
    public AuthorizationPage checkIncorrectDataAlert(String alertTitle, String alertText) {
        checkIncorrectDataAlertI(alertTitle, alertText);
        return this;
    }

    @Step("Check that the Alert \"incorrect data\" is displayed")
    public AuthorizationPage checkIncorrectDataAlertPresent() {
        checkIncorrectDataAlertDisplayI();
        return this;
    }

    @Step("Check that the Alert \"incorrect data\" is disappeared")
    public AuthorizationPage checkDisappearIncorrectDataAlert() {
        checkDisappearIncorrectDataAlertI();
        return this;
    }

    @Step("Checking that the \"Empty field\" validation error has disappeared")
    public AuthorizationPage checkDisappearEmptyValidationPlate() {
        checkDisappearEmptyValidationPlateI(emptyValidationError);
        return this;
    }
}
