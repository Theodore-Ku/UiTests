package com.threadqa.tests.widgets;

import com.threadqa.config.WebDriverProvider;
import com.threadqa.helpers.ColorFieldsTypes;
import com.threadqa.pages.widgets.AutoCompletePage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class TestsAutoComplete extends WebDriverProvider {

    AutoCompletePage autoCompletePage = new AutoCompletePage();

    @ValueSource(strings = {
            "blue",
            "white"
    })
    @ParameterizedTest
    void typeValidColorInSingleField(String value) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле валидное значение цвета: " + value, () ->
                autoCompletePage.typeOneColor(ColorFieldsTypes.Single, value)
        );

        step("Проверяем закрепление цвета в поле", () ->
                autoCompletePage.colorShouldBeFixed(ColorFieldsTypes.Single, value)
        );

    }

    @ValueSource(strings = {
            "sun"
    })
    @ParameterizedTest
    void typeInvalidColorInSingleField(String value) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле невалидное значение цвета: " + value, () ->
                autoCompletePage.typeOneColor(ColorFieldsTypes.Single, value)
        );

        step("Проверяем, что введенный цвет в поле не закрепился", () ->
                autoCompletePage.colorShouldNOTBeFixed(ColorFieldsTypes.Single, value)
        );

    }

    static Stream<Arguments> typeValidColorInMultipleField() {
        return Stream.of(
                Arguments.of(List.of("white", "black", "green", "purple", "yellow"))
        );
    }

    @MethodSource()
    @ParameterizedTest
    void typeValidColorInMultipleField(List<String> values) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле валидные значение цвета: " + values, () ->
                autoCompletePage.typeSomeColors(ColorFieldsTypes.Multiple, values)
        );

        step("Проверяем закрепление введенных цветов в поле", () ->
                autoCompletePage.someColorsShouldBeFixed(ColorFieldsTypes.Multiple, values)
        );

    }

    static Stream<Arguments> typeInvalidColorInMultipleField() {
        return Stream.of(
                Arguments.of(List.of("sun", "moon", "hello"))
        );
    }

    @MethodSource()
    @ParameterizedTest
    void typeInvalidColorInMultipleField(List<String> values) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле невалидные значения цвета: " + values, () ->
                autoCompletePage.typeSomeColors(ColorFieldsTypes.Multiple, values)
        );

        step("Проверяем, что введенные цвета в поле не закрепились", () ->
                autoCompletePage.someColorShouldNOTBeFixed(ColorFieldsTypes.Multiple, values)
        );

    }

    @CsvSource(value = {
            "sun, white"
    })
    @ParameterizedTest
    void typeInvalidAndThenValidColor1(String inValidValue, String validValue) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле невалидное значение цвета: " + inValidValue, () ->
                autoCompletePage.typeOneColor(ColorFieldsTypes.Multiple, inValidValue)
        );

        step("Проверяем, что введенное невалидное значение цвета в поле не закрепилось", () ->
                autoCompletePage.colorShouldNOTBeFixed(ColorFieldsTypes.Multiple, inValidValue)
        );

        step("Вводим в поле валидное значение цвета: " + validValue, () ->
                autoCompletePage.typeOneColor(ColorFieldsTypes.Multiple, validValue)
        );

        step("Проверяем, что введенное валидное значение цвета в поле не закрепилось", () ->
                autoCompletePage.colorShouldNOTBeFixed(ColorFieldsTypes.Multiple, validValue)
        );
    }

    @CsvSource(value = {
            "sun, white"
    })
    @ParameterizedTest
    void typeInvalidAndThenValidColor2(String inValidValue, String validValue) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле невалидное значение цвета: " + inValidValue, () ->
                autoCompletePage.typeOneColor(ColorFieldsTypes.Multiple, inValidValue)
        );

        step("Проверяем, что введенное невалидное значение цвета в поле не закрепилось", () ->
                autoCompletePage.colorShouldNOTBeFixed(ColorFieldsTypes.Multiple, inValidValue)
        );

        step("Удаляем из поля невалидное значение цвета кнопкой Backspace", () ->
                autoCompletePage.clearInputValueByBackspace(ColorFieldsTypes.Multiple, inValidValue)
        );

        step("Вводим в поле валидное значение цвета: " + validValue, () ->
                autoCompletePage.typeOneColor(ColorFieldsTypes.Multiple, validValue)
        );

        step("Проверяем, что введенное валидное значение цвета в поле закрепилось", () ->
                autoCompletePage.colorShouldBeFixed(ColorFieldsTypes.Multiple, validValue)
        );

    }

}
