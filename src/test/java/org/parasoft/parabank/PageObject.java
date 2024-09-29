package org.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        new ChromeDriverService.Builder()
                .usingDriverExecutable( new File("drivers/chromedriver"))
                .build();

        if (browser == null) {
            this.browser = new ChromeDriver();
        } else {
            this.browser = browser;
        }
    }

    public void close() {
        this.browser.quit();
    }

    private WebElement findElement(By by) {
        return this.browser.findElement(by);
    }

    protected void insertText(By by, String text) {
        findElement(by).sendKeys(text);
    }

    protected void clickOnButton(By by) {
         findElement(by).click();
    }

    protected boolean isElementDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    protected String getUrl() {
        return this.browser.getCurrentUrl();
    }
}
