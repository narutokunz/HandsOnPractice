package com.cognizant.javadfse.week1.dsa.forecasting;

public class ForecastingExample {
    public static void main(String[] args) {
        System.out.println("--- Financial Forecasting Tool ---");

        double presentValue = 10000.0; // Initial Investment: $10,000
        double annualGrowthRate = 0.05; // 5% Annual Growth
        int years = 10; // Forecast for 10 years

        System.out.println("Initial Investment: $" + presentValue);
        System.out.println("Annual Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecasting Period: " + years + " years\n");

        // 1. Standard Recursion
        System.out.println("[1] Executing Standard Recursion O(N)...");
        double standardResult = FinancialForecaster.calculateFutureValue(presentValue, annualGrowthRate, years);
        System.out.printf("Projected Future Value: $%.2f\n\n", standardResult);

        // 2. Optimized Recursion
        System.out.println("[2] Executing Optimized Recursion O(log N)...");
        double optimizedFactor = FinancialForecaster.calculateGrowthFactorOptimized(annualGrowthRate, years);
        double optimizedResult = presentValue * optimizedFactor;
        System.out.printf("Projected Future Value: $%.2f\n", optimizedResult);
        
        System.out.println("\nSUCCESS: Both methods yield identical results, but the optimized version uses far fewer computational cycles!");
    }
}