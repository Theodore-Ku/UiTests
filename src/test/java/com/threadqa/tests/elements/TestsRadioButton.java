package com.threadqa.tests.elements;

import com.threadqa.config.WebDriverProvider;
import io.qameta.allure.*;
import com.threadqa.pages.elements.RadioButtonPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestsRadioButton extends WebDriverProvider {

    RadioButtonPage radioButtonPage = new RadioButtonPage();

    @Feature("Radio Button")
    @Story("Переключение радиобаттонов и проверка вывода результата")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Нажатие на Radio и проверка вывода результата")
    @ValueSource(strings = {
            "Yes",
            "Impressive",
            "No"
    })
    @ParameterizedTest
    void clickOnRadioButton(String radioName) {

        step("Открываем форму", () -> {
            radioButtonPage.openPage();
        });

        step("Нажимаем на переключатель " + "'" + radioName + "'", () -> {
            radioButtonPage.clickRadio(radioName);
        });

        step("Проверяем отображение в поле результата текста: " +
                "You have selected " + radioName, () -> {
            radioButtonPage.checkResult(radioName);
        });

    }

}
