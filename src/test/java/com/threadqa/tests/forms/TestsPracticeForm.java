package com.threadqa.tests.forms;

import com.threadqa.config.WebDriverProvider;
import com.threadqa.tests.TestDate;
import io.qameta.allure.*;
import com.threadqa.pages.forms.PracticeFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsPracticeForm extends WebDriverProvider {

    PracticeFormPage registrationFormPage = new PracticeFormPage();
    TestDate testDate = new TestDate();

    @Feature("Practice Form")
    @Story("Заполнение полей формы и проверка вывода результата")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение ВСЕХ полей Practice Form и проверка вывода результата")
    @Test
    void fillPracticeFormWithAllData() {

        step("Открываем форму", () -> {
            registrationFormPage.openPage();
        });

        step("Заполняем поля формы", () -> {
            registrationFormPage
                    .setFirstName(testDate.firstName)
                    .setLastName(testDate.lastName)
                    .setEmail(testDate.validEmail)
                    .setGender(testDate.gender)
                    .setUserNumber(testDate.phoneNumber)
                    .setBirthDate(testDate.day, testDate.month, testDate.year)
                    .setSubjects(testDate.subjects)
                    .setHobbies(testDate.hobbies)
                    .choosePicture(testDate.pictureName)
                    .setCurrentAddress(testDate.currentAddress)
                    .setState(testDate.state)
                    .setCity(testDate.city);
        });

        step("Нажимаем кнопку Submit", () -> {
            registrationFormPage.clickSubmit();
        });

        step("Проверяем, появилась ли таблица с результатами", () -> {
            registrationFormPage.isResultsTableVisible();
        });

        step("Проверяем вывод результата", () -> {
            registrationFormPage
                    .checkResult("Student Name", testDate.firstName + " " + testDate.lastName)
                    .checkResult("Student Email", testDate.validEmail)
                    .checkResult("Gender", testDate.gender)
                    .checkResult("Mobile", testDate.phoneNumber)
                    .checkResult("Date of Birth",
                            testDate.day + " " + testDate.month + "," + testDate.year)
                    .checkResultArray("Subjects", testDate.subjects)
                    .checkResultArray("Hobbies", testDate.hobbies)
                    .checkResult("Picture", testDate.pictureName)
                    .checkResult("Address", testDate.currentAddress)
                    .checkResult("State and City", testDate.state + " " + testDate.city);
        });
    }

    @Feature("Practice Form")
    @Story("Заполнение полей формы и проверка вывода результата")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение МИНИМАЛЬНО требуемых полей Practice Form и проверка вывода результата")
    @Test
    @Tag("minimum_of_tests")
    void fillPracticeFormWithMinimumData() {

        step("Открываем форму", () -> {
            registrationFormPage.openPage();
        });

        step("Заполняем поля формы", () -> {
            registrationFormPage
                    .setFirstName(testDate.firstName)
                    .setLastName(testDate.lastName)
                    .setGender(testDate.gender)
                    .setUserNumber(testDate.phoneNumber);
        });

        step("Нажимаем кнопку Submit", () -> {
            registrationFormPage.clickSubmit();
        });

        step("Проверяем, появилась ли таблиица с результатами", () -> {
            registrationFormPage.isResultsTableVisible();
        });

        step("Проверяем вывод результата", () -> {
            registrationFormPage
                    .checkResult("Student Name", testDate.firstName + " " + testDate.lastName)
                    .checkResult("Gender", testDate.gender)
                    .checkResult("Mobile", testDate.phoneNumber);
        });
    }
}
