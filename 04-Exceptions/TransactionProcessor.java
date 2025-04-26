
class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

public class TransactionProcessor {

    public static void processTransaction(String userId, double amount) throws TransactionException {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }
            // Simulate transaction logic
            System.out.println("Processed transaction of $" + amount + " for user: " + userId);
        } catch (IllegalArgumentException e) {
            throw new TransactionException("Transaction failed for user '" + userId +
                    "' with amount $" + amount + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            processTransaction("user123", -150.00);
        } catch (TransactionException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            processTransaction("user456", 250.00);
        } catch (TransactionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
