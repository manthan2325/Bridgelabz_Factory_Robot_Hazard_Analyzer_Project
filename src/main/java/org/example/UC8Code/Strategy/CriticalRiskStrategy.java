package org.example.UC8Code.Strategy;

public class CriticalRiskStrategy implements MachineryRiskStrategy {

    // Returns the risk factor for critical machinery.
    @Override
    public double getRiskFactor() {
        return 3.0;
    }
}