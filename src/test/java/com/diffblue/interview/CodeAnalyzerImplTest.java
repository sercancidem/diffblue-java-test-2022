package com.diffblue.interview;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CodeAnalyzerImplTest {

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

        @org.junit.Test
        public void runTest() {
            // Arrange
            final CodeAnalyzerImpl objectUnderTest = new CodeAnalyzerImpl();

            CodeClass codeClass = mock(CodeClassImpl.class);

            when(codeClass.getLinesOfCode()).thenReturn(codeLines);
            when(codeClass.getFile()).thenReturn(new File("test"));
            int expected = 4;
            Set<CodeLine> expectedCoveredLines = new HashSet<>(codeLines.subList(0, expected));
            when(random.nextInt(codeLines.size())).thenReturn(expected);


            final CodeTestImpl test = new CodeTestImpl(codeClass);
            test.setRandom(random);

            // Act
            final java.util.Set<CodeLine> result = objectUnderTest.runTest(test);

            // Assert result
            assertEquals(expectedCoveredLines, result);
        }

        @org.junit.Test
        public void runTestSuite() {
            // Arrange
            final CodeAnalyzerImpl objectUnderTest = new CodeAnalyzerImpl();

            CodeTest codeTest1 = mock(CodeTestImpl.class);
            CodeTest codeTest2 = mock(CodeTestImpl.class);
            CodeTest codeTest3 = mock(CodeTestImpl.class);

            when(codeTest1.getCoveredLines()).thenReturn(new HashSet<>(codeLines.subList(0, 3)));
            when(codeTest2.getCoveredLines()).thenReturn(new HashSet<>(codeLines.subList(1, 5)));
            when(codeTest3.getCoveredLines()).thenReturn(new HashSet<>(codeLines.subList(2, 7)));

            Set<CodeLine> expectedCoveredLines = new HashSet<>(codeLines.subList(0, 7));

            // Act
            final java.util.Set<CodeLine> result = objectUnderTest.runTestSuite(new java.util.HashSet<>(Arrays.asList(codeTest1, codeTest2, codeTest3)));

            // Assert result
            assertEquals(expectedCoveredLines, result);
        }

        @org.junit.Test
        public void uniqueTests() {
            // Arrange
            final CodeAnalyzerImpl objectUnderTest = new CodeAnalyzerImpl();

            CodeTest codeTest1 = mock(CodeTestImpl.class);
            CodeTest codeTest2 = mock(CodeTestImpl.class);
            CodeTest codeTest3 = mock(CodeTestImpl.class);
            CodeTest codeTest4 = mock(CodeTestImpl.class);

            when(codeTest1.getCoveredLines()).thenReturn(new HashSet<>(codeLines.subList(0, 3)));
            when(codeTest2.getCoveredLines()).thenReturn(new HashSet<>(codeLines.subList(1, 5)));
            when(codeTest3.getCoveredLines()).thenReturn(new HashSet<>(codeLines.subList(2, 3)));
            when(codeTest4.getCoveredLines()).thenReturn(new HashSet<>(codeLines.subList(8, 9)));

            Set<CodeTest> expectedCodeTest = new HashSet<>(Arrays.asList(codeTest1, codeTest2, codeTest4));

            // Act
            Set<CodeTest> result = objectUnderTest.uniqueTests(new HashSet<>(Arrays.asList(codeTest1, codeTest2, codeTest3, codeTest4)));

            // Assert result
            assertEquals(expectedCodeTest, result);
        }
}
