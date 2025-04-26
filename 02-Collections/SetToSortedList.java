import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class SetToSortedList {

    // Method to convert a HashSet to a sorted List
    public static List<Integer> convertSetToSortedList(HashSet<Integer> set) {
        // Convert HashSet to List
        List<Integer> list = new ArrayList<>(set);

        // Sort the List in ascending order
        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        System.out.println("Original Set: " + set);

        List<Integer> sortedList = convertSetToSortedList(set);

        System.out.println("Sorted List: " + sortedList);
    }
}
