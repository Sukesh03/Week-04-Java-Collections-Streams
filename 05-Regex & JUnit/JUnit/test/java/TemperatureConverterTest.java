import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    @Test
    public void testCelsiusToFahrenheit() {
        // Test cases for Celsius to Fahrenheit conversion
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), "0°C should be 32°F");
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), "100°C should be 212°F");
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40.0), "-40°C should be -40°F");
    }

    @Test
    public void testFahrenheitToCelsius() {
        // Test cases for Fahrenheit to Celsius conversion
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), "32°F should be 0°C");
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), "212°F should be 100°C");
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40.0), "-40°F should be -40°C");
    }
}
