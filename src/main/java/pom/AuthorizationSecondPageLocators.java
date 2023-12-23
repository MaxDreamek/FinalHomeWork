package pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationSecondPageLocators {
    SelenideElement passwordEmail = $(By.id("ap_password"));
    SelenideElement signInButton = $(By.id("signInSubmit"));
    SelenideElement emptyValidationError = $(By.id("auth-password-missing-alert"));
    SelenideElement emptyValidationIcon = $x("//div[@id='auth-password-missing-alert']//i");
    SelenideElement captchaImg = $x("//img[@alt='captcha']");
}
