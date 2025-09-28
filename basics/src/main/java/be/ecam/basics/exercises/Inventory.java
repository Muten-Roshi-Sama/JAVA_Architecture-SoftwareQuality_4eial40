// Inventory.java
package be.ecam.basics.exercises;

import java.util.List;

// Initial Problem (Pitfall: string reference equality vs content equality):
    //           --> Used '==' to compare Strings (compares references, not values).
    // Solution :
    //      Use .equals() (with null safety) to compare by value.


public class Inventory {

    public static class Item {
        private final String sku;
        public Item(String sku) { this.sku = sku; }
        public String getSku() { return sku; }
    }

    public static boolean hasSku(List<Item> items, String sku) {
        for (Item i : items) {
            if (sku == null) {
                if (i.getSku() == null) return true;
            } else {
                if (sku.equals(i.getSku())) return true;
            }
            
        }
        return false;
    }
}
