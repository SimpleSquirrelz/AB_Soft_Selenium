package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownCheckboxRadioButtonsPage extends BasePage {
    private String DROPDOWN = "#dropdowm-menu-%d";
    private String RADIO_BUTTONS = "//*[@id='radio-buttons']//input[@value='%s']";
    private By checkboxes = By.xpath("//*[@id='checkboxes']//input");
    private By selectAndDisabledRadioButtons = By.xpath("//*[@id='radio-buttons-selected-disabled']//input");
    private By selectAndDisabledSelectOptions = By.xpath("//*[@id='fruit-selects']//option");


    public DropdownCheckboxRadioButtonsPage(WebDriver driver) {
        super(driver);
    }

    public DropdownCheckboxRadioButtonsPage selectDropdownOption(int dropdownNumber, String option){
        Select select = new Select(driver.findElement(By.cssSelector(String.format(DROPDOWN,dropdownNumber))));
        select.selectByValue(option.toLowerCase());
        return this;
    }

    public List<WebElement> getAllCheckboxes(){
        return driver.findElements(checkboxes);
    }

    public DropdownCheckboxRadioButtonsPage deselectAllCheckboxes(){
        getAllCheckboxes().forEach(checkbox -> {
            if(checkbox.getAttribute("checked") != null)
                checkbox.click();
        });
        return this;
    }

    public DropdownCheckboxRadioButtonsPage toggleCheckbox(int index){
        getAllCheckboxes().get(index).click();
        return this;
    }

    public DropdownCheckboxRadioButtonsPage selectRadiobutton(String optionText){
        driver.findElement(By.xpath(String.format(RADIO_BUTTONS, optionText)));
        return this;
    }

    public List<WebElement> getSelectedAndDisabledSectionRadioButtons(){
        return driver.findElements(selectAndDisabledRadioButtons);
    }

    public List<WebElement> getSelectedAndDisabledSectionSelectOptions(){
        return driver.findElements(selectAndDisabledSelectOptions);
    }
}
