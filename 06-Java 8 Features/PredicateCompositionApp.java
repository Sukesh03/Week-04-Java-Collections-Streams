import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateCompositionApp {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elephant", "kiwi", "grape");

        Predicate<String> lengthGreaterThanFive = word -> word.length() > 5;

        Predicate<String> containsSubstring = word -> word.contains("an");

        Predicate<String> combinedPredicate = lengthGreaterThanFive.and(containsSubstring);


        List<String> filteredWords = words.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());

        System.out.println("Filtered words: " + filteredWords);
    }
}
