package com.rcastrucci.dev.commons;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

/**
 * Utility Class related to Email verifications
 */
public class EmailUtils {

    public static boolean isEmailValid(String email) {
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
            return true;
        } catch (AddressException ex) {
            return false;
        }
    }

}
