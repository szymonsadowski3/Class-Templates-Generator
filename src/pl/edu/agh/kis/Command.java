package pl.edu.agh.kis;

/**
 * This class represents single command, which maps certain key to certain value.
 * @author szymon
 *
 */
public class Command {
	private String key;
	private String value;
	
	/**
	 * Parametrized constructor
	 * @param key
	 * key to be set
	 * @param value
	 * value to be set
	 */
	public Command(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	/**
	 * This constructors takes String in syntax: "KEY=VALUE" and parses it to construct the object state
	 * @param toParse
	 * String in syntax: "KEY=VALUE"
	 */
	public Command(String toParse) {
		String[] entry = toParse.split("\\=");
		key = entry[0];
		value = entry[1];
	}
	
	/**
	 * @return
	 * value of /key/ field
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return
	 * value of /value/ field
	 */
	public String getValue() {
		return value;
	}

}
