import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    public void testReverse() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("", StringUtils.reverse(""));
        assertEquals("a", StringUtils.reverse("a"));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(StringUtils.isPalindrome("madonna"));
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome(null));
        assertTrue(StringUtils.isPalindrome("a"));
        assertTrue(StringUtils.isPalindrome(""));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("", StringUtils.toUpperCase(""));
        assertEquals("JAVA", StringUtils.toUpperCase("Java"));
        assertNull(StringUtils.toUpperCase(null));
    }
}
