package activity5;

/**
 * An exception class to catch a negative number input by the user.
 * @author Ryan Varnell
 */
public class NegativeNumberException extends Exception {
    /**
     * Default constructor
     */
    public NegativeNumberException() {
        super();
    }

    /**
     * Constructor with message.
     * @param message Error message.
     */
    public NegativeNumberException(String message) {
        super(message);
    }
}
