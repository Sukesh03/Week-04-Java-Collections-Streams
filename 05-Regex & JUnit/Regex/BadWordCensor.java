import java.util.Arrays;
import java.util.List;

public class BadWordCensor {

    public static String censorBadWords(String text, List<String> badWords) {
        for (String badWord : badWords) {
            text = text.replaceAll("\\b" + badWord + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");

        String result = censorBadWords(input, badWords);
        System.out.println(result);
    }
}
