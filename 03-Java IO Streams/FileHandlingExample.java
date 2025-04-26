import java.io.*;

public class FileHandlingExample {
    public static void main(String[] args) {
        // Specify the source and destination file paths
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        // Create FileInputStream and FileOutputStream
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            // Check if source file exists
            File sourceFile = new File(sourceFilePath);
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            // Read the contents of the source file and write them into the destination file
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred during file handling.");
            e.printStackTrace();
        }
    }
}
