package assg4_varnellr18;

/**
 * Exception class for when an account cannot be found or doesn't exist.
 * @author Ryan Varnell
 */
public class AccountNotFoundException extends Exception {
    /**
     * Default constructor
     */
    public AccountNotFoundException() {
        super();
    }

    /**
     * Constructor containing a message
     * @param message Message to be printed
     */
    public AccountNotFoundException(String message) {
        super(message);
    }
}
