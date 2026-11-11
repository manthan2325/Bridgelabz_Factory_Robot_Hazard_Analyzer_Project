
package org.example.UC8Code;

import org.example.MachineryState;
import org.example.RobotSafetyException;
import org.example.UC8Code.Strategy.MachineryRiskStrategyTest;

public class RobotHazardAuditorTest {

    private final HazardInputValidatorTest validator;
    private final MachineryRiskFactory riskFactory;

    // Initializes the auditor with its required dependencies.
    public RobotHazardAuditorTest(
            HazardInputValidatorTest validator,
            MachineryRiskFactory riskFactory) {

        this.validator = validator;
        this.riskFactory = riskFactory;
    }

    // Validates robot inputs and calculates the hazard risk score.
    public double calculateHazardRisk(RobotHazardInputTest input)
            throws RobotSafetyException {

        MachineryState state = validator.validate(input);

        MachineryRiskStrategyTest strategy =
                riskFactory.createStrategy(state);

        double machineRiskFactor = strategy.getRiskFactor();

        // Calculates the hazard risk using the given formula.
        return ((1.0 - input.getArmPrecision()) * 15.0)
                + (input.getWorkerDensity() * machineRiskFactor);
    }
}