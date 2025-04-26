import java.util.HashSet;
import java.util.Set;

public class CheckSubset {

    // Method to check if one set is a subset of another
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1);  // Returns true if set1 is a subset of set2
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        boolean isSubset = isSubset(set1, set2);

        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }
}
