package org.parasoft.parabank.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.parasoft.parabank.PageObject;

import static org.parasoft.parabank.utils.Constans.URL_CONTACT;

public class ContactPage extends PageObject {

    // Locator for the 'Name' input field
    private final By nameInput = By.id("name");

    // Locator for the 'Email' input field
    private final By emailInput = By.id("email");

    // Locator for the 'Phone' input field
    private final By phoneInput = By.id("phone");

    // Locator for the 'Message' input field
    private final By messageInput = By.id("message");

    // Locator for the 'Send' button on the contact form
    private final By sendButton = By.cssSelector("#contactForm input[type=\"submit\"]");

    // Locator for the feedback message displayed after submitting the form
    private final By feedbackMessage = By.cssSelector("#rightPanel > p:nth-child(2)");

    // Field to store the 'name' temporarily
    private static String name;

    // Constructor that initializes the browser instance from the PageObject superclass
    public ContactPage(WebDriver browser) {
        super(browser);
    }

    /**
     * Method to fill out the contact form with provided details
     * @param name - Name of the person contacting
     * @param email - Email address of the person contacting
     * @param phone - Phone number of the person contacting
     * @param message - Message to be sent
     */
    public void fillTheContactForm(String name, String email, String phone, String message) {
        // Store the name in the static variable
        ContactPage.name = name;

        // Insert the name into the 'Name' input field
        insertText(nameInput, ContactPage.name);

        // Insert the email into the 'Email' input field
        insertText(emailInput, email);

        // Insert the phone number into the 'Phone' input field
        insertText(phoneInput, phone);

        // Insert the message into the 'Message' input field
        insertText(messageInput, message);
    }

    /**
     * Method to submit the contact form by clicking the 'Send' button
     */
    public void contact() {
        // Click the 'Send' button on the form
        clickOnButton(sendButton);
    }

    /**
     * Method to check if the feedback message is displayed after submitting the form
     * @return boolean - true if the feedback message is displayed, false otherwise
     */
    public boolean isMessageDisplayed() {
        // Check if the feedback message is visible
        return isElementDisplayed(feedbackMessage);
    }

    /**
     * Method to verify if the current page URL matches the contact page URL
     * @return boolean - true if the current URL is the contact page URL, false otherwise
     */
    public boolean isCurrentPage() {
        // Check if the current page URL is the same as the contact page URL
        return getUrl().equals(URL_CONTACT);
    }
}
