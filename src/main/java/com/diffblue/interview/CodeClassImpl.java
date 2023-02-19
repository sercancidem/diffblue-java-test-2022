package com.diffblue.interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeClassImpl implements CodeClass {
    private final List<CodeLine> linesOfCode;
    private final File file;

    public CodeClassImpl(File file) throws Exception {
        this.file = file;
        linesOfCode = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                linesOfCode.add(new CodeLineImpl(lineNumber, line));
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            throw new Exception("File Not Found!");
        }
    }

    @Override
    public List<CodeLine> getLinesOfCode() {
        return linesOfCode;
    }

    @Override
    public File getFile() {
        return file;
    }
}
