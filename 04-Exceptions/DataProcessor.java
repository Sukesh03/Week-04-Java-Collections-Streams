import java.io.IOException;

class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}

public class DataProcessor {

    public static void processData(String input) throws DataProcessingException {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (input.equalsIgnoreCase("error")) {
            throw new DataProcessingException("Checked exception: Invalid data encountered");
        }

        System.out.println("Processed data: " + input);
    }

    public static void main(String[] args) {
        String[] testInputs = { "hello", null, "error" };

        for (String input : testInputs) {
            try {
                processData(input);
            } catch (DataProcessingException e) {
                System.err.println("Checked Exception Caught: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Unchecked Exception Caught: " + e.getMessage());
            }
        }
    }
}
