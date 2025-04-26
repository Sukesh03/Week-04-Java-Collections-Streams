import java.util.LinkedList;

public class FindNthFromEnd {

    // Method to find the Nth element from the end
    public static <T> T findNthFromEnd(LinkedList<T> list, int N) {
        if (list == null || N <= 0 || N > list.size()) {
            return null; // Invalid input or N is out of range
        }

        // Two pointers technique: fast and slow
        var fastPointer = list.listIterator();
        var slowPointer = list.listIterator();

        // Move the fast pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (!fastPointer.hasNext()) {
                return null; // N is larger than the size of the list
            }
            fastPointer.next();
        }

        // Move both pointers one step at a time until the fast pointer reaches the end
        while (fastPointer.hasNext()) {
            fastPointer.next();
            slowPointer.next();
        }

        // The slow pointer is now pointing to the Nth element from the end
        return slowPointer.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("Original List: " + list);

        int N = 2;
        String nthFromEnd = findNthFromEnd(list, N);

        System.out.println("The " + N + "th element from the end is: " + nthFromEnd);
    }
}
