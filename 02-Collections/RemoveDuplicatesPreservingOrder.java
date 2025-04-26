import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicatesPreservingOrder {

    // Method to remove duplicates while preserving order
    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> result = new ArrayList<>();
        HashSet<T> seen = new HashSet<>();

        for (T item : list) {
            // If the item hasn't been seen, add it to result and mark it as seen
            if (!seen.contains(item)) {
                result.add(item);
                seen.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println("Original List: " + numbers);

        List<Integer> uniqueNumbers = removeDuplicates(numbers);

        System.out.println("List after removing duplicates: " + uniqueNumbers);
    }
}
