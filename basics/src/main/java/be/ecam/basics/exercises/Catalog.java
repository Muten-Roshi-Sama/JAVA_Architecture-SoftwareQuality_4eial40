// Catalog.java

package be.ecam.basics.exercises;

import java.util.List;

import java.util.ArrayList;

// Initial Problem :
//           -->  null handling in collections (tags).
// Solution :
//      Fix the constructor: normalize tags as an ArrayList        



public class Catalog {
    public static class Product {
        private final String name;
        private final List<String> tags;

        public Product(String name, List<String> tags) {
            this.name = name;
            this.tags = (tags == null ? new ArrayList<>() : tags);
        }

        public String getName() { return name; }
        public List<String> getTags() { return tags; }
    }

    public static int countTags(Product p) {
        return p.getTags().size();
    }
}




// import org.jetbrain.annotation.NotNull;

// public class Catalog {
//     public static class Product {
//         private final String name;
//         private final List<String> tags;

//         public Product(String name, @NotNull List<String> tags) {
//             this.name = name;
//             this.tags = tags;
//         }

//         public String getName() { return name; }
//         public List<String> getTags() { return tags; }
//     }

//     public static int countTags(Product p) {
//         return p.getTags().size();
//     }
// }


