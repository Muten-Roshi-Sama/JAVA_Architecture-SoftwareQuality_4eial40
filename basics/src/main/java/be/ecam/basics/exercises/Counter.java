// Counter.java
package be.ecam.basics.exercises;

// Initial Problem (Pitfall: casting and integer overflow/underflow due to wrong type):
//           -> byte stores the counter, but byte can only hold -128 to 127.
//           --> After exceeding 127, goes back to -128M(overflow/wraparound)
//           ---> Using byte for counting causes overflow ( after 127).
// Solution :
//      Change byte to int, so large step counts (e.g. 300) work correctly.


public class Counter {
    public static int count(int start, int steps) {
        int c = start;
        for (int i = 0; i < steps; i++) {
            c++;
        }
        return c;
    }
}
