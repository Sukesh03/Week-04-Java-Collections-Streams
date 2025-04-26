import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWordsFinder {

    public static void findRepeatingWords(String text) {
        Set<String> words = new HashSet<>();
        Set<String> repeatedWords = new HashSet<>();

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String word = matcher.group();
            if (!words.add(word)) {
                repeatedWords.add(word);
            }
        }

        for (String word : repeatedWords) {
            System.out.print(word + ", ");
        }
    }

    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";
        findRepeatingWords(input);
    }
}
