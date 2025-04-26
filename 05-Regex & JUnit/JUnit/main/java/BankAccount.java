public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Cannot deposit negative amount");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Cannot withdraw negative amount");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
