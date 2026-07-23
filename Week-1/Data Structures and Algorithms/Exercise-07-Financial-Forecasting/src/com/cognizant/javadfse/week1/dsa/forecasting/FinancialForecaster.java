package com.cognizant.javadfse.week1.dsa.forecasting;

public class FinancialForecaster {

    /**
     * Standard Recursive Algorithm: O(N) Time Complexity
     * Calculates Future Value (FV) = Present Value * (1 + growthRate)^periods
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base Condition: If no periods are left, the growth factor is 1.
        if (periods == 0) {
            return presentValue;
        }
        // Recursive Call: FV of previous period * (1 + growthRate)
        return (1 + growthRate) * calculateFutureValue(presentValue, growthRate, periods - 1);
    }

    /**
     * Optimized Recursive Algorithm (Fast Exponentiation): O(log N) Time Complexity
     * Prevents excessive computation by cutting the problem size in half at each step.
     */
    public static double calculateGrowthFactorOptimized(double growthRate, int periods) {
        if (periods == 0) {
            return 1.0;
        }

        // Divide the problem into half
        double halfFactor = calculateGrowthFactorOptimized(growthRate, periods / 2);

        // If the number of periods is even
        if (periods % 2 == 0) {
            return halfFactor * halfFactor;
        } 
        // If the number of periods is odd
        else {
            return (1 + growthRate) * halfFactor * halfFactor;
        }
    }
}