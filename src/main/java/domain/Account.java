package domain;

import exception.NegativeDepositAmountException;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Account {
    private BigDecimal balance;

    public BigDecimal deposit(BigDecimal amountToAdd) throws NegativeDepositAmountException {
        if (amountToAdd.compareTo(BigDecimal.ZERO) < 0)
            return balance;
        return balance.add(amountToAdd);
    }
}