/**
 * Exception thrown when balance.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class BalanceExceedsOverDraftProtectionException extends Exception {
    /**
     * Constructor.
     * @param msg Error Message.
     */
    public BalanceExceedsOverDraftProtectionException(final String msg) {
        super(msg);
    }
}
