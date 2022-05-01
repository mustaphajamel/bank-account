package domain;

import exception.DifferentCurrencyOperationException;
import exception.NegativeDepositAmountException;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Account {
    private Money balance;

    public Money deposit(Money amountToAdd) throws NegativeDepositAmountException,DifferentCurrencyOperationException {
        if (amountToAdd.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new NegativeDepositAmountException();
        else if(!amountToAdd.getCurrency().equals(this.getBalance().getCurrency()))
            throw new DifferentCurrencyOperationException();
        return balance.addAmount(amountToAdd);
    }
}