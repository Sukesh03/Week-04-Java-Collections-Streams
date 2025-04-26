import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    // Method to reverse the queue using recursion
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element
        int front = queue.remove();

        // Reverse the rest of the queue
        reverseQueue(queue);

        // Add the front element back to the queue
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
