@FunctionalInterface
interface IntSum {
    int add(int a, int b);
}

public class SumFunctionalInterfaceApp {
    public static void main(String[] args) {
        IntSum sum = (a, b) -> a + b;

        int result = sum.add(10, 20);
        System.out.println("Sum: " + result);
    }
}
