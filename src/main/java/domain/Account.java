package domain;

import exception.AmountToWithdrawHigherThanBalanceException;
import exception.DifferentCurrencyOperationException;
import exception.NegativeDepositAmountException;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Account {
    private Money balance;
    private List<Operation> operations = new ArrayList<>();

    public Money deposit(Money amountToAdd) {
        if (amountToAdd.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new NegativeDepositAmountException();
        if (!amountToAdd.getCurrency().equals(this.getBalance().getCurrency()))
            throw new DifferentCurrencyOperationException();
        return balance.addAmount(amountToAdd);
    }

    public Money withdraw(Money amountToWithdraw) {
        if (balance.getAmount().compareTo(amountToWithdraw.getAmount()) < 0)
            throw new AmountToWithdrawHigherThanBalanceException();
        return balance.retrieveAmount(amountToWithdraw);
    }
}