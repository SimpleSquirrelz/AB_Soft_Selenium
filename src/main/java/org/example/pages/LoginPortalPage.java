package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPortalPage extends BasePage {

    private By usernameField = By.id("text");
    private By passwordField = By.id("password");
    private By submitButton = By.id("login-button");

    public LoginPortalPage(WebDriver driver) {
        super(driver);
    }

    public LoginPortalPage enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginPortalPage enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPortalPage submitForm(){
        driver.findElement(submitButton).click();
        return this;
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public LoginPortalPage closeAlert(){
         driver.switchTo().alert().accept();
        return this;
    }
}
