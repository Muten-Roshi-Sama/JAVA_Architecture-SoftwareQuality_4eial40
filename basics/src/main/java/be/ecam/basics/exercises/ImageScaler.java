// ImageScaler.java
package be.ecam.basics.exercises;

// Initial Problem (Pitfall: integer division truncation):
    //           --> Integer division truncates (5/2 = 2 instead of 2.5).
    // Solution :
    //      Use integer rounding trick: (value * num + den/2) / den


public class ImageScaler {

    public static int[] scale(int width, int height, int num, int den) {
        if (width < 0 || height < 0) throw new IllegalArgumentException();
        if (den == 0) throw new IllegalArgumentException();

        int w = (width * num + den / 2) / den;   // rounded instead of truncated
        int h = (height * num + den / 2) / den;  // rounded instead of truncated

        if (w < 0) w = 0;
        if (h < 0) h = 0;

        return new int[]{w, h};
    }
}
