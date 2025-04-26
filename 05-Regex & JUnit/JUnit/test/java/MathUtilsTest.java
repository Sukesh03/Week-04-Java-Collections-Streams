import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void testDivideByNonZero() {
        assertEquals(2, MathUtils.divide(10, 5));
    }

    @Test
    public void testDivideByZeroThrowsException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            MathUtils.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
