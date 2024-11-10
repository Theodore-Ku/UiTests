package com.threadqa.tests.widgets;

import com.threadqa.config.WebDriverProvider;
import io.qameta.allure.*;
import com.threadqa.pages.widgets.TabsPage;
import com.threadqa.tests.TestDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class TestsTabs extends WebDriverProvider {

    TabsPage tabsPage = new TabsPage();
    TestDate testDate = new TestDate();

    @Feature("Tabs")
    @Story("Проверка описания раздела Tabs")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка описания раздела Tabs")
    @Test
    void checkSectionDescription() {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Проверяем описание раздела Tabs", () -> {
            tabsPage.checkDescription();
        });

    }

    @Feature("Tabs")
    @Story("Проверка наличия раздела в Tabs")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия раздела в Tabs")
    @ValueSource(strings = {
            "What",
            "Origin",
            "Use",
            "More"
    })
    @ParameterizedTest
    void checkTabs(String tabName) {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Проверяем наличие раздела " + tabName + " в Tabs", () -> {
            tabsPage.shouldHaveTab(tabName);
        });

    }

    @Feature("Tabs")
    @Story("Проверка недоступности вкладки More для клика")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка недоступности вкладки More для клика")
    @ValueSource(strings = {
            "More"
    })
    @ParameterizedTest
    void checkTabShouldBeDisabled(String tabName) {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Проверяем, что вкладка " + tabName + " не доступна для клика", () -> {
            tabsPage
                    .tabShouldBeDisabled(tabName);
        });
    }

    static Stream<Arguments> checkOneTabActiveAndOthersHidden() {
        return Stream.of(
                Arguments.of("What", new String[]{"Origin", "Use", "More"}),
                Arguments.of("Origin", new String[]{"What", "Use", "More"}),
                Arguments.of("Use", new String[]{"What", "Origin", "More"})
        );
    }

    @Feature("Tabs")
    @Story("Проверка, что при открытии одной вкладки, текст остальных вкладкок скрыт")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка, что при открытии одной вкладки, текст остальных вкладкок скрыт")
    @MethodSource()
    @ParameterizedTest
    void checkOneTabActiveAndOthersHidden(String activeTab, String[] hiddenTabs) {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Нажимаем на вкладку " + activeTab, () -> {
            tabsPage
                    .clickTab(activeTab)
                    .tabShouldBeActive(activeTab);
        });

        step("Проверяем, что другие вкладки " + Arrays.toString(hiddenTabs) + " не активны", () -> {
            tabsPage
                    .tabsShouldBeAHidden(hiddenTabs);
        });
    }

    @Feature("Tabs")
    @Story("Проверка текста в открытой вкладке")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка текста в открытой вкладке")
    @ValueSource(strings = {
            "What",
            "Origin",
            "Use"
    })
    @ParameterizedTest
    void checkTabText(String tabName) {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Нажимаем на вкладку " + tabName, () -> {
            tabsPage
                    .clickTab(tabName)
                    .tabShouldBeActive(tabName);
        });

        step("Проверяем текст на вкладке " + tabName, () -> {
            tabsPage.checkTabText(testDate.tabs, tabName);
        });
    }

}
