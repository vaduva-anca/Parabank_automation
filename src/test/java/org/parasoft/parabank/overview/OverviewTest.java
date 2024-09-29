package org.parasoft.parabank.overview;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.parasoft.parabank.home.HomePage;

import org.parasoft.parabank.register.RegisterPage;


import static org.parasoft.parabank.utils.Constans.*;

public class OverviewTest {

    // Instance of the OverviewPage object
    private OverviewPage overviewPage;

    /**
     * This method is executed after each test to clean up resources by closing the browser.
     */
    @AfterEach
    public void afterEach() {
        this.overviewPage.close();
    }

    /**
     * Test to verify a successful login and check if the Overview page displays the correct details.
     */
    @Test
    public void loginWithSuccess() {
        // Initialize HomePage and navigate to the RegisterPage
        HomePage homePage = new HomePage(null);  // Assuming WebDriver is managed elsewhere
        RegisterPage registerPage = homePage.navigateToRegisterPage();

        // Fill in the registration form and register a new account
        registerPage.fillTheRegisterForm(firstName, lastName, street, city, state, zipCode, phoneNumber, ssn,
                username, password);
        registerPage.registerAccount();

        // Navigate back to the home page and log in with the registered credentials
        homePage = registerPage.navigateToHomePage();
        homePage.fillLogInForm(username, password);
        this.overviewPage = homePage.logIn();

        // Assert that the user is on the correct Overview page after login
        Assertions.assertTrue(this.overviewPage.isCurrentPage());

        // Assert that the user's full name is displayed on the Overview page
        Assertions.assertTrue(this.overviewPage.isFullNameDisplayed(firstName, lastName));


    }


}
