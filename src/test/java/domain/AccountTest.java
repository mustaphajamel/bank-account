package domain;

import exception.DifferentCurrencyOperationException;
import exception.NegativeDepositAmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountTest {

    @Test
    public void should_add_deposit_amount_to_balance() {
        //GIVEN
        Money currentBalance = Money.builder()
                .amount(new BigDecimal(1000))
                .currency(Currency.getInstance("EUR"))
                .build();

        Money amountToAdd = Money.builder()
                .amount(new BigDecimal(200))
                .currency(Currency.getInstance("EUR"))
                .build();

        Account account = Account.builder()
                .balance(currentBalance)
                .build();

        //WHEN
        Money newBalance = account.deposit(amountToAdd);

        //THEN
        assertEquals(new BigDecimal(1200), newBalance.getAmount());
    }

    @Test
    public void should_throw_exception_when_negative_deposit_amount_added_to_balance() {
        //GIVEN
        Money currentBalance = Money.builder()
                .amount(new BigDecimal(1000))
                .currency(Currency.getInstance("EUR"))
                .build();
        Money amountToAdd = Money.builder()
                .amount(new BigDecimal(-200))
                .currency(Currency.getInstance("EUR"))
                .build();

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
        assertEquals("Could not add negative amount to balance", thrown.getMessage());
        assertEquals(new BigDecimal(1000), account.getBalance().getAmount());
    }

    @Test
    public void should_throw_exception_when_account_currency_is_different_from_operation_currency() {
        //GIVEN
        Money currentBalance = Money.builder()
                .amount(new BigDecimal(1000))
                .currency(Currency.getInstance("EUR"))
                .build();
        Money amountToAdd = Money.builder()
                .amount(new BigDecimal(200))
                .currency(Currency.getInstance("USD"))
                .build();

        Account account = Account.builder()
                .balance(currentBalance)
                .build();

        //WHEN
        DifferentCurrencyOperationException thrown = Assertions.assertThrows(
                DifferentCurrencyOperationException.class,
                () -> account.deposit(amountToAdd),
                "Expected deposit method to throw, but it didn't"
        );

        //THEN
        assertEquals("Operation currency should be the same of the account", thrown.getMessage());
        assertEquals(new BigDecimal(1000), account.getBalance().getAmount());
    }
    @Test
    public void should_retrieve_withdrawal_amount_from_balance() {
        //GIVEN
        Money currentBalance = Money.builder()
                .amount(new BigDecimal(1000))
                .currency(Currency.getInstance("EUR"))
                .build();

        Money amountToWithdraw = Money.builder()
                .amount(new BigDecimal(200))
                .currency(Currency.getInstance("EUR"))
                .build();

        Account account = Account.builder()
                .balance(currentBalance)
                .build();

        //WHEN
        Money newBalance = account.withdraw(amountToWithdraw);

        //THEN
        assertEquals(new BigDecimal(800), newBalance.getAmount());
    }


}
