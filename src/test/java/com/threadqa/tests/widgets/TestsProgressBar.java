package com.threadqa.tests.widgets;

import com.threadqa.config.WebDriverProvider;
import io.qameta.allure.*;
import com.threadqa.pages.widgets.ProgressBarPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestsProgressBar extends WebDriverProvider {

    ProgressBarPage progressBarPage = new ProgressBarPage();

    @Feature("Progress Bar")
    @Story("Запуск Progress Bar")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Запуск Progress Bar")
    @CsvSource(value = {
            "29",
            "78"
    })
    @ParameterizedTest
    void startProgressBar(int targetProgress) throws InterruptedException {

        step("Открываем раздел Progress Bar", () -> {
            progressBarPage.openPage();
        });

        step("Нажимаем Start", () -> {
            progressBarPage
                    .checkStartStopButtonName("Start")
                    .clickStart();
        });

        step("Ждем " + targetProgress * 100 + " миллисекунд (до прогресса "
                + targetProgress + "%)", () -> {
            progressBarPage.waiting(targetProgress);
        });

        step("Нажимаем Stop", () -> {
            progressBarPage
                    .checkStartStopButtonName("Stop")
                    .clickStop();
        });

        step("Проверяем, что Progress Bar достигла "
                + targetProgress + "%", () -> {
            progressBarPage
                    .checkProgress(targetProgress);
        });

    }

    @Feature("Progress Bar")
    @Story("Сброс Progress Bar")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Сброс Progress Bar")
    @Test
    void resetProgressBar() {

        step("Предусловия", () -> {

            step("Открываем раздел Progress Bar", () -> {
                progressBarPage.openPage();
            });

            step("Нажимаем Start", () -> {
                progressBarPage
                        .checkStartStopButtonName("Start")
                        .clickStart();
            });

            step("Ждем 1000 миллисекунд (до прогресса 100%)", () -> {
                progressBarPage.waiting(100);
            });

            step("Проверяем, что Progress Bar достигла 100%", () -> {
                progressBarPage
                        .checkProgress(100);
            });

        });

        step("Тестовые шаги", () -> {

            step("Нажимаем Reset", () -> {
                progressBarPage.clickReset();
            });

            step("Проверяем сброс прогресса", () -> {
                progressBarPage
                        .checkProgress(0)
                        .checkStartStopButtonName("Start");
            });

        });

    }

    @Feature("Progress Bar")
    @Story("Проверка цвета прогресса Progress Bar")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка цвета прогресса Progress Bar")
    @ValueSource(strings = {
            "45"
    })
    @ParameterizedTest
    void checkProgressColor(int targetProgress) {
        step("Предусловия", () -> {

            step("Открываем раздел Progress Bar", () -> {
                progressBarPage.openPage();
            });

            step("Нажимаем Start", () -> {
                progressBarPage
                        .checkStartStopButtonName("Start")
                        .clickStart();
            });

            step("Ждем " + targetProgress * 100 + " миллисекунд (до прогресса "
                    + targetProgress + "%)", () -> {
                progressBarPage.waiting(targetProgress);
            });

            step("Нажимаем Stop", () -> {
                progressBarPage
                        .checkStartStopButtonName("Stop")
                        .clickStop();
            });

            step("Проверяем, что Progress Bar достигла "
                    + targetProgress + "%", () -> {
                progressBarPage
                        .checkProgress(targetProgress);
            });

        });

        step("Тестовые шаги", () -> {

            step("Проверяем цвет Progress Bar: должен быть голубой", () -> {
                progressBarPage.checkProgressColor();
            });

        });
    }

    @Feature("Progress Bar")
    @Story("Проверка цвета 100% прогресса Progress Bar")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка цвета 100% прогресса Progress Bar")
    @Test
    void checkFullProgressColor() {

        step("Предусловия", () -> {

            step("Открываем раздел Progress Bar", () -> {
                progressBarPage.openPage();
            });

            step("Нажимаем Start", () -> {
                progressBarPage
                        .checkStartStopButtonName("Start")
                        .clickStart();
            });

            step("Ждем 1000 миллисекунд (до прогресса 100%)", () -> {
                progressBarPage.waiting(100);
            });

            step("Проверяем, что Progress Bar достигла 100%", () -> {
                progressBarPage
                        .checkProgress(100);
            });

        });

        step("Тестовые шаги", () -> {

            step("Проверяем цвет Progress Bar: должен быть зеленый", () -> {
                progressBarPage.checkFullProgressColor();
            });

        });

    }


}
