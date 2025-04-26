import org.junit.jupiter.api.Test;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    @Test
    public void testValidDateFormat() throws ParseException {
        String inputDate = "2025-05-06";
        String expectedDate = "06-05-2025";
        assertEquals(expectedDate, DateFormatter.formatDate(inputDate), "Valid date should be formatted correctly");
    }

    @Test
    public void testInvalidDateFormat() {
        String invalidDate = "2025-13-06"; // Invalid month
        assertThrows(ParseException.class, () -> DateFormatter.formatDate(invalidDate), "Invalid date should throw ParseException");
    }

    @Test
    public void testInvalidDateWithText() {
        String invalidTextDate = "2025-05-XYZ";
        assertThrows(ParseException.class, () -> DateFormatter.formatDate(invalidTextDate), "Date with text should throw ParseException");
    }

    @Test
    public void testEmptyDate() {
        String emptyDate = "";
        assertThrows(ParseException.class, () -> DateFormatter.formatDate(emptyDate), "Empty date string should throw ParseException");
    }
}
