// SensorWindow.java

package be.ecam.basics.exercises;

// Initial Problem (Pitfall: casting and integer overflow/underflow):
    //           --> Summing int values directly can overflow (e.g., Integer.MAX_VALUE + Integer.MAX_VALUE)
    // Solution :
    //      Use long to accumulate sum and cast back to int when computing average.

public class SensorWindow {
    public static int average(int[] values) {
        if (values == null || values.length == 0) throw new IllegalArgumentException("values");
        
        long sum = 0;

        for (int v : values) {
            sum += v;
        }

        return (int)(sum / values.length);
    }
}
