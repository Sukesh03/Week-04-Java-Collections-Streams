public class SpaceReplacer {

    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        String input = "This  is   an    example    with    multiple   spaces.";
        String result = replaceMultipleSpaces(input);
        System.out.println(result);
    }
}
