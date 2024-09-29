package org.parasoft.parabank.contact;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.parasoft.parabank.home.HomePage;

import static org.parasoft.parabank.utils.Constans.*;

public class ContactTest {

    // Instance of the ContactPage object
    ContactPage contactPage;

    /**
     * This method is executed after each test to close the browser and clean up resources
     */
    @AfterEach
    public void afterEach() {
        // Close the contact page (i.e., the browser instance)
        contactPage.close();
    }

    /**
     * This test verifies that a contact form can be submitted successfully and that
     * the user stays on the contact page with a success message displayed
     */
    @Test
    public void shouldContactWithSuccess() {
        // Instantiate the HomePage object (passing a null WebDriver for now, assuming WebDriver is set elsewhere)
        HomePage homePage = new HomePage(null);

        // Navigate to the ContactPage from the HomePage
        this.contactPage = homePage.navigateToContactPage();

        // Fill in the contact form using constants from Constans class
        this.contactPage.fillTheContactForm(firstName, email, phoneNumber, message);

        // Submit the contact form by clicking the 'Send' button
        this.contactPage.contact();

        // Assert that the current page is still the contact page
        Assertions.assertTrue(this.contactPage.isCurrentPage());

        // Assert that the feedback message is displayed after submission
        Assertions.assertTrue(this.contactPage.isMessageDisplayed());
    }
}
