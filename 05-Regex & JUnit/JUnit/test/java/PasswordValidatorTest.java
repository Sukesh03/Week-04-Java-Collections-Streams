import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void testValidPassword() {
        String validPassword = "Password1";
        assertTrue(PasswordValidator.isValidPassword(validPassword), "Password should be valid");
    }

    @Test
    public void testPasswordTooShort() {
        String shortPassword = "Pass1";
        assertFalse(PasswordValidator.isValidPassword(shortPassword), "Password should be too short");
    }

    @Test
    public void testPasswordMissingUpperCase() {
        String passwordWithoutUpperCase = "password1";
        assertFalse(PasswordValidator.isValidPassword(passwordWithoutUpperCase), "Password should require an uppercase letter");
    }

    @Test
    public void testPasswordMissingDigit() {
        String passwordWithoutDigit = "Password";
        assertFalse(PasswordValidator.isValidPassword(passwordWithoutDigit), "Password should require a digit");
    }

    @Test
    public void testNullPassword() {
        String nullPassword = null;
        assertFalse(PasswordValidator.isValidPassword(nullPassword), "Password should not be valid");
    }

    @Test
    public void testPasswordWithOnlyUpperCase() {
        String passwordWithOnlyUpperCase = "PASSWORD";
        assertFalse(PasswordValidator.isValidPassword(passwordWithOnlyUpperCase), "Password should require a digit");
    }

    @Test
    public void testPasswordWithOnlyDigit() {
        String passwordWithOnlyDigit = "12345678";
        assertFalse(PasswordValidator.isValidPassword(passwordWithOnlyDigit), "Password should require an uppercase letter");
    }
}
