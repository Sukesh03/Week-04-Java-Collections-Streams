import java.util.*;
import java.util.function.Consumer;

public class ConsumerInterfaceApp {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        Consumer<String> printUppercase = word -> System.out.println(word.toUpperCase());

        words.forEach(printUppercase);
    }
}
