package com.threadqa.tests.elements;

import com.threadqa.config.WebDriverProvider;
import io.qameta.allure.*;
import com.threadqa.pages.elements.TextBoxPage;
import com.threadqa.tests.TestDate;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsTextBox extends WebDriverProvider {

    TextBoxPage textBoxPage = new TextBoxPage();
    TestDate testDate = new TestDate();

    @Feature("Text Box")
    @Story("Отправка валидно заполненной формы")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void sendFormWithValidData() {

        step("Открываем форму", () -> {
            textBoxPage.openPage();
        });

        step("Заполняем поля формы валидными данными", () -> {
            textBoxPage.
                    setFullName(testDate.fullName).
                    setEmail(testDate.validEmail).
                    setCurrentAddress(testDate.currentAddress).
                    setPermanentAddress(testDate.permanentAddress);
        });

        step("Нажимаем кнопку Submit", () -> {
            textBoxPage.clickSubmit();
        });

        step("Проверяем вывод в поле с результатами", () -> {
            textBoxPage
                    .isResultsFieldVisible()
                    .checkResult("Name:", testDate.fullName)
                    .checkResult("Email:", testDate.validEmail)
                    .checkResult("Current Address :", testDate.currentAddress)
                    .checkResult("Permananet Address :", testDate.permanentAddress);
        });

    }

    @Feature("Text Box")
    @Story("Отправка пустой формы")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void sendEmptyForm() {

        step("Открываем форму", () -> {
            textBoxPage.openPage();
        });

        step("Нажимаем кнопку Submit", () -> {
            textBoxPage.clickSubmit();
        });

        step("Проверяем, что поле с результатами пустое", () -> {
            textBoxPage
                    .isResultsFieldVisible()
                    .isResultFieldEmpty();
        });

    }

    @Feature("Text Box")
    @Story("Отправка формы с невалидным email")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void sendFormWithInvalidEmail() {

        step("Открываем форму", () -> {
            textBoxPage.openPage();
        });

        step("Заполняем поля формы (в поле Email указываем невалидный email)", () -> {
            textBoxPage.
                    setFullName(testDate.fullName).
                    setEmail(testDate.invalidEmail).
                    setCurrentAddress(testDate.currentAddress).
                    setPermanentAddress(testDate.permanentAddress);
        });

        step("Нажимаем кнопку Submit", () -> {
            textBoxPage.clickSubmit();
        });

        step("Проверяем, что поле Email подсветилось красным", () -> {
            textBoxPage.isEmailInputWrong();
        });

        step("Проверяем отсутствие поля с результатами", () -> {
            textBoxPage.isResultsFieldHidden();
        });

    }

}
