package com.threadqa.tests.widgets;

import com.threadqa.config.WebDriverProvider;
import io.qameta.allure.*;
import com.threadqa.pages.widgets.DatePickerPage;
import com.threadqa.tests.TestDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsDatePicker extends WebDriverProvider {

    DatePickerPage datePickerPage = new DatePickerPage();
    TestDate testDate = new TestDate();

    @Feature("Date Picker")
    @Story("Выбор даты в поле Select Date")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Выбор даты в поле Select Date")
    @Test
    void selectDate() {

        step("Открываем раздел Date Picker", () -> {
            datePickerPage.openPage();
        });

        step("Выбираем дату в поле Select Date", () -> {
            datePickerPage
                    .selectDate(testDate.day, testDate.month, testDate.year);
        });

        step("Проверяем дату, зафиксированную в поле Select Date", () -> {
            datePickerPage
                    .checkSelectDateResult(testDate.day, testDate.month, testDate.year);
        });

    }

    @Feature("Date Picker")
    @Story("Выбор даты в поле Date And Time")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Выбор даты в поле Date And Time")
    @Test
    void selectDateAndTime() {

        step("Открываем раздел Date Picker", () -> {
            datePickerPage.openPage();
        });

        step("Выбираем дату и время в поле Date And Time", () -> {
            datePickerPage
                    .selectDateAndTime(testDate.day, testDate.month,
                            testDate.year, testDate.time);
        });

        step("Проверяем дату и время, зафиксированные в поле Date And Time", () -> {
            datePickerPage
                    .checkSelectDateAndTimeResult(testDate.day, testDate.month,
                            testDate.year, testDate.time);
        });

    }

}
