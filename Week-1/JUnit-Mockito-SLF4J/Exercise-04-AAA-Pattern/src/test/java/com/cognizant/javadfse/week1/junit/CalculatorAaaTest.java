package com.cognizant.javadfse.week1.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorAaaTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() { calculator = new Calculator(); }

    @AfterEach
    void tearDown() { calculator = null; }

    @Test
    void testAdditionWithAaaPattern() {
        int first = 12;
        int second = 8;
        int actual = calculator.add(first, second);
        assertEquals(20, actual);
    }
}
