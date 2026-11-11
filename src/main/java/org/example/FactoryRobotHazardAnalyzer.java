package org.example;

import java.util.Scanner;

//Displays the application name when the program starts
public class FactoryRobotHazardAnalyzer {
    public static void main(String[] args) {
        System.out.println("Factory Robot Hazard Analyzer");

        //UC1 CODE --------------------------------------------->
        Scanner scanner = new Scanner(System.in);

        // Accepts arm precision from the user.
        System.out.println("Enter Arm Precision:");
        double armPrecision = scanner.nextDouble();

        // Accepts worker density from the user.
        System.out.println("Enter Worker Density:");
        int workerDensity = scanner.nextInt();

        scanner.nextLine();

        // Accepts machinery state from the user.
        System.out.println("Enter Machinery State:");
        String machineryState = scanner.nextLine();

        // Displays the values entered by the user.
        System.out.println("\nEntered Robot Details:");
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        // UC3 CODE ---------------------------------------------->
        //double machineRiskFactor = getMachineRiskFactor(machineryState);

        // Calculates the hazard risk score using the given formula.
        //double hazardRisk = ((1.0 - armPrecision) * 15.0)
        //        + (workerDensity * machineRiskFactor);

        // Displays the calculated hazard risk score.
        //System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        // UC4 - CODE ----------------------------------->
        // Validates arm precision.
        if (armPrecision < 0.0 || armPrecision > 1.0) {

            System.out.println(
                    "Error: Arm precision must be 0.0-1.0"
            );

        }

        // Validates worker density.
        else if (workerDensity < 1 || workerDensity > 20) {

            System.out.println(
                    "Error: Worker density must be 1-20"
            );

        }

        // Validates machinery state.
        else if (!machineryState.equals("Worn")
                && !machineryState.equals("Faulty")
                && !machineryState.equals("Critical")) {

            System.out.println(
                    "Error: Unsupported machinery state"
            );

        }

        // Calculates the hazard risk if all inputs are valid.
        else {

            double machineRiskFactor =
                    getMachineRiskFactor(machineryState);

            double hazardRisk =
                    ((1.0 - armPrecision) * 15.0)
                            + (workerDensity * machineRiskFactor);

            System.out.println(
                    "Robot Hazard Risk Score: " + hazardRisk
            );
        }
        // Calls the method to calculate the hazard risk score.
        double hazardRisk = calculateHazardRisk(
                armPrecision,
                workerDensity,
                machineryState
        );

        // Displays the hazard risk score if the inputs are valid.
        if (hazardRisk != -1.0) {
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }
    }

    //UC5 CODE -------------------------------------------------->
    // Validates inputs and calculates the hazard risk score.
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState) {

        // Validates arm precision.
        if (armPrecision < 0.0 || armPrecision > 1.0) {

            System.out.println(
                    "Error: Arm precision must be 0.0-1.0"
            );

            return -1.0;
        }

        // Validates worker density.
        if (workerDensity < 1 || workerDensity > 20) {

            System.out.println(
                    "Error: Worker density must be 1-20"
            );

            return -1.0;
        }

        // Validates machinery state.
        if (!machineryState.equals("Worn")
                && !machineryState.equals("Faulty")
                && !machineryState.equals("Critical")) {

            System.out.println(
                    "Error: Unsupported machinery state"
            );

            return -1.0;
        }

        double machineRiskFactor =
                getMachineRiskFactor(machineryState);

        // Calculates the hazard risk using the given formula.
        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
    private static double getMachineRiskFactor(String machineryState) {

        if (machineryState.equals("Worn")) {
            return 1.3;
        } else if (machineryState.equals("Faulty")) {
            return 2.0;
        } else {
            return 3.0;
        }
    }
}
