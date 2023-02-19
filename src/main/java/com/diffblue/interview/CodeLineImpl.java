package com.diffblue.interview;

import java.util.Objects;

public class CodeLineImpl implements CodeLine {
    private final int lineNumber;
    private final String contents;

    public CodeLineImpl(int lineNumber, String contents) {
        this.lineNumber = lineNumber;
        this.contents = contents;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String getContents() {
        return contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeLineImpl codeLine = (CodeLineImpl) o;
        return lineNumber == codeLine.lineNumber && Objects.equals(contents, codeLine.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNumber, contents);
    }

    @Override
    public String toString() {
        return "lineNumber=" + lineNumber +
                ", contents='" + contents;
    }
}
