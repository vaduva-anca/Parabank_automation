package org.parasoft.parabank.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.parasoft.parabank.PageObject;
import org.parasoft.parabank.home.HomePage;

import static org.parasoft.parabank.utils.Constans.URL_REGISTER;

public class RegisterPage extends PageObject {

    // Storing the username used during registration
    private static String username;

    /**
     * Constructor that initializes the RegisterPage object
     * @param browser - WebDriver instance
     */
    public RegisterPage(WebDriver browser) {
        super(browser);
    }

    /**
     * Fills out the registration form with user details
     * @param firstName - First name of the user
     * @param lastName - Last name of the user
     * @param street - Street address
     * @param city - City
     * @param state - State
     * @param zipCode - Zip code
     * @param phoneNumber - Phone number
     * @param ssn - Social Security Number
     * @param username - Username for the account
     * @param password - Password for the account
     */
    public void fillTheRegisterForm(String firstName, String lastName, String street, String city, String state,
                                    String zipCode, String phoneNumber, String ssn, String username, String password) {
        // Store the username in a static variable
        RegisterPage.username = username;

        // Fill the registration form fields
        this.browser.findElement(By.id("customer.firstName")).sendKeys(firstName);
        this.browser.findElement(By.id("customer.lastName")).sendKeys(lastName);
        this.browser.findElement(By.id("customer.address.street")).sendKeys(street);
        this.browser.findElement(By.id("customer.address.city")).sendKeys(city);
        this.browser.findElement(By.id("customer.address.state")).sendKeys(state);
        this.browser.findElement(By.id("customer.address.zipCode")).sendKeys(zipCode);
        this.browser.findElement(By.id("customer.phoneNumber")).sendKeys(phoneNumber);
        this.browser.findElement(By.id("customer.ssn")).sendKeys(ssn);
        this.browser.findElement(By.id("customer.username")).sendKeys(RegisterPage.username);
        this.browser.findElement(By.id("customer.password")).sendKeys(password);
        this.browser.findElement(By.id("repeatedPassword")).sendKeys(password);
    }

    /**
     * Submits the registration form by clicking the 'Register' button
     */
    public void registerAccount() {
        this.browser.findElement(By.xpath("//input[contains(@value,'Register')]")).click();
    }

    /**
     * Verifies if the registration success title (with username) is displayed
     * @return boolean - true if the success title is displayed, false otherwise
     */
    public boolean isRegisteredTitleDisplayed() {
        return this.browser.findElement(By.xpath("//h1[@class='title'][contains(.,'Welcome "
                + RegisterPage.username + "')]")).isDisplayed();
    }

    /**
     * Verifies if the success message for account creation is displayed
     * @return boolean - true if the message is displayed, false otherwise
     */
    public boolean isRegisteredMessageDisplayed() {
        return this.browser.findElement(By.xpath("//p[contains(.,'Your account was created" +
                " successfully. You are now logged in.')]")).isDisplayed();
    }

    /**
     * Verifies if the 'Log Out' button is visible after registration
     * @return boolean - true if the 'Log Out' button is displayed, false otherwise
     */
    public boolean isLogOutButtonDisplayed() {
        return this.browser.findElement(By.xpath("//a[contains(.,'Log Out')]")).isDisplayed();
    }

    /**
     * Verifies if all error messages for invalid form inputs are displayed
     * @return boolean - true if all error messages are displayed, false otherwise
     */
    public boolean isDisplayingErrorMessages() {
        return this.browser.findElement(By.id("customer.firstName.errors")).isDisplayed()
                && this.browser.findElement(By.id("customer.lastName.errors")).isDisplayed()
                && this.browser.findElement(By.id("customer.address.street.errors")).isDisplayed()
                && this.browser.findElement(By.id("customer.address.city.errors")).isDisplayed()
                && this.browser.findElement(By.id("customer.address.state.errors")).isDisplayed()
                && this.browser.findElement(By.id("customer.address.zipCode.errors")).isDisplayed()
                && this.browser.findElement(By.id("customer.ssn.errors")).isDisplayed()
                && this.browser.findElement(By.id("customer.username.errors")).isDisplayed()
                && this.browser.findElement(By.id("customer.password.errors")).isDisplayed()
                && this.browser.findElement(By.id("repeatedPassword.errors")).isDisplayed();
    }

    /**
     * Verifies if the current page is the Register page
     * @return boolean - true if the current URL matches the Register page URL, false otherwise
     */
    public boolean isCurrentPage() {
        return this.browser.getCurrentUrl().equals(URL_REGISTER);
    }

    /**
     * Navigates back to the HomePage by clicking the 'Log Out' button
     * @return HomePage object for further interactions
     */
    public HomePage navigateToHomePage() {
        this.browser.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();
        return new HomePage(this.browser);
    }
}
