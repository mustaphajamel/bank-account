package domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Account {
    private BigDecimal balance;

    public BigDecimal deposit(BigDecimal amountToAdd) {
        return null;
    }
}