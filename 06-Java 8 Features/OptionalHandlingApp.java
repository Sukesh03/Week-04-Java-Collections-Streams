import java.util.*;

public class OptionalHandlingApp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 45, 67, 23, 89);

        Optional<Integer> max = numbers.stream()
                .max(Comparator.naturalOrder());

        max.ifPresentOrElse(
                value -> System.out.println("Maximum value: " + value),
                () -> System.out.println("List is empty")
        );
    }
}
