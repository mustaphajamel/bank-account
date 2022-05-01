package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountTest {

    @Test
    public void should_add_deposit_amount_to_balance() {
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
    public void should_not_add_negative_deposit_amount_to_balance() {
        //GIVEN
        BigDecimal currentBalance = new BigDecimal(1000);
        BigDecimal amountToAdd = new BigDecimal(-200);
        Account account = Account.builder()
                .balance(currentBalance)
                .build();

        //WHEN
        BigDecimal newBalance = account.deposit(amountToAdd);

        //THEN
        assertEquals(new BigDecimal(1000), newBalance);
    }



}
