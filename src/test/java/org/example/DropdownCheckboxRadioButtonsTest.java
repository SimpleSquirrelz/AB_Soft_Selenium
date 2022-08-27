package org.example;

import org.example.pages.DropdownCheckboxRadioButtonsPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class DropdownCheckboxRadioButtonsTest extends BaseTest{

    @Test
    public void shouldUseAllInputs() {
        DropdownCheckboxRadioButtonsPage dchrbPage = (DropdownCheckboxRadioButtonsPage) homePage.clickOnSectionWithTitle("DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)");
        dchrbPage.selectDropdownOption(1,"Java")
                .selectDropdownOption(2, "TestNG")
                .selectDropdownOption(3, "HTML")
                .deselectAllCheckboxes()
                .toggleCheckbox(0)
                .toggleCheckbox(3)
                .selectRadiobutton("orange");

        var checkBoxes = dchrbPage.getSelectedAndDisabledSectionRadioButtons();
        assertEquals(checkBoxes.get(1).getAttribute("disabled"), "true", "Radio button should be disabled");
        assertEquals(checkBoxes.get(2).getAttribute("checked"), "true", "Radio button should be checked");

        var selectOptions = dchrbPage.getSelectedAndDisabledSectionSelectOptions();
        assertEquals(selectOptions.get(1).getAttribute("disabled"), "true", "Option should be disabled");
        assertEquals(selectOptions.get(3).getAttribute("selected"), "true", "Option should be selected");
    }
}
