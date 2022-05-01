package exception;

public class DifferentCurrencyOperationException extends Exception{
    public DifferentCurrencyOperationException() {
        super("Operation currency should be the same of the account");
    }

}
