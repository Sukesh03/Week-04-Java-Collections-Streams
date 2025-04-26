import java.util.function.BiFunction;

public class BiFunctionInterfaceApp {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenateWithSpace = (str1, str2) -> str1 + " " + str2;

        String result = concatenateWithSpace.apply("Hello", "World");

        System.out.println(result);
    }
}
