package org.example;

import org.example.pages.LoginPortalPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class LoginPortalTest extends BaseTest {

    @Test
    public void shouldLoginWithVaslidCredentials(){
        String expectedMessage = "validation succeeded";
        LoginPortalPage loginPortalPage = (LoginPortalPage) homePage.clickOnSectionWithTitle("LOGIN PORTAL");

        loginPortalPage.enterUsername("webdriver").enterPassword("webdriver123").submitForm();
        assertEquals(loginPortalPage.getAlertText(), expectedMessage, "Validation failed");
    }

    @Test
    public void shouldFailAuthorizationWithNoPassword(){
        String expectedMessage = "validation failed";
        LoginPortalPage loginPortalPage = (LoginPortalPage) homePage.clickOnSectionWithTitle("LOGIN PORTAL");

        loginPortalPage.enterUsername("webdriver").submitForm();
        assertEquals(loginPortalPage.getAlertText(), expectedMessage, "Validation should fail");
    }
}
