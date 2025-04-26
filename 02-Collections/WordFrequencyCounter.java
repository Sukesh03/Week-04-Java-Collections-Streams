import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String text) {
        // Regular expression to match words (ignores punctuation)
        String regex = "[^a-zA-Z]+";

        // Convert text to lowercase and split by non-alphabetic characters
        String[] words = text.toLowerCase().split(regex);

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue; // Skip empty strings

            // Update the word count in the map
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    public static void main(String[] args) throws IOException {
        String inputText = "Hello world, hello Java!";

        // Count the frequency of words in the input text
        Map<String, Integer> wordFrequency = countWordFrequency(inputText);

        System.out.println(wordFrequency);
    }
}
