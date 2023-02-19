package com.diffblue.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CodeLineImplTest {

    @Test
    public void testGetLineNumber() {
        int lineNumber = 10;
        CodeLine codeLine = new CodeLineImpl(lineNumber, "some code");
        assertEquals(lineNumber, codeLine.getLineNumber());
    }

    @Test
    public void testGetContents() {
        String contents = "code contents";
        CodeLine codeLine = new CodeLineImpl(10, contents);
        assertEquals(contents, codeLine.getContents());
    }

    @Test
    public void testEquals() {
        CodeLine codeLine1 = new CodeLineImpl(10, "code contents");
        CodeLine codeLine2 = new CodeLineImpl(10, "code contents");
        assertEquals(codeLine1, codeLine2);
    }

    @Test
    public void testNotEquals() {
        CodeLine codeLine1 = new CodeLineImpl(10, "code contents");
        CodeLine codeLine2 = new CodeLineImpl(11, "code contents");
        assertNotEquals(codeLine1, codeLine2);

        CodeLine codeLine3 = new CodeLineImpl(10, "code contents");
        CodeLine codeLine4 = new CodeLineImpl(10, "another code contents");
        assertNotEquals(codeLine3, codeLine4);
    }

    @Test
    public void testHashCode() {
        CodeLine codeLine1 = new CodeLineImpl(10, "code contents");
        CodeLine codeLine2 = new CodeLineImpl(10, "code contents");
        assertEquals(codeLine1.hashCode(), codeLine2.hashCode());
    }
}
