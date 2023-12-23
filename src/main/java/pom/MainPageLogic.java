package pom;


import interfaces.IHeader;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic implements IHeader {

    @Step("Open Account & Lists pop-up")
    public MainPageLogic openAccountPopUp() {
        openAccountPopUpI();
        return this;
    }

    @Step("Click on the Sign In button in the header or in the Account & Lists dropdown")
    public AuthorizationPage clickSignInBtn(boolean isItDropDown) {
        clickSignInBtnI(isItDropDown);
        return page(AuthorizationPage.class);
    }
}
