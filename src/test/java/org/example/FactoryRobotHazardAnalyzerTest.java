
package org.example;

import org.example.FactoryRobotHazardAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryRobotHazardAnalyzerTest {

    @Test
    void shouldAcceptAndDisplayRobotInputs() {

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayInputStream input = new ByteArrayInputStream(
                "0.5\n10\nCritical\n".getBytes()
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            FactoryRobotHazardAnalyzer.main(new String[]{});

            String actualOutput = output.toString();

            assertTrue(actualOutput.contains(
                    "Factory Robot Hazard Analyzer"
            ));

            assertTrue(actualOutput.contains("Arm Precision: 0.5"));

            assertTrue(actualOutput.contains("Worker Density: 10"));

            assertTrue(actualOutput.contains("Machinery State: Critical"));

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
     // UC3 - CALCULATES THE HAZARD RISK SCORE -------------------------------------->
    // Verifies the hazard risk calculation for worn machinery.
    @Test
    void shouldCalculateRiskForWornMachinery() {

        String output = executeApplication("0.5\n10\nWorn\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 20.5"));
    }

    // Verifies the hazard risk calculation for faulty machinery.
    @Test
    void shouldCalculateRiskForFaultyMachinery() {

        String output = executeApplication("0.5\n10\nFaulty\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 27.5"));
    }

    // Verifies the hazard risk calculation for critical machinery.
    @Test
    void shouldCalculateRiskForCriticalMachinery() {

        String output = executeApplication("0.5\n10\nCritical\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 37.5"));
    }

    // Executes the application with simulated input and captures its output.
//    private String executeApplication(String simulatedInput) {
//
//        InputStream originalInput = System.in;
//        PrintStream originalOutput = System.out;
//
//        ByteArrayInputStream input = new ByteArrayInputStream(
//                simulatedInput.getBytes()
//        );
//
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//        try {
//            System.setIn(input);
//            System.setOut(new PrintStream(output));
//
//            FactoryRobotHazardAnalyzer.main(new String[]{});
//
//            return output.toString();
//
//        } finally {
//            System.setIn(originalInput);
//            System.setOut(originalOutput);
//        }
//    }

    //UC4 TEST CODE ------------------------------------------->
    // Verifies hazard calculation for valid inputs.
    @Test
    void shouldCalculateRiskForValidInputs() {

        String output = executeApplication("0.5\n10\nCritical\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 37.5"));
    }

    // Verifies validation of arm precision below the permitted range.
    @Test
    void shouldRejectInvalidArmPrecision() {

        String output = executeApplication("1.3\n10\nWorn\n");

        assertTrue(output.contains(
                "Error: Arm precision must be 0.0-1.0"
        ));
    }

    // Verifies validation of worker density above the permitted range.
    @Test
    void shouldRejectInvalidWorkerDensity() {

        String output = executeApplication("0.7\n26\nCritical\n");

        assertTrue(output.contains(
                "Error: Worker density must be 1-20"
        ));
    }

    // Verifies validation of unsupported machinery states.
    @Test
    void shouldRejectUnsupportedMachineryState() {

        String output = executeApplication("0.3\n14\nOptimal\n");

        assertTrue(output.contains(
                "Error: Unsupported machinery state"
        ));
    }

    // Verifies that minimum and maximum boundary values are accepted.
    @Test
    void shouldAcceptBoundaryValues() {

        String output = executeApplication("1.0\n20\nCritical\n");

        assertTrue(output.contains("Robot Hazard Risk Score: 60.0"));
    }

    // Executes the application with simulated input and captures its output.
    private String executeApplication(String simulatedInput) {

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayInputStream input = new ByteArrayInputStream(
                simulatedInput.getBytes()
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            FactoryRobotHazardAnalyzer.main(new String[]{});

            return output.toString();

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}