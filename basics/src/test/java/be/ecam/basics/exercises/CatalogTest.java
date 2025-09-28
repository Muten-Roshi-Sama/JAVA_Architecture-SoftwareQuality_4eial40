// CatalogTest.java

package be.ecam.basics.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    @Test
    void nullTagsShouldBeTreatedAsEmpty() {
        // Even if null is passed, constructor will replace it with an empty list
        Catalog.Product p = new Catalog.Product("Toy", null);
        assertEquals(0, Catalog.countTags(p));
    }

    @Test
    void emptyTags() {
        // An empty list should still count as 0
        Catalog.Product p = new Catalog.Product("Toy", new ArrayList<>());
        assertEquals(0, Catalog.countTags(p));
    }

    @Test
    void someTags() {
        // Two tags => size should be 2
        Catalog.Product p = new Catalog.Product("Toy", new ArrayList<>(Arrays.asList("kid", "fun")));
        assertEquals(2, Catalog.countTags(p));
    }
}

// class CatalogTest {

//     @Test
//     void nullTagsShouldBeTreatedAsEmpty() {
//         Catalog.Product p = new Catalog.Product("Toy", null);
//         assertEquals(0, Catalog.countTags(p));
//     }

//     @Test
//     void emptyTags() {
//         Catalog.Product p = new Catalog.Product("Toy", new ArrayList<>());
//         assertEquals(0, Catalog.countTags(p));
//     }

//     @Test
//     void someTags() {
//         Catalog.Product p = new Catalog.Product("Toy", new ArrayList<>(Arrays.asList("kid", "fun")));
//         assertEquals(2, Catalog.countTags(p));
//     }
// }
