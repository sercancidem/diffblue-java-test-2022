package com.diffblue.interview;

import java.io.File;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.diffblue.interview.utils.ValidationUtils.validateFile;
import static com.diffblue.interview.utils.ValidationUtils.validateOnlyOneArg;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * The main method of the program.
     * @param args the arguments passed to the program. It should contain only one file path.
     */
    public static void main(String[] args) {
        try {
            validateOnlyOneArg(args);
            File file = new File(args[0]);
            validateFile(file);
            CodeClass codeClass = new CodeClassImpl(file);
            CodeAnalyzer analyzer = new CodeAnalyzerImpl();
            CodeTest test = new CodeTestImpl(codeClass);
            Set<CodeLine> coveredLines = analyzer.runTest(test);
            printCodeCoverageDetails(codeClass, coveredLines);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error in Main: ", e);
        }
    }

    /**
     * Prints code coverage details for a given code class.
     *
     * @param codeClass the code class for which to print code coverage details
     * @param coveredLines the set of covered lines of code
     */
    private static void printCodeCoverageDetails(CodeClass codeClass, Set<CodeLine> coveredLines) {
        LOGGER.info("Code coverage for " + codeClass.getFile().getName());
        LOGGER.info("Code coverage: " + ((double) coveredLines.size() / codeClass.getLinesOfCode().size() * 100) + "%");
        for (CodeLine line : codeClass.getLinesOfCode()) {
            if (coveredLines.contains(line)) {
                LOGGER.info("Covered: " + line.toString());
            } else {
                LOGGER.info("Not Covered: " + line.toString());
            }
        }
    }
}
