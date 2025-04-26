import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;

public class WordFrequencyAnalyzer {
    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("corpus.txt")));

        int topN = 10;

        Map<String, Long> frequencyMap = Arrays.stream(text
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z\\s]", "")
                        .split("\\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<Map.Entry<String, Long>> topWords = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .collect(Collectors.toList());

        topWords.forEach(entry ->
                System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}
