import java.util.HashSet;
import java.util.Set;

public class CheckSetsEqual {

    // Method to check if two sets are equal
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);  // Returns true if both sets have the same elements
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(2);
        set2.add(1);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        boolean areEqual = areSetsEqual(set1, set2);

        System.out.println("Are the two sets equal? " + areEqual);
    }
}
