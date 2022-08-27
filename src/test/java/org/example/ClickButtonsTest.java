package org.example;

import org.example.pages.ClickButtonsPage;
import org.testng.annotations.Test;

public class ClickButtonsTest extends BaseTest {

    @Test
    public void shouldClickAllButtons() {
        ClickButtonsPage clickButtonsPage = (ClickButtonsPage) homePage.clickOnSectionWithTitle("BUTTON CLICKS");
        clickButtonsPage.actionClick().closeModal()
                .webElementClick().closeModal()
                .jsClick().closeModal();
    }
}
