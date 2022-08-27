package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickButtonsPage extends BasePage {

    private By xpathButton = By.xpath("//span[@id='button1']");
    private By cssButton = By.cssSelector("#button2");
    private By anyButton = By.cssSelector("#button3");
    private By displayedModal = By.xpath("//div[@class='modal fade in show']");

    public ClickButtonsPage(WebDriver driver) {
        super(driver);
    }

    public ClickButtonsPage webElementClick(){
        driver.findElement(xpathButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(displayedModal));
        return this;
    }

    public ClickButtonsPage jsClick(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",driver.findElement(cssButton));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(displayedModal));
        return this;
    }

    public ClickButtonsPage actionClick(){
        new Actions(driver).moveToElement(driver.findElement(anyButton)).click().perform();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(displayedModal));
        return this;
    }

    public ClickButtonsPage closeModal(){
        driver.findElement(By.xpath("//div[@class='modal fade in show']//button")).click();
//        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOf(driver.findElement(displayedModal)));
        return this;
    }
}
