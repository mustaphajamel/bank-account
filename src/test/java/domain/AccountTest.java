package domain;

import exception.NegativeDepositAmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class AccountTest {

    @Test
    public void should_add_deposit_amount_to_balance() throws NegativeDepositAmountException {
        //GIVEN
        BigDecimal currentBalance = new BigDecimal(1000);
        BigDecimal amountToAdd = new BigDecimal(200);
        Account account = Account.builder()
                .balance(currentBalance)
                .build();

        //WHEN
        BigDecimal newBalance = account.deposit(amountToAdd);

        //THEN
        assertEquals(new BigDecimal(1200), newBalance);
    }

    @Test
    public void should_throw_exception_when_negative_deposit_amount_added_to_balance() {
        //GIVEN
        BigDecimal currentBalance = new BigDecimal(1000);
        BigDecimal amountToAdd = new BigDecimal(-200);
        Account account = Account.builder()
                .balance(currentBalance)
                .build();

        //WHEN
        NegativeDepositAmountException thrown = Assertions.assertThrows(
                NegativeDepositAmountException.class,
                () -> account.deposit(amountToAdd),
                "Expected deposit method to throw, but it didn't"
        );

        //THEN
        assertTrue(thrown.getMessage().contains("Stuff"));
        assertEquals(new BigDecimal(1000), account.getBalance());
    }


}
