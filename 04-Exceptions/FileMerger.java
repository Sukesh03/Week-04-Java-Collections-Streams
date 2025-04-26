import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMerger {

    public static void mergeFiles(String file1, String file2, String outputFile) {
        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(file1));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Files merged successfully into " + outputFile);
        } catch (IOException e) {
            System.err.println("An error occurred while merging files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String outputFile = "combined.txt";
        mergeFiles(file1, file2, outputFile);
    }
}
