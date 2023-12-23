package authorizationTests;

import enums.SiteUrl;
import initWebDriver.SelenideInit;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.MainPageLogic;

import static com.codeborne.selenide.Selenide.open;

public class UserAuthorizationTest extends SelenideInit {
    private final String EXPECTED_USER_GREETING = "Hello, Max";

    @Test(dataProvider = "Authorization data")
    @Owner("Max")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test checking authorization")
    public void positiveAuthorizationTest( String emailAndPhone, String password) {
        open(SiteUrl.MAIN.url);
        changeCookie();
        String userGreeting = new MainPageLogic().openAccountPopUp()
                .clickSignInBtn(true)
                .fillEmailInput(emailAndPhone)
                .clickContinueBtn()
                .fillPasswordInput(password)
                .clickSignInBtn()
                .getUserGreeting();
        Assert.assertEquals(userGreeting, EXPECTED_USER_GREETING);
    }

    @DataProvider(name = "Authorization data")
    private Object[][] myData(){
        return new Object[][]{{"avardn@gmail.com", "123456"},{"0635138129", "123456"}};
    }
}
