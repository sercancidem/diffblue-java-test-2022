package com.diffblue.interview.utils;

import java.io.File;

/**
 * The ValidationUtils class contains methods for validating input arguments and files.
 */
public class ValidationUtils {

    /**
     * Validates that only one argument is provided.
     *
     * @param args the argument array to validate
     * @throws Exception if the number of arguments is not equal to one
     */
    public static void validateOnlyOneArg(String[] args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Please provide a valid file name.");
        }
    }

    /**
     * Validates that a given file exists and is a file, not a directory.
     *
     * @param file the file to validate
     * @throws Exception if the file does not exist or is not a file
     */
    public static void validateFile(File file) throws Exception {
        if (!file.exists() || !file.isFile()) {
            throw new Exception("Please provide a valid file.");
        }
    }
}