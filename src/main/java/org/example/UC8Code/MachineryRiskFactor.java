package org.example.UC8Code;

import org.example.MachineryState;
import org.example.RobotSafetyException;
import org.example.UC8Code.Strategy.CriticalRiskStrategy;
import org.example.UC8Code.Strategy.FaultyRiskStrategy;
import org.example.UC8Code.Strategy.MachineryRiskStrategy;
import org.example.UC8Code.Strategy.WornRiskStrategy;

public class MachineryRiskFactory {

    // Creates the appropriate strategy for the machinery state.
    public MachineryRiskStrategy createStrategy(MachineryState state)
            throws RobotSafetyException {

        if (state == null) {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state"
            );
        }

        return switch (state) {
            case Worn -> new WornRiskStrategy();
            case Faulty -> new FaultyRiskStrategy();
            case Critical -> new CriticalRiskStrategy();
        };
    }
}