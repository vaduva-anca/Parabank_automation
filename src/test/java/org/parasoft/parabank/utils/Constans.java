package org.parasoft.parabank.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constans {
    public static final String URL_OVERVIEW = "https://parabank.parasoft.com/parabank/overview.htm";
    public static final String URL_REGISTER = "https://parabank.parasoft.com/parabank/register.htm";
    public static final String URL_CONTACT = "https://parabank.parasoft.com/parabank/contact.htm";
    public static final String firstName = "David";
    public static final String lastName = "John";
    public static final String street = "Street";
    public static final String city = "City";
    public static final String state = "State";
    public static final String zipCode = "451";
    public static final String phoneNumber = "999888777";
    public static final String ssn = "123";
    public static final String currentDateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmss"));
    public static final String username = "az" + currentDateAndTime;
    public static final String password = "123";
    public static final String email= "cont@gmail.com";
    public static final String message= "This is a message";





}