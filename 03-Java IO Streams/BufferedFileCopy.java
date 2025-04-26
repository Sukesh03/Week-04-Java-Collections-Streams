import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        // Define source and destination file paths
        String sourceFilePath = "largefile.txt";  // Path to a large file (e.g., 100MB)
        String destinationFilePathBuffered = "destinationBuffered.txt";
        String destinationFilePathUnbuffered = "destinationUnbuffered.txt";

        // Copy using Buffered Streams
        long startTimeBuffered = System.nanoTime();
        copyFileBuffered(sourceFilePath, destinationFilePathBuffered);
        long endTimeBuffered = System.nanoTime();
        System.out.println("Buffered copy time: " + (endTimeBuffered - startTimeBuffered) + " nanoseconds");

        // Copy using Unbuffered Streams
        long startTimeUnbuffered = System.nanoTime();
        copyFileUnbuffered(sourceFilePath, destinationFilePathUnbuffered);
        long endTimeUnbuffered = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endTimeUnbuffered - startTimeUnbuffered) + " nanoseconds");
    }

    // Method to copy file using Buffered Streams
    private static void copyFileBuffered(String sourceFilePath, String destinationFilePath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFilePath))) {

            byte[] buffer = new byte[4096];  // Buffer size of 4 KB
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered copy completed.");
        } catch (IOException e) {
            System.out.println("An error occurred during buffered file copy.");
            e.printStackTrace();
        }
    }

    // Method to copy file using Unbuffered Streams
    private static void copyFileUnbuffered(String sourceFilePath, String destinationFilePath) {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
            System.out.println("Unbuffered copy completed.");
        } catch (IOException e) {
            System.out.println("An error occurred during unbuffered file copy.");
            e.printStackTrace();
        }
    }
}
