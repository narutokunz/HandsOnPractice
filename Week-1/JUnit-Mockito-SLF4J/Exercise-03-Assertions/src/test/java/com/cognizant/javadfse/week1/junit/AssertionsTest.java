package com.cognizant.javadfse.week1.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssertionsTest {
    @Test
    void demonstrateCoreAssertions() {
        assertEquals(10, 5 + 5);
        assertTrue(10 > 5);
        assertFalse(5 > 10);
        assertNull(null);
        assertNotNull("Cognizant");
    }
}
