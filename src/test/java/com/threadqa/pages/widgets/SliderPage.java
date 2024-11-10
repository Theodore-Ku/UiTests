package com.threadqa.pages.widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.threadqa.pages.main.Navigation;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.threadqa.pages.main.Navigation.goToSliderPage;

public class SliderPage {

    private SelenideElement
            slider = $(".range-slider"),
            valueInput = $("#sliderValue");

    private final static String TITLE_TEXT = "Slider";

    public SliderPage openPage() {
        open("/");
        goToSliderPage();
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public SliderPage moveSliderRight(int newValue) {
        int currentValue = Integer.parseInt(slider.getAttribute("value"));
        int differenceOfValues = newValue - currentValue;
        for (int i = 0; i < differenceOfValues; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    public SliderPage moveSliderLeft(int newValue) {
        int currentValue = Integer.parseInt(slider.getAttribute("value"));
        int differenceOfValues = currentValue - newValue;
        for (int i = 0; i < differenceOfValues; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        return this;
    }

    public SliderPage checkSliderPosition(int value) {
        slider.shouldHave(attribute("value", value+""));
        valueInput.shouldHave(attribute("value", value+""));
        return this;
    }




}
