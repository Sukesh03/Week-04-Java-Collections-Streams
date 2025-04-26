import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pipedOutputStream;

    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try {
            String data = "Hello from Writer Thread!";
            // Write data to the PipedOutputStream
            pipedOutputStream.write(data.getBytes());
            pipedOutputStream.close();  // Close the stream after writing
            System.out.println("Writer Thread has finished writing data.");
        } catch (IOException e) {
            System.out.println("Error in WriterThread: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pipedInputStream;

    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            // Read data from PipedInputStream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = pipedInputStream.read(buffer)) != -1) {
                String receivedData = new String(buffer, 0, bytesRead);
                System.out.println("Reader Thread received: " + receivedData);
            }
            pipedInputStream.close();  // Close the stream after reading
            System.out.println("Reader Thread has finished reading data.");
        } catch (IOException e) {
            System.out.println("Error in ReaderThread: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {

    public static void main(String[] args) {
        try {
            // Create a PipedOutputStream and PipedInputStream
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            // Create threads for writing and reading data
            WriterThread writerThread = new WriterThread(pipedOutputStream);
            ReaderThread readerThread = new ReaderThread(pipedInputStream);

            // Start the threads
            writerThread.start();
            readerThread.start();

            // Wait for both threads to finish
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error in PipedStreamExample: " + e.getMessage());
        }
    }
}
