package com.rcastrucci.dev.commons;

/**
 * Utility Class related to String operations
 */
public class StringUtils {

    /**
     * Method to clean all spaces in a String and transform to lower case
     * @param string A String to be transformed
     * @return a String with the final result, no spaces between characters and all lower case
     */
    public static String cleanSpacesToLower(String string) {
        if (string.isEmpty()) return "";
        return string.trim().replaceAll(" +", "").toLowerCase();
    }

}