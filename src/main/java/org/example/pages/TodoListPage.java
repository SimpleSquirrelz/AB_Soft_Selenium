package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TodoListPage extends BasePage{

    private By plusIcon = By.id("plus-icon");
    private By newTaskField = By.xpath("//input[@type='text']");
    private String TASK_BY_TEXT = "//li[text() = ' %s']";
    public TodoListPage(WebDriver driver) {
        super(driver);
    }

    public TodoListPage toggleNewTaskField(){
        driver.findElement(plusIcon).click();
        return this;
    }

    public List<WebElement> getAllTasksByText(String text) {
        return driver.findElements(By.xpath(String.format(TASK_BY_TEXT, text)));
    }

    public TodoListPage addTask(String text){
        WebElement taskField = driver.findElement(newTaskField);
        taskField.click();
        taskField.sendKeys(text, Keys.ENTER);
        return this;
    }

    public void deleteTask(String text) {
        deleteTask(text, 0);
    }

    public TodoListPage deleteTask(String text, int index) {
        new TodoListRecord(getAllTasksByText(text).get(index)).deleteTask();
        return this;
    }

    class TodoListRecord {

        private By deleteButton = By.xpath(".//i");

        private WebElement record;

        public TodoListRecord(WebElement record){
            this.record = record;
        }

        public TodoListPage deleteTask(){
            record.click();
            new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
            record.findElement(deleteButton).click();
            new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.invisibilityOf(record));
            return new TodoListPage(driver);
        }

        public TodoListPage toggleCompletion(){
            record.click();
            return new TodoListPage(driver);
        }
    }
}
