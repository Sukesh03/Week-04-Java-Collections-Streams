import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // Create BufferedReader to read user input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Variables to store user input
        String name = "";
        int age = 0;
        String favoriteLanguage = "";

        // FileWriter to write user data into a file
        FileWriter writer = null;

        try {
            // Ask user for their name
            System.out.print("Enter your name: ");
            name = reader.readLine();

            // Ask user for their age
            System.out.print("Enter your age: ");
            age = Integer.parseInt(reader.readLine());

            // Ask user for their favorite programming language
            System.out.print("Enter your favorite programming language: ");
            favoriteLanguage = reader.readLine();

            // Create a FileWriter to write to a file
            writer = new FileWriter("user_info.txt");

            // Write data into the file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + favoriteLanguage + "\n");

            System.out.println("Information saved successfully in 'user_info.txt'.");

        } catch (IOException e) {
            // Handle potential IO exceptions
            System.out.println("An error occurred while reading input or writing to the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Handle invalid input for age
            System.out.println("Invalid input for age. Please enter a valid integer.");
        } finally {
            try {
                // Close the BufferedReader and FileWriter
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
