public class CircularBuffer {
    private int[] buffer;
    private int head, tail, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    // Insert an element into the circular buffer
    public void insert(int value) {
        if (size == capacity) {
            // Buffer is full, overwrite the oldest element (head)
            head = (head + 1) % capacity;
        } else {
            size++;
        }
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
    }

    // Display the buffer contents
    public void displayBuffer() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.displayBuffer(); // Output: 1 2 3

        buffer.insert(4);
        buffer.displayBuffer(); // Output: 2 3 4
    }
}
