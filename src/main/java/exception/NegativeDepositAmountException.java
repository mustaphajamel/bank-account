package exception;

public class NegativeDepositAmountException extends Exception{
    public NegativeDepositAmountException(String message) {
        super(message);
    }
}
