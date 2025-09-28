// ImageScalerTest.java

package be.ecam.basics.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageScalerTest {

    @Test
    void scaleThirdShouldRoundReasonably() {
        // 5 * 1/3 = 1.67 → should round to 2
        int[] out = ImageScaler.scale(5, 5, 1, 3);
        assertArrayEquals(new int[]{2, 2}, out);
    }

    @Test
    void scaleHalfShouldHandleOddSizes() {
        // 5 * 1/2 = 2.5 → should round to 3
        // 4 * 1/2 = 2.0 → stays 2
        int[] out = ImageScaler.scale(5, 4, 1, 2);
        assertArrayEquals(new int[]{3, 2}, out);
    }
}
