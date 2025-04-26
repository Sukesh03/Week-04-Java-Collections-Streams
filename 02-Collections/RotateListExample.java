import java.util.ArrayList;
import java.util.List;

public class RotateListExample {

    // Method to rotate the list by n positions
    public static <T> List<T> rotateList(List<T> list, int positions) {
        int size = list.size();

        // If list is empty or positions is 0 or multiple of the list size, no need to rotate
        if (size == 0 || positions % size == 0) {
            return list;
        }

        // Normalize the positions to ensure it's within the size of the list
        positions = positions % size;

        // Create the rotated list
        List<T> rotatedList = new ArrayList<>();

        // Add the elements from positions to the end of the list
        for (int i = positions; i < size; i++) {
            rotatedList.add(list.get(i));
        }

        // Add the elements from the start to positions - 1
        for (int i = 0; i < positions; i++) {
            rotatedList.add(list.get(i));
        }

        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("Original List: " + numbers);

        List<Integer> rotatedList = rotateList(numbers, 2);

        System.out.println("List after rotating by 2: " + rotatedList);
    }
}
