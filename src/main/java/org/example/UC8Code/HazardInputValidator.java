
package org.example.UC8Code;

import org.example.MachineryState;
import org.example.RobotSafetyException;
import org.example.UC8Code.RobotHazardInput;

public class HazardInputValidator {

    // Validates all robot hazard input values.
    public MachineryState validate(RobotHazardInput input)
            throws RobotSafetyException {

        if (input == null) {
            throw new RobotSafetyException(
                    "Error: Robot hazard input cannot be null"
            );
        }

        // Validates arm precision.
        if (input.getArmPrecision() < 0.0
                || input.getArmPrecision() > 1.0
                || Double.isNaN(input.getArmPrecision())
                || Double.isInfinite(input.getArmPrecision())) {

            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }

        // Validates worker density.
        if (input.getWorkerDensity() < 1
                || input.getWorkerDensity() > 20) {

            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }

        // Validates and returns the machinery state.
        return MachineryState.fromString(input.getMachineryState());
    }
}