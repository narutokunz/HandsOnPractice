package com.cognizant.javadfse.week1.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JUnitSetupTest {
    @Test
    void verifyJUnitEnvironmentIsConfigured() {
        Calculator calculator = new Calculator();
        assertNotNull(calculator);
    }
}
