package com.threadqa.pages.main;

import com.codeborne.selenide.SelenideElement;
import com.threadqa.pages.elements.ButtonsPage;
import com.threadqa.pages.elements.RadioButtonPage;
import com.threadqa.pages.elements.TextBoxPage;
import com.threadqa.pages.forms.PracticeFormPage;
import com.threadqa.pages.interractions.SortablePage;
import com.threadqa.pages.widgets.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Navigation {
    private static SelenideElement
            elements = $x("//h5[text()='Elements']"),
            forms = $x("//h5[text()='Forms']"),
            alrts = $x("//h5[text()='Alerts, Frame & Windows']"),
            widgets = $x("//h5[text()='Widgets']"),
            interactions = $x("//h5[text()='Interactions']");

    public static PracticeFormPage goToPracticeForm() {
        forms.click();
        $(byText("Practice Form")).click();
        return new PracticeFormPage();
    }

    public static ButtonsPage goToButtonsPage() {
        elements.click();
        $(byText("Buttons")).click();
        return new ButtonsPage();
    }

    public static RadioButtonPage goToRadioButtonsPage() {
        elements.click();
        $(byText("Radio Button")).click();
        return new RadioButtonPage();
    }
    public static TextBoxPage goToTextBoxPage(){
        elements.click();
        $(byText("Text Box")).click();
        return new TextBoxPage();
    }

    public static SortablePage goToSortablePage(){
        interactions.click();
        $(byText("Sortable")).click();
        return new SortablePage();
    }

    public static AutoCompletePage goToAutoCompletePage(){
        widgets.click();
        $(byText("Auto Complete")).click();
        return new AutoCompletePage();
    }

    public static DatePickerPage goToDatePickerPage(){
        widgets.click();
        $(byText("Date Picker")).click();
        return new DatePickerPage();
    }

    public static ProgressBarPage goToProgressBarPage(){
        widgets.click();
        $(byText("Progress Bar")).click();
        return new ProgressBarPage();
    }

    public static SliderPage goToSliderPage(){
        widgets.click();
        $(byText("Slider")).click();
        return new SliderPage();
    }

    public static TabsPage goToTabsPage(){
        widgets.click();
        $(byText("Tabs")).click();
        return new TabsPage();
    }

    public static ToolTipsPage goToToolTipsPage(){
        widgets.click();
        $(byText("Tool Tips")).click();
        return new ToolTipsPage();
    }
}
