import java.util.HashSet;
import java.util.Set;

public class SymmetricDifferenceOfSets {

    // Method to compute the symmetric difference of two sets
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);  // Union of the two sets

        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);  // Intersection of the two sets

        unionSet.removeAll(intersectionSet);  // Remove intersection elements from the union

        return unionSet;  // The remaining elements are in the symmetric difference
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        Set<Integer> symmetricDiff = symmetricDifference(set1, set2);

        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}
