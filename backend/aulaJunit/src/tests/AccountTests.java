import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {
        double initialBalance = 200.0;
        double amount = 100.0;
        double expectedValue = 300.0;
        Account acc = new Account(1L, initialBalance);
        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }
}
