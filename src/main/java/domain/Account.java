package domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Account {
    private BigDecimal balance;

    public BigDecimal deposit(BigDecimal amountToAdd) {
        if (amountToAdd.compareTo(BigDecimal.ZERO) < 0)
            return balance;
        return balance.add(amountToAdd);
    }
}