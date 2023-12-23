package pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPageLocators {
    SelenideElement emailInput = $(By.id("ap_email"));
    SelenideElement continueBtn = $(By.id("continue"));
    SelenideElement emptyValidationError = $(By.id("auth-email-missing-alert"));
    SelenideElement emptyValidationIcon = $x("//div[@id='auth-email-missing-alert']//i");
}
