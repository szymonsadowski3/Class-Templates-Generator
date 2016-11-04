package pl.edu.agh.kis;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used to generates fields of the class
 * @author szymon
 *
 */
public class FieldGenerator {
	/**
	 * This method checks if given command could possibly represent class field
	 * @param command
	 * Given command
	 * @return
	 * <var>true</true> if command can represent class field, <var>false</var> otherwise
	 * @see command
	 */
	static boolean checkIfCommandRefersToField(Command command) {
		String key = command.getKey();
		return ((key.equals("byte")) || (key.equals("short")) || (key.equals("int")) || (key.equals("long"))
				|| (key.equals("float")) || (key.equals("double")) || (key.equals("char")) || (key.equals("String"))
				|| (key.equals("boolean")));
	}
	
	/**
	 * This method takes Command reference, and generate from it:
	 * <ol>
	 * <li>Class field</li>
	 * <li>Field Setter</li>
	 * <li>Field Getter</li>
	 * </ol>
	 * @param command
	 * reference to Command, from which code will be generated
	 * @return
	 * ArrayList of Strings that will contain lines of generated code
	 */
	static ArrayList<String> generateCode(Command command) {
		ArrayList<String> toReturn = new ArrayList<String>();
		if (checkIfCommandRefersToField(command)) {
			toReturn.add(System.lineSeparator());//SEPARATOR
			toReturn.add(generateField(command.getKey(), command.getValue()));
			toReturn.addAll(generateSetter(command.getKey(), command.getValue()));
			toReturn.addAll(generateGetter(command.getKey(), command.getValue()));
		}
		return toReturn;
	}
	
	/**
	 * This method generate code which represents class field
	 * @param type
	 * Any primitive type or String type
	 * @param name
	 * name of field-to-be-created
	 * @return
	 * String with generated code which represents class field
	 */
	static String generateField(String type, String name) {
		return ("    " + type + " " + name + ";");
	}
	
	/**
	 * This method generates setter for class field
	 * @param type
	 * Any primitive type or String type
	 * @param name
	 * Name of field for which setter will be created
	 * @return
	 * ArrayList of Strings that will contain lines of setter code
	 */
	static ArrayList<String> generateSetter(String type, String name) {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add(System.lineSeparator());//SEPARATOR
		lines.add("    public void set" + Character.toUpperCase(name.charAt(0)) + name.substring(1) + "(" + type + " " + name + ") {");
		lines.add("        this." + name + " = " + name + ";");
		lines.add("    }");
		return lines;
	}
	
	/**
	 * This method generates getter for class field
	 * @param type
	 * Any primitive type or String type
	 * @param name
	 * Name of field for which getter will be created
	 * @return
	 * ArrayList of Strings that will contain lines of getter code
	 */
	static ArrayList<String> generateGetter(String type, String name) {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add(System.lineSeparator());//SEPARATOR
		lines.add("    public " + type + " get" + Character.toUpperCase(name.charAt(0)) + name.substring(1) + "() {");
		lines.add("        return " + name + ";");
		lines.add("    }");
		return lines;
	}
}
