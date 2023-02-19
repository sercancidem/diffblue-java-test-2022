package com.diffblue.interview.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

    @Test
    public void validateOnlyOneArg_withMultipleArgs_throwsException() {
        String[] args = {"file1.txt", "file2.txt"};
        assertThrows(Exception.class, () -> ValidationUtils.validateOnlyOneArg(args));
    }

    @Test
    public void validateOnlyOneArg_withOneArg_noExceptionThrown() throws Exception {
        String[] args = {"file.txt"};
        ValidationUtils.validateOnlyOneArg(args);
    }

    @Test
    public void validateFile_withNonExistingFile_throwsException() {
        File file = new File("non_existing_file.txt");
        assertThrows(Exception.class, () -> ValidationUtils.validateFile(file));
    }

    @Test
    public void validateFile_withExistingFile_noExceptionThrown() throws Exception {
        File file = new File("existing_file.txt");
        file.createNewFile();
        ValidationUtils.validateFile(file);
        file.delete();
    }
}
