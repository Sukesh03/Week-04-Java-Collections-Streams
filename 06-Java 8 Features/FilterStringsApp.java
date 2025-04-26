import java.util.*;
import java.util.stream.Collectors;

public class FilterStringsApp {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Angela", "David");

        List<String> filtered = names.stream()
                .filter(name -> !name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
    }
}
