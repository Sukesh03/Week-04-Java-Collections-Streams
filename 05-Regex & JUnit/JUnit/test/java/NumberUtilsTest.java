import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEvenReturnsTrueForEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testIsEvenReturnsFalseForOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number), number + " should be odd");
    }
}
