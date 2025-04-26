import java.util.HashSet;
import java.util.Set;

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {

    private static Set<String> users = new HashSet<>();

    public static void registerUser(String username) throws UserAlreadyExistsException {
        if (users.contains(username)) {
            throw new UserAlreadyExistsException("User '" + username + "' already exists.");
        }
        users.add(username);
        System.out.println("User '" + username + "' registered successfully.");
    }

    public static void checkUserExistence(String username) throws UserNotFoundException {
        if (!users.contains(username)) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        System.out.println("User '" + username + "' exists in the system.");
    }

    public static void main(String[] args) {
        try {
            registerUser("alice");
            registerUser("bob");
            registerUser("alice");
        } catch (UserAlreadyExistsException e) {
            System.err.println("Registration Error: " + e.getMessage());
        }

        try {
            checkUserExistence("carol");
        } catch (UserNotFoundException e) {
            System.err.println("Lookup Error: " + e.getMessage());
        }

        try {
            checkUserExistence("bob");
        } catch (UserNotFoundException e) {
            System.err.println("Lookup Error: " + e.getMessage());
        }
    }
}
