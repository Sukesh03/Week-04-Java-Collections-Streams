import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatter {

    private static final SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static String formatDate(String inputDate) throws ParseException {
        // Check if the input date matches the expected format
        inputFormat.setLenient(false);  // Disable lenient parsing
        if (inputDate == null || inputDate.trim().isEmpty()) {
            throw new ParseException("Input date is empty or null", 0);
        }

        try {
            // Attempt to parse the date
            inputFormat.parse(inputDate);
        } catch (ParseException e) {
            throw new ParseException("Invalid date format: " + inputDate, 0);
        }

        // If valid, convert to desired format
        return outputFormat.format(inputFormat.parse(inputDate));
    }
}
