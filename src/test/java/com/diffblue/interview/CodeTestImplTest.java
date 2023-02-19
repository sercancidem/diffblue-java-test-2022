package com.diffblue.interview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CodeTestImplTest {

    @Mock
    private Random random;

    private static final List<CodeLine> codeLines = Arrays.asList(
            new CodeLineImpl(1, "line"),
            new CodeLineImpl(2, "line"),
            new CodeLineImpl(3, "line"),
            new CodeLineImpl(4, "line"),
            new CodeLineImpl(5, "line"),
            new CodeLineImpl(6, "line"),
            new CodeLineImpl(7, "line"),
            new CodeLineImpl(8, "line"),
            new CodeLineImpl(9, "line"),
            new CodeLineImpl(10, "line"),
            new CodeLineImpl(11, "line"),
            new CodeLineImpl(12, "line"),
            new CodeLineImpl(13, "line"));

    @Test
    public void testGetName() {
        CodeClass codeClass = mock(CodeClassImpl.class);
        when(codeClass.getFile()).thenReturn(new File("test"));
        CodeTestImpl codeTest = new CodeTestImpl(codeClass);
        assertTrue(codeTest.getName().startsWith(codeClass.getFile().getName()));
    }

    @Test
    public void testGetCoveredLines() {

        CodeClass codeClass = mock(CodeClassImpl.class);

        when(codeClass.getLinesOfCode()).thenReturn(codeLines);
        Integer expected = 2;
        when(codeClass.getFile()).thenReturn(new File("test"));
        when(random.nextInt(codeLines.size())).thenReturn(expected);

        CodeTestImpl codeTest = new CodeTestImpl(codeClass);
        codeTest.setRandom(random);

        Set<CodeLine> coveredLines = codeTest.getCoveredLines();
        assertEquals(2, coveredLines.size());
        assertTrue(coveredLines.contains(codeLines.get(0)));
        assertTrue(coveredLines.contains(codeLines.get(1)));
    }
}
