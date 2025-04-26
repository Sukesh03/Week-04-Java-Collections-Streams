public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        if (password.length() < 8) return false;

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isDigit(c)) hasDigit = true;
        }

        return hasUpperCase && hasDigit;
    }
}
