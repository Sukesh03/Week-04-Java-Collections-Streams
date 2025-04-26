import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    public void testValidRegistration() {
        // Test case where valid username, email, and password are provided
        assertDoesNotThrow(() -> UserRegistration.registerUser("validUser", "valid@example.com", "validPass123"));
    }

    @Test
    public void testInvalidUsername() {
        // Test case where username is empty
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "valid@example.com", "validPass123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser(null, "valid@example.com", "validPass123"));
    }

    @Test
    public void testInvalidEmail() {
        // Test case where email is invalid (no @ or .)
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("validUser", "invalidEmail", "validPass123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("validUser", "invalid@com", "validPass123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("validUser", null, "validPass123"));
    }

    @Test
    public void testInvalidPassword() {
        // Test case where password is too short
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("validUser", "valid@example.com", "short"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("validUser", "valid@example.com", null));
    }

    @Test
    public void testNullInputs() {
        // Test case where username, email, or password are null
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser(null, "valid@example.com", "validPass123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("validUser", null, "validPass123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("validUser", "valid@example.com", null));
    }
}
