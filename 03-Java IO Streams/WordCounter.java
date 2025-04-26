import java.io.*;
import java.util.*;

public class WordCounter {

    // Method to count the words in a file and display the top 5 most frequent ones
    public static void countWords(String filePath) {
        // HashMap to store the frequency of each word
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // BufferedReader to read the file line by line
        BufferedReader reader = null;

        try {
            // Create a BufferedReader to read the file
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Split the line into words (using a regular expression to handle multiple spaces)
                String[] words = line.split("\\W+");

                // Count the occurrence of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();  // Make the word lowercase to count words case-insensitively
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Create a list from the map entries to sort by value (word frequency)
            List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCountMap.entrySet());

            // Sort the list by the frequency of the words in descending order
            wordList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            // Display the top 5 most frequent words
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, wordList.size()); i++) {
                Map.Entry<String, Integer> entry = wordList.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();  // Close the BufferedReader
                }
            } catch (IOException e) {
                System.out.println("Error closing the file reader: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";  // Replace with the path to your text file
        countWords(filePath);  // Call the method to count words in the file
    }
}
