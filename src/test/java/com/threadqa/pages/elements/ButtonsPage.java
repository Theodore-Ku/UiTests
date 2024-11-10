package com.threadqa.pages.elements;

import com.threadqa.pages.components.ClickComponent;
import com.threadqa.pages.main.Navigation;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.threadqa.pages.main.Navigation.goToButtonsPage;
import static com.threadqa.pages.main.Navigation.goToRadioButtonsPage;

public class ButtonsPage {

    ClickComponent clickComponent = new ClickComponent();

    private final static String TITLE_TEXT = "Buttons";

    public ButtonsPage openPage() {
        open("/");
        goToButtonsPage();
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public ButtonsPage clickButton(String buttonName) {
        clickComponent.clickButton(buttonName);
        return this;
    }

    public ButtonsPage checkResultOfButtonClick(String buttonName) {
        clickComponent.checkClickOnButton(buttonName);
        return this;
    };

}
