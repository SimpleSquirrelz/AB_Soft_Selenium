package org.example.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    public static String BASE_URL = "http://webdriveruniversity.com";

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public BasePage openPage(String url){
        this.driver.get(url);
        return this;
    }
}
