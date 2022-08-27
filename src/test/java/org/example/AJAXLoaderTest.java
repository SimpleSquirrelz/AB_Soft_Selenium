package org.example;

import org.example.pages.AJAXLoaderPage;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class AJAXLoaderTest extends BaseTest{
    @Test
    public void shouldWaitUtilAJAXResponseIsGet(){
        String expectedAlertText = "Well Done For Waiting....!!!";
        AJAXLoaderPage ajaxLoaderPage = (AJAXLoaderPage) homePage.clickOnSectionWithTitle("AJAX LOADER");

        var modalWindow = ajaxLoaderPage.clickButton();
        String actualAlertText = modalWindow.getHeaderText();
        modalWindow.closeModal();

        assertEquals(ajaxLoaderPage.isModalDisplayed(),false, "Modal window should be closed");
        assertEquals(actualAlertText,expectedAlertText,"Modal window text is invalid");
    }
}
