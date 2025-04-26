import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();

        // Enqueue the first binary number
        queue.add("1");

        for (int i = 0; i < n; i++) {
            // Get the current binary number from the front of the queue
            String current = queue.remove();

            // Print the current binary number
            System.out.print(current + " ");

            // Generate next binary numbers and add to queue
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        generateBinaryNumbers(n);
    }
}
