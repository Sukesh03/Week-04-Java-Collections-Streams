public class UsernameValidator {

    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        String[] testUsernames = {
                "user_123",
                "123user",
                "us",
                "valid_user1",
                "user-name",
                "user1234567890123",
                "user12345678901234"
        };

        for (String username : testUsernames) {
            System.out.printf("%-20s → %s%n", username, isValidUsername(username) ? "Valid" : "Invalid");
        }
    }
}
