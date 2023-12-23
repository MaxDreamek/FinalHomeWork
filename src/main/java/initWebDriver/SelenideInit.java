package initWebDriver;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import enums.UserAgent;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class SelenideInit {
    public final String AMZ_CAPTCHA1;
    public final String AMZ_CAPTCHA2;
    public final String CSM_HIT;
    public final String CP_CDN;
    private final ChromeOptions chromeOptions = new ChromeOptions();

    {
        AMZ_CAPTCHA1 = "1703348602017600";
        AMZ_CAPTCHA2 = "po9MXuDzlbwxraqnNDQqMg==";
        CSM_HIT = "tb:37TQHCGQ5T26SFX9R4CW+s-37TQHCGQ5T26SFX9R4CW|1703341431149&t:1703341431149&adb:adblk_yes";
        CP_CDN = "\"L5Z9:UA\"";
    }

    @BeforeMethod
    public void selenideSetUp() {
        Configuration.reportsFolder = "target/reports";
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-automation");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("disable-infobars");
        Configuration.browserSize = "3200х2000";
        chromeOptions.addArguments("user-agent=" + selectRandomUserAgent());
        Configuration.timeout = 5000;
        Configuration.browserCapabilities = chromeOptions;
    }

    @AfterMethod
    public void closeDriver() {
        Selenide.closeWebDriver();
    }

    private static String selectRandomUserAgent() {
        int value = (int) (Math.random() * UserAgent.values().length);
        List<UserAgent> userAgents = List.of(UserAgent.values());
        return userAgents.get(value).value;
    }

    public void changeCookie() {
        Cookie cookie = new Cookie("x-amz-captcha-1", AMZ_CAPTCHA1);
        getWebDriver().manage().addCookie(cookie);
        Cookie cookie2 = new Cookie("x-amz-captcha-2", AMZ_CAPTCHA2);
        getWebDriver().manage().addCookie(cookie2);
        Cookie cookie3 = new Cookie("csm-hit", CSM_HIT);
        getWebDriver().manage().addCookie(cookie3);
        Cookie cookie4 = new Cookie("sp-cdn", CP_CDN);
        getWebDriver().manage().addCookie(cookie4);
        getWebDriver().navigate().refresh();
    }
}
