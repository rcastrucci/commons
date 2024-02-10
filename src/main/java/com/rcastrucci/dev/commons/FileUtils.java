package com.rcastrucci.dev.commons;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Utility Class related to Files and Folders
 */
public class FileUtils {

    /**
     * Retrieve extension from a file
     * @param filename type String
     * @return a String containing the file extension
     */
    public static String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf(".")+1);
    }

    /**
     * Retrieve extension from a file
     * @param file type MultipartFile
     * @return a String containing the file extension
     * @throws NullPointerException if the file is null
     */
    public static String getFileExtension(MultipartFile file) throws NullPointerException {
        return getFileExtension(Objects.requireNonNull(file.getOriginalFilename()));
    }

    /**
     * Method to check if a folder exists. If it doesn't exist the method will try to create it
     * @param folderName the folder name to be checked or created
     * @return boolean true if exists or if it was created successfully
     */
    public static boolean checkCreateFolder(String folderName) {
        File folder = new File(folderName);
        if (!folder.exists()) return folder.mkdirs();
        else return true;
    }

    /**
     * Method to delete a folder from the server
     * @param folderName the folder name to be deleted
     * @throws IOException if any IO exception occurs
     */
    public static void deleteFolder(String folderName) throws IOException {
        org.apache.commons.io.FileUtils.forceDelete(new File(folderName));
    }

    /**
     * Method to delete a file passing a filename as String
     * @param file the filename as String
     * @return boolean true if file was deleted
     */
    public static boolean deleteFile(String file) {
        File myObj = new File(file);
        if (myObj.exists()) {
            return myObj.delete();
        } else {
            return false;
        }
    }

    /**
     * Method to concatenate a filename with its extension
     * @param filename a file name
     * @param extension a file extension
     * @return a String with the filename and extension concatenated with a period.
     */
    public static String concatFileExtension(String filename, String extension) {
        return filename+"."+extension;
    }

    /**
     * Method to check if client is requesting the right type of file
     * Filename must be PNG, JPG, JPEG or WEBP
     * @param filename the requested filename
     * @return boolean true if is NOT the correct type
     */
    public static boolean hasNotImageExtension(String filename) {
        return (
                !getFileExtension(filename).equalsIgnoreCase("png") &&
                        !getFileExtension(filename).equalsIgnoreCase("jpg") &&
                        !getFileExtension(filename).equalsIgnoreCase("jpeg") &&
                        !getFileExtension(filename).equalsIgnoreCase("webp")
        );
    }

}
