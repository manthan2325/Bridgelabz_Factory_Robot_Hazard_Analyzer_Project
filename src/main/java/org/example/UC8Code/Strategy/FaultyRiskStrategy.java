
package org.example.UC8Code.Strategy;

public class FaultyRiskStrategy implements MachineryRiskStrategy {

    // Returns the risk factor for faulty machinery.
    @Override
    public double getRiskFactor() {
        return 2.0;
    }
}