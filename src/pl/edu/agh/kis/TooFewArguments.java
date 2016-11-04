package pl.edu.agh.kis;

/**
 * The Class-Exception TooFewArgument. Exception is thrown, when there is too
 * few arguments to run particular method
 * 
 * @author szymon sadowski
 */
public class TooFewArguments extends Exception {
	/**
	 * Default constructor
	 */
	public TooFewArguments() {
		super();
	}

	/**
	 * Parametrized constructor
	 * @param message
	 * Exception message
	 */
	public TooFewArguments(String message) {
		super(message);
	}

	/**
	 * Parametrized constructor
	 * @param message
	 * Exception message
	 * @param cause
	 * Throwable that caused this throwable to be constructed
	 */
	public TooFewArguments(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Parametrized constructor
	 * @param cause
	 * Throwable that caused this throwable to be constructed
	 */
	public TooFewArguments(Throwable cause) {
		super(cause);
	}
}
