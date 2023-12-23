package interfaces;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public interface IHeader {
    SelenideElement ACCOUNT_NAV_LINK = $(By.id("nav-link-accountList"));
    SelenideElement SIGN_IN_BTN = $x("//div[@id='nav-al-signin']//span");
    SelenideElement ACCOUNT_DROPDOWN = $(By.id("nav-al-container"));
    SelenideElement USER_GREETING = $(By.id("nav-link-accountList-nav-line-1"));

    default void openAccountPopUpI() {
        ACCOUNT_NAV_LINK.hover();
        ACCOUNT_DROPDOWN.shouldBe(Condition.visible);
    }

    @Step("Click on the Sign In button in the header or in the Account & Lists dropdown")
    default void clickSignInBtnI(boolean isItDropDown) {
        if (isItDropDown) {
            SIGN_IN_BTN.shouldBe(Condition.enabled).click();
        } else {
            ACCOUNT_NAV_LINK.shouldBe(Condition.enabled).click();
        }
    }
    @Step("Get the user's greeting text in Header")
    default String getUserGreeting(){
        return USER_GREETING.shouldBe(Condition.appear).getText();
    }
}
