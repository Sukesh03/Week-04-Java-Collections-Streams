import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }

    @Test
    public void testDepositIncreasesBalance() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void testWithdrawFailsWhenInsufficientFunds() {
        account.deposit(30.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(50.0));
    }

    @Test
    public void testNegativeDepositThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    public void testNegativeWithdrawThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }
}
