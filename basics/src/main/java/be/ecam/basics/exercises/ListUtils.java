// ListUtils.java
package be.ecam.basics.exercises;

import java.util.List;

// Initial Problem (Pitfall: reference aliasing and mutability):
    //           --> ConcurrentModificationException : Mpdifying a list (Removing elements) while iterating (for-each)
    //               caused .
    // Solution :
    //      Use an explicit Iterator and its remove() method to safely modify in loop.


public class ListUtils {

    public static List<String> removeShortStrings(List<String> list, int minLen) {
        // for (String s : list) {
        //     if (s.length() < minLen) {
        //         list.remove(s);
        //     }
        // }
        
        list.removeIf(s -> s.length() < minLen);
        
        return list;
    }
}
