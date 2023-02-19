package com.diffblue.interview;

import java.util.*;
import java.util.stream.Collectors;

public class CodeAnalyzerImpl implements CodeAnalyzer {

    @Override
    public Set<CodeLine> runTest(CodeTest test) {
        return test.getCoveredLines();
    }

    @Override
    public Set<CodeLine> runTestSuite(Set<CodeTest> tests) {
        Set<CodeLine> coveredLines = new LinkedHashSet<>();
        for (CodeTest test : tests) {
            coveredLines.addAll(test.getCoveredLines());
        }
        return coveredLines;
    }

    @Override
    public Set<CodeTest> uniqueTests(Set<CodeTest> tests) {
        Map<CodeLine, Set<CodeTest>> codeLineSetHashMap = new HashMap<>();
        for (CodeTest test : tests) {
            for (CodeLine line : test.getCoveredLines()) {
                if (codeLineSetHashMap.containsKey(line)) {
                    codeLineSetHashMap.get(line).add(test);
                } else {
                    Set<CodeTest> codeTests = new HashSet<>();
                    codeTests.add(test);
                    codeLineSetHashMap.put(line, codeTests);
                }
            }
        }

        return codeLineSetHashMap.values().stream()
                .filter(codeTests -> codeTests.size() == 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

}
