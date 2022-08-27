package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AJAXLoaderPage extends BasePage {

    private By button = By.id("button1");
    private By loader = By.id("loader");
    private By modalWindow = By.id("myModalClick");
    public AJAXLoaderPage(WebDriver driver) {
        super(driver);
    }

    public ModalWindow clickButton(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfElementLocated(loader));
        driver.findElement(button).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(modalWindow));
        return new ModalWindow();
    }

    public boolean isModalDisplayed(){
        return !driver.findElement(modalWindow).getCssValue("display").equals("none");
    }

    public class ModalWindow {

        private WebElement modalWindow;
        private By modalWindowSelector = By.id("myModalClick");
        private By header = By.xpath(".//div[@class='modal-header']//h4");
        private By closeButton = By.xpath(".//div[@class='modal-footer']//button");

        public ModalWindow(){
            modalWindow = driver.findElement(modalWindowSelector);
        }

        public String getHeaderText(){
            return modalWindow.findElement(header).getText();
        }

        public void closeModal(){
            modalWindow.findElement(closeButton).click();
            new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOf(modalWindow));
        }
    }
}
