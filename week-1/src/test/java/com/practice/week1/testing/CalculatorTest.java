package com.practice.week1.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUNIT 5 — Java's equivalent of NUnit.
 * @Test marks a test method; assertions verify expected behaviour.
 */
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void add_returnsSumOfTwoNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void divide_throwsExceptionWhenDividingByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    void divide_returnsCorrectQuotient() {
        assertEquals(4, calculator.divide(20, 5));
    }
}
