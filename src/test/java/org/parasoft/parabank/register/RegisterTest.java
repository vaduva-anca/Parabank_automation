package org.parasoft.parabank.register;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.parasoft.parabank.home.HomePage;

import static org.parasoft.parabank.utils.Constans.*;

public class RegisterTest {

    // Instance of the RegisterPage object used in the tests
    private RegisterPage registerPage;

    /**
     * This method runs after each test, ensuring that the browser is closed after every test case.
     */
    @AfterEach
    public void afterEach() {
        this.registerPage.close();
    }

    /**
     * Test to verify if a user can successfully register an account.
     */
    @Test
    public void shouldRegisterAccountWithSuccess() {
        // Navigate to the HomePage and then to the RegisterPage
        HomePage homePage = new HomePage(null);  // Assuming WebDriver is initialized elsewhere
        this.registerPage = homePage.navigateToRegisterPage();

        // Fill in the registration form with valid details
        // Adding "Aa" to username to ensure uniqueness across tests
        this.registerPage.fillTheRegisterForm(firstName, lastName, street, city, state, zipCode, phoneNumber, ssn,
                username + "Aa", password);

        // Submit the registration form
        this.registerPage.registerAccount();

        // Assert that the user is still on the RegisterPage (due to a possible redirect)
        Assertions.assertTrue(this.registerPage.isCurrentPage(), "The user is not on the registration confirmation page.");

        // Assert that the welcome title and success message are displayed
        Assertions.assertTrue(this.registerPage.isRegisteredTitleDisplayed(), "The welcome title is not displayed.");
        Assertions.assertTrue(this.registerPage.isRegisteredMessageDisplayed(), "The registration success message is not displayed.");

        // Assert that the 'Log Out' button is visible after a successful registration
        Assertions.assertTrue(this.registerPage.isLogOutButtonDisplayed(), "The Log Out button is not displayed.");
    }

    /**
     * Test to verify that appropriate error messages are displayed when invalid form data is submitted.
     */
    @Test
    public void shouldDisplayErrors() {
        // Navigate to the HomePage and then to the RegisterPage
        HomePage homePage = new HomePage(null);
        this.registerPage = homePage.navigateToRegisterPage();

        // Fill in the registration form with empty values to trigger validation errors
        this.registerPage.fillTheRegisterForm("", "", "", "", "", "", "", "", "", "");

        // Submit the registration form
        this.registerPage.registerAccount();

        // Assert that the user remains on the RegisterPage due to validation errors
        Assertions.assertTrue(this.registerPage.isCurrentPage(), "The user is not on the registration page.");

        // Assert that error messages for missing inputs are displayed
        Assertions.assertTrue(this.registerPage.isDisplayingErrorMessages(), "The error messages are not displayed.");
    }
}
