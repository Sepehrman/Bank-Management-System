/**
 * Exception used when an invalid account Type is trying to be used.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class IllegalAccountTypeException extends Exception {
    /**
     * Constructor.
     * @param msg Error Message.
     */
    public IllegalAccountTypeException(final String msg) {
        super(msg);
    }
}
