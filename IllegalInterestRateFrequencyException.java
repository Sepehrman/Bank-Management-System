/**
 * Exception used when an invalid interest frequency is trying to be used.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class IllegalInterestRateFrequencyException extends Exception {
    /**
     * Constructor.
     * @param msg Error Message.
     */
    public IllegalInterestRateFrequencyException(final String msg) {
        super(msg);
    }
}
