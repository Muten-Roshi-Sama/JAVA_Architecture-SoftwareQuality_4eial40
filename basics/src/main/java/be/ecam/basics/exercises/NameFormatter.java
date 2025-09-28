// NameFormatter.java
package be.ecam.basics.exercises;

// Initial Problem (Pitfall: null handling and NullPointerException):
    //           --> Calling isEmpty() on a null middleName causes NPE.
    // Solution :
    //      Check for null before trimming/appending the middle name.


public class NameFormatter {
    public static class Person {

        private final String firstName;
        private final String middleName;
        private final String lastName;

        public Person(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        public String getFirstName() { return firstName; }
        public String getMiddleName() { return middleName; }
        public String getLastName() { return lastName; }
    }



    public static String displayName(Person p) {
        String s = p.getFirstName().trim();

        // if (!p.getMiddleName().isEmpty()) {
        //     s += " " + p.getMiddleName().trim();
        // }

        if (p.getMiddleName() != null && !p.getMiddleName().isEmpty()) {
            s += " " + p.getMiddleName().trim();
        }

        s += " " + p.getLastName().trim();
        return s;
    }
}
