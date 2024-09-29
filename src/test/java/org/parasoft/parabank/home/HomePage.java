package org.parasoft.parabank.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.parasoft.parabank.PageObject;
import org.parasoft.parabank.contact.ContactPage;
import org.parasoft.parabank.overview.OverviewPage;
import org.parasoft.parabank.register.RegisterPage;

public class HomePage extends PageObject {

    // URL of the home page for Parabank
    public static final String URL_HOME = "https://parabank.parasoft.com/parabank/index.htm";

    /**
     * Constructor that initializes the HomePage object
     * and navigates the browser to the home page URL
     * @param browser - WebDriver instance
     */
    public HomePage(WebDriver browser) {
        super(browser);
        // Navigate the browser to the home page URL
        this.browser.navigate().to(URL_HOME);
    }

    /**
     * Navigate to the Register page by clicking the 'Register' link
     * @return RegisterPage object for further interactions
     */
    public RegisterPage navigateToRegisterPage() {
        // Find the 'Register' link by its text and click it
        browser.findElement(By.xpath("//a[contains(.,'Register')]")).click();
        // Return a new instance of RegisterPage
        return new RegisterPage(browser);
    }

    /**
     * Navigate to the Contact page by clicking the 'Contact' link
     * @return ContactPage object for further interactions
     */
    public ContactPage navigateToContactPage() {
        // Find the 'Contact' link by its text and click it
        browser.findElement(By.xpath("//a[contains(.,'contact')]")).click();
        // Return a new instance of ContactPage
        return new ContactPage(browser);
    }

    /**
     * Fill in the login form with the given username and password
     * @param username - Username for login
     * @param password - Password for login
     */
    public void fillLogInForm(String username, String password) {
        // Find the username input field (type 'text') and send the username
        this.browser.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(username);
        // Find the password input field (type 'password') and send the password
        this.browser.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(password);
    }

    /**
     * Submit the login form and navigate to the Overview page
     * @return OverviewPage object for further interactions after login
     */
    public OverviewPage logIn() {
        // Submit the password field to trigger form submission
        this.browser.findElement(By.xpath("//input[contains(@type,'password')]")).submit();
        // Return a new instance of OverviewPage after login
        return new OverviewPage(this.browser);
    }
}
