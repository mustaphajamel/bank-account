package domain;

import exception.NegativeDepositAmountException;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Account {
    private Money balance;

    public Money deposit(Money amountToAdd) throws NegativeDepositAmountException {
        if (amountToAdd.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new NegativeDepositAmountException();
        return balance.addAmount(amountToAdd);
    }
}