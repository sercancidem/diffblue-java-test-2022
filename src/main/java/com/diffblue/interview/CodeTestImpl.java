package com.diffblue.interview;

import java.util.*;

public class CodeTestImpl implements CodeTest {

    private final CodeClass codeClass;
    private Random random;

    private final String name;
    private Set<CodeLine> coveredLines;

    public CodeTestImpl(CodeClass codeClass) {
        this.codeClass = codeClass;
        this.name = codeClass.getFile().getName() + "-" +  UUID.randomUUID();
        this.coveredLines = null;
        random = new java.util.Random();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<CodeLine> getCoveredLines() {
        if (coveredLines == null) {
            coveredLines = new LinkedHashSet<>();
            List<CodeLine> lines = codeClass.getLinesOfCode();
            int numLinesToCover = random.nextInt(lines.size());
            for (int i = 0; i < numLinesToCover; i++) {
                coveredLines.add(lines.get(i));
            }
        }
        return coveredLines;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
