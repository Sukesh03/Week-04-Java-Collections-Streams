import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageExtractor {

    public static void extractLanguages(String text) {
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "PHP");
        Pattern pattern = Pattern.compile(String.join("|", languages));
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        String input = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        extractLanguages(input);
    }
}
