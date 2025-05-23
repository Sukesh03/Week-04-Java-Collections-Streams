import java.util.*;
import java.util.stream.Collectors;

public class MapReduceSumSquaresApp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0)  // filter even numbers
                .map(n -> n * n)           // square each number
                .reduce(0, (sum, square) -> sum + square);  // sum the squares

        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
