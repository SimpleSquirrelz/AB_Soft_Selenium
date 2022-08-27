package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class HomePage extends BasePage {

    private String CARD_PATTERN = "//div[.//h1[text()='%s'] and contains(@class,'col-md-12')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public BasePage clickOnSectionWithTitle(String title) {
        Card card = new Card(driver.findElement(By.xpath(String.format(CARD_PATTERN,title))));
        return card.clickCard();
    }

    class Card {

        private WebElement card;
        private By cardTitle = By.xpath(".//div[@class='section-title']/h1");
        private By captionTitle = By.xpath("//div[@class='caption']/h4");
        private By captionDescription = By.xpath("//div[@class='caption']/p");

        public Card (WebElement card){
            this.card = card;
        }

        public String getCardTitle(){
            return card.findElement(cardTitle).getText();
        }

        public BasePage clickCard() {
            card.click();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            switch (getCardTitle()){
                case "TO DO LIST":
                    driver.switchTo().window(tabs.get(1));
                    return new TodoListPage(driver);

                case "DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)":
                    driver.switchTo().window(tabs.get(1));
                    return new DropdownCheckboxRadioButtonsPage(driver);

                case "AJAX LOADER":
                    driver.switchTo().window(tabs.get(1));
                    return new AJAXLoaderPage(driver);

                case "LOGIN PORTAL":
                    driver.switchTo().window(tabs.get(1));
                    return new LoginPortalPage(driver);

                case "BUTTON CLICKS":
                    driver.switchTo().window(tabs.get(1));
                    return new ClickButtonsPage(driver);
            }
            return new HomePage(driver);
        }
    }
}
