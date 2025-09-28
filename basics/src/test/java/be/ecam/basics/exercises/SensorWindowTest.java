// SensorWindowTest.java

package be.ecam.basics.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorWindowTest {

    @Test
    void averageSimple() {
        // Test Simple average calculation
        assertEquals(2, SensorWindow.average(new int[]{1,2,3}));
    }

    @Test
    void averageVeryLargeShouldNotOverflow() {
        // Even with large values, using long prevents overflow
        int avg = SensorWindow.average(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
        assertEquals(Integer.MAX_VALUE, avg);
    }
}
