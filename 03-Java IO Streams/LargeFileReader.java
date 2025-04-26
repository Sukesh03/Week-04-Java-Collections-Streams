import java.io.*;

public class LargeFileReader {

    public static void readFileAndFindErrors(String filePath) {
        BufferedReader reader = null;
        try {
            // Create a BufferedReader to read the file line by line
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Check if the line contains the word "error" (case-insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);  // Print the line if it contains "error"
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();  // Ensure the reader is closed after use
                }
            } catch (IOException e) {
                System.out.println("Error closing the file reader: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "large_file.txt"; // Replace with your file path
        readFileAndFindErrors(filePath);  // Call the method to read the file
    }
}
