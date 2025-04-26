import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {

    public static void extractEmails(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String input = "Contact us at support@example.com and info@company.org";
        extractEmails(input);
    }
}
