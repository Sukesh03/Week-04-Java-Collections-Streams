import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordExtractor {

    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String input = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        extractCapitalizedWords(input);
    }
}
