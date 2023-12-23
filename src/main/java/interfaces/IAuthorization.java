package interfaces;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public interface IAuthorization {
    SelenideElement INCORRECT_EMAIL_ALERT_TITLE = $x("//div[@id='auth-error-message-box']//h4");
    SelenideElement INCORRECT_EMAIL_ALERT_ICON = $x("//div[@id='auth-error-message-box']//i");
    SelenideElement INCORRECT_EMAIL_ALERT_TEXT = $x("//div[@id='auth-error-message-box']//span");

    @Step("Fill in the authorization field with the text")
    default void fillAuthorizationInputI(SelenideElement input, String email) {
        input.shouldBe(Condition.enabled).setValue(email);
    }

    @Step("Submitting an authorization form")
    default void submitAuthorizationFormI(SelenideElement submitInput) {
        submitInput.shouldBe(Condition.enabled).submit();
    }
    @Step("Check the Alert \"incorrect data\" elements are displayed adn text match")
    default void checkIncorrectDataAlertI(String alertTitle, String alertText){
        checkIncorrectDataAlertDisplayI();
        checkIncorrectDataAlertTextI(alertTitle, alertText);
    }
    @Step("Check the Alert \"incorrect data\" title and text match")
    default void checkIncorrectDataAlertTextI(String alertTitle, String alertText){
        INCORRECT_EMAIL_ALERT_TITLE.shouldHave(Condition.text(alertTitle));
        INCORRECT_EMAIL_ALERT_TEXT.shouldHave(Condition.text(alertText));
    }
    @Step("Check that the Alert \"incorrect data\" is displayed")
    default void checkIncorrectDataAlertDisplayI(){
        INCORRECT_EMAIL_ALERT_TITLE.shouldBe(Condition.visible);
        INCORRECT_EMAIL_ALERT_ICON.shouldBe(Condition.visible);
        INCORRECT_EMAIL_ALERT_TEXT.shouldBe(Condition.visible);
    }
    @Step("Check that the Alert \"incorrect data\" is disappeared")
    default void checkDisappearIncorrectDataAlertI(){
        INCORRECT_EMAIL_ALERT_TITLE.shouldBe(Condition.disappear);
        INCORRECT_EMAIL_ALERT_ICON.shouldBe(Condition.disappear);
        INCORRECT_EMAIL_ALERT_TEXT.shouldBe(Condition.disappear);
    }
    @Step("Checking the display of the empty validation error and text when the field is empty")
    default void checkEmptyValidationErrorI(SelenideElement validationError, SelenideElement validationIcon, String validationText) {
        validationError.shouldBe(Condition.visible).shouldHave(Condition.text(validationText));
        validationIcon.shouldBe(Condition.visible);
    }
    @Step("Checking the display of the empty validation error when the field is empty")
    default void checkEmptyValidationErrorI(SelenideElement validationError, SelenideElement validationIcon) {
        validationError.shouldBe(Condition.visible);
        validationIcon.shouldBe(Condition.visible);
    }
    @Step("Checking that the \"Empty field\" validation error has disappeared")
    default void checkDisappearEmptyValidationPlateI(SelenideElement errorPlate){
        errorPlate.shouldBe(Condition.disappear);
    }

}
