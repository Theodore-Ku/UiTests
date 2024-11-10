package com.threadqa.tests.widgets;

import com.threadqa.config.WebDriverProvider;
import io.qameta.allure.*;
import com.threadqa.pages.widgets.SliderPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

public class TestsSlider extends WebDriverProvider {

    SliderPage sliderPage = new SliderPage();

    @Feature("Slider")
    @Story("Перемещение слайдера ВПРАВО")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Перемещение слайдера ВПРАВО")
    @CsvSource(value = {
            "68",
            "100"
    })
    @ParameterizedTest
    void moveSliderRight(int newValue) {

        step("Открываем раздел Slider", () -> {
            sliderPage.openPage();
        });

        step("Проверяем начальную позицию слайдера: должна быть 25", () -> {
            sliderPage.checkSliderPosition(25);
        });

        step("Перемещаем слайдер в новую позицию: " + newValue, () -> {
            sliderPage.moveSliderRight(newValue);
        });

        step("Проверяем новую позицию слайдера: должна быть " + newValue, () -> {
            sliderPage.checkSliderPosition(newValue);
        });

    }

    @Feature("Slider")
    @Story("Перемещение слайдера ВЛЕВО")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Перемещение слайдера ВЛЕВО")
    @CsvSource(value = {
            "13",
            "0"
    })
    @ParameterizedTest
    void moveSliderLeft(int newValue) {

        step("Открываем раздел Slider", () -> {
            sliderPage.openPage();
        });

        step("Проверяем начальную позицию слайдера: должна быть 25", () -> {
            sliderPage.checkSliderPosition(25);
        });

        step("Перемещаем слайдер в новую позицию: " + newValue, () -> {
            sliderPage.moveSliderLeft(newValue);
        });

        step("Проверяем новую позицию слайдера: должна быть " + newValue, () -> {
            sliderPage.checkSliderPosition(newValue);
        });

    }

}
