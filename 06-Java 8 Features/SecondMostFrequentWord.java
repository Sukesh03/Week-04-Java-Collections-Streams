import java.util.*;
import java.util.stream.*;

public class SecondMostFrequentWord {
    public static void main(String[] args) {
        String text = "apple banana apple orange banana apple mango orange banana";

        Map<String, Long> wordFrequency = Arrays.stream(text
                        .toLowerCase()
                        .replaceAll("[^a-z\\s]", "")
                        .split("\\s+"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        Optional<Map.Entry<String, Long>> secondMost = wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst();

        if (secondMost.isPresent()) {
            System.out.println("Second most frequent word: " + secondMost.get().getKey());
            System.out.println("Frequency: " + secondMost.get().getValue());
        } else {
            System.out.println("Not enough words to determine the second most frequent.");
        }
    }
}
