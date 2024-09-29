package org.parasoft.parabank.overview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.parasoft.parabank.PageObject;

import static org.parasoft.parabank.utils.Constans.URL_OVERVIEW;

public class OverviewPage extends PageObject {

    /**
     * Constructor that initializes the OverviewPage object
     * @param browser - WebDriver instance
     */
    public OverviewPage(WebDriver browser) {
        super(browser);
    }

    /**
     * Check if the current page is the Overview page
     * by comparing the current URL with the expected Overview page URL
     * @return boolean - true if on the Overview page, false otherwise
     */
    public boolean isCurrentPage() {
        return this.browser.getCurrentUrl().equals(URL_OVERVIEW);
    }

    /**
     * Check if the 'Log Out' button is displayed on the Overview page
     * @return boolean - true if the 'Log Out' button is visible, false otherwise
     */
    public boolean isLogOutButtonDisplayed() {
        return this.browser.findElement(By.xpath("//a[contains(.,'Log Out')]")).isDisplayed();
    }

    /**
     * Check if the user's full name is displayed as a welcome message
     * on the Overview page
     * @param firstName - First name of the user
     * @param lastName - Last name of the user
     * @return boolean - true if the full name is displayed in the welcome message, false otherwise
     */
    public boolean isFullNameDisplayed(String firstName, String lastName) {
        // Using XPath to find the welcome message containing the full name
        return this.browser.findElement(By.xpath("//p[@class='smallText'][contains(.,'Welcome "
                + firstName + " " + lastName + "')]")).isDisplayed();
    }

    /**
     * Check if the account balance is displayed in the account table
     * @return boolean - true if the account balance is $1000.00, false otherwise
     */
    public boolean isBalanceDisplayed() {
        // Locate the first row of the account table body
        WebElement tableRow = this.browser.findElement(By.cssSelector("#accountTable tbody tr"));
        // Find the second column (balance column) in that row
        WebElement balanceColumn = tableRow.findElement(By.cssSelector("td:nth-child(2)"));

        // Return true if the balance matches "$1000.00"
        return balanceColumn.getText().equals("$1000.00");
    }
}
