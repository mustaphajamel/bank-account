package exception;

public class NegativeDepositAmountException extends Exception{
    public NegativeDepositAmountException() {
        super("Could not add negative amount to balance");
    }
}
