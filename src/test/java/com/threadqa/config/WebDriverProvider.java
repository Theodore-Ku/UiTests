package com.threadqa.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.threadqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebDriverProvider {

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "http://85.192.34.140:8081";
        Configuration.pageLoadTimeout = 50000;
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    /**
     * Добавляем логирование в Allure после выполнения теста
     */
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
    }

}
