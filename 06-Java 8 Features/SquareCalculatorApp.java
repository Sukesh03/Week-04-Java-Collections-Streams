@FunctionalInterface
interface SquareCalculator {
    int square(int number);

    default void printResult(int number) {
        System.out.println("The square of " + number + " is: " + square(number));
    }
}

public class SquareCalculatorApp {
    public static void main(String[] args) {
        SquareCalculator calculator = n -> n * n;
        calculator.printResult(7);
    }
}
