import java.io.*;

public class UppercaseToLowercase {

    // Method to read a file and convert uppercase to lowercase, then write to another file
    public static void convertToLowercase(String inputFilePath, String outputFilePath) throws IOException {
        // Create FileReader and BufferedReader to read the file
        try (FileReader fileReader = new FileReader(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             // Create FileWriter and BufferedWriter to write to the output file
             FileWriter fileWriter = new FileWriter(outputFilePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String line;
            // Read each line from the input file
            while ((line = bufferedReader.readLine()) != null) {
                // Convert the line to lowercase and write to the output file
                bufferedWriter.write(line.toLowerCase());
                bufferedWriter.newLine();  // Write a new line after each line of text
            }
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "input.txt";  // Replace with your input file path
        String outputFilePath = "output.txt"; // Replace with your output file path

        try {
            // Convert uppercase to lowercase and save to the output file
            convertToLowercase(inputFilePath, outputFilePath);
            System.out.println("File has been processed successfully. Uppercase letters converted to lowercase.");
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        }
    }
}
