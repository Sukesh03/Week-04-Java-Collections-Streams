import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push element to the stack
    public void push(int x) {
        queue1.add(x);
    }

    // Pop element from the stack
    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int top = queue1.remove();

        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Get the top element of the stack
    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int top = queue1.peek();

        // Move the element back to queue1
        queue2.add(queue1.remove());

        // Swap references
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop: " + stack.pop()); // Output: 3
    }
}
