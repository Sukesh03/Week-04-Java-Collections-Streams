import java.util.HashSet;
import java.util.Set;

public class UnionIntersectionOfSets {

    // Method to compute the union of two sets
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);  // Create a new set with the elements of set1
        result.addAll(set2);  // Add all elements of set2
        return result;
    }

    // Method to compute the intersection of two sets
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);  // Create a new set with the elements of set1
        result.retainAll(set2);  // Retain only elements that are present in set2
        return result;
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

        Set<Integer> unionSet = union(set1, set2);
        Set<Integer> intersectionSet = intersection(set1, set2);

        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
    }
}
