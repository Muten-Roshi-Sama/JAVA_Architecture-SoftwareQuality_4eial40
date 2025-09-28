// CounterTest.java

package be.ecam.basics.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void countSmall() {
        // Starting from 0 and taking 5 steps should give 5
        assertEquals(5, Counter.count(0, 5));
    }

    @Test
    void countShouldNotOverflow() {
        // With int, counting 300 steps should return exactly 300 (no wraparound)
        assertEquals(300, Counter.count(0, 300));
    }
}
