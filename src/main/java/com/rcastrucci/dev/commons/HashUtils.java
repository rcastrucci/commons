package com.rcastrucci.dev.commons;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

    /**
     * Method to generate a hash from a String using the algorithm Sha-256
     * @param base string base
     * @return a String with the Sha-256 hash
     * @throws NoSuchAlgorithmException This exception is thrown if the cryptographic algorithm SHA-256 is not available in the environment.
     */
    public static String sha256(final String base) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
        final StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            final String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
