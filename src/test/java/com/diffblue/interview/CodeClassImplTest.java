package com.diffblue.interview;

import org.junit.Test;
import java.io.File;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class CodeClassImplTest {

    /**
     * Returns a test file from the resources directory by its name.
     *
     * @param resourceName the name of the resource file
     * @return the test file
     */
    private File getTestFileFromResources(String resourceName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(resourceName)).getFile());
    }

    @Test
    public void testGetLinesOfCode() throws Exception {
        File file = getTestFileFromResources("test.txt");
        CodeClassImpl codeClass = new CodeClassImpl(file);
        List<CodeLine> linesOfCode = codeClass.getLinesOfCode();
        assertEquals(0, linesOfCode.size());
    }

    @Test
    public void testGetFile() throws Exception {
        File file = getTestFileFromResources("test.txt");
        CodeClassImpl codeClass = new CodeClassImpl(file);
        assertEquals(file, codeClass.getFile());
    }

    @Test(expected = Exception.class)
    public void testFileNotFoundException() throws Exception {
        File file = getTestFileFromResources("fileNotFound.txt");
        CodeClassImpl codeClass = new CodeClassImpl(file);
    }
}
