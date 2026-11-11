package org.example.UC8Code;

import org.example.MachineryState;
import org.example.RobotSafetyException;
import org.example.UC8Code.Strategy.CriticalRiskStrategyTest;
import org.example.UC8Code.Strategy.FaultyRiskStrategyTest;
import org.example.UC8Code.Strategy.MachineryRiskStrategyTest;
import org.example.UC8Code.Strategy.WornRiskStrategyTest;

public class MachineryRiskFactory {

    // Creates the appropriate strategy for the machinery state.
    public MachineryRiskStrategyTest createStrategy(MachineryState state)
            throws RobotSafetyException {

        if (state == null) {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state"
            );
        }

        return switch (state) {
            case Worn -> new WornRiskStrategyTest();
            case Faulty -> new FaultyRiskStrategyTest();
            case Critical -> new CriticalRiskStrategyTest();
        };
    }
}