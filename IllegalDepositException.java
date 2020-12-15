/**
 * Exception used when an invalid deposit Type is trying to be used.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class IllegalDepositException extends Exception {
    /**
     * Constructor.
     * @param msg Error Message.
     */
    public IllegalDepositException(final String msg) {
        super(msg);
    }
}
