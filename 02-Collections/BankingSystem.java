import java.util.*;

public class BankingSystem {
    // HashMap to store account balance (Account Number -> Balance)
    private Map<String, Double> accounts = new HashMap<>();

    // TreeMap to sort customers by their balance
    private Map<String, Double> sortedAccounts = new TreeMap<>(Comparator.comparing(accounts::get));

    // Queue to process withdrawal requests
    private Queue<String> withdrawalQueue = new LinkedList<>();

    // Method to create an account
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(accountNumber, initialBalance);
    }

    // Method to deposit money into an account
    public void deposit(String accountNumber, double amount) {
        accounts.put(accountNumber, accounts.get(accountNumber) + amount);
        sortedAccounts.put(accountNumber, accounts.get(accountNumber));
    }

    // Method to withdraw money from an account
    public void withdraw(String accountNumber, double amount) {
        if (accounts.get(accountNumber) >= amount) {
            accounts.put(accountNumber, accounts.get(accountNumber) - amount);
            sortedAccounts.put(accountNumber, accounts.get(accountNumber));
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Insufficient funds for account: " + accountNumber);
        }
    }

    // Method to process withdrawal requests from the queue
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Withdrawal processed for account: " + accountNumber);
        }
    }

    // Method to display sorted customer balances
    public void displaySortedAccounts() {
        System.out.println("Customers Sorted by Balance (TreeMap): ");
        for (Map.Entry<String, Double> entry : sortedAccounts.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();

        // Create accounts
        system.createAccount("A123", 5000.0);
        system.createAccount("B456", 1500.0);
        system.createAccount("C789", 2500.0);

        // Deposit money into accounts
        system.deposit("A123", 1000.0);
        system.deposit("B456", 500.0);

        // Withdraw money from accounts
        system.withdraw("A123", 1000.0);
        system.withdraw("C789", 500.0);

        // Process withdrawals
        system.processWithdrawals();

        // Display sorted accounts
        system.displaySortedAccounts();
    }
}
