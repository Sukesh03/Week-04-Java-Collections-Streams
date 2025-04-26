import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {

    public static void extractLinks(String text) {
        Pattern pattern = Pattern.compile("https?://[\\w.-]+(?:/[\\w\\-._~:/?#@!$&'()*+,;=]*)?");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String input = "Visit https://www.google.com and http://example.org for more info.";
        extractLinks(input);
    }
}
