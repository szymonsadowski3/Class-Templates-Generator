package pl.edu.agh.kis;

import java.util.Arrays;

/**
 * Class which performs some utility operations on Strings
 * @author szymon
 *
 */
public class TextUtilities {
	
	/**
	 * This method extracts strings separated by dots -> in String /input/
	 * @param input
	 * String which will be splitted
	 * @return
	 * Array of extracted strings
	 */
	static String[] splitByDots(String input) {
		return input.split("\\.");
	}
	
	/**
	 * This method takes String in format PACKAGE_NAME.CLASS_NAME and returns PACKAGE_NAME from it
	 * @param input
	 * String in format PACKAGE_NAME.CLASS_NAME
	 * @return
	 * PACKAGE_NAME
	 */
	static String extractPackageNameFromInput(String input) {
		StringBuilder packageName = new StringBuilder("");
		
		String[] parts = splitByDots(input);
		String[] packageStructure = Arrays.copyOf(parts, parts.length-1);

		for(String s : packageStructure)
			packageName.append(s + ".");
		
		return packageName.toString();
	}
	
	/**
	 * This method takes String in format PACKAGE_NAME.CLASS_NAME and returns CLASS_NAME from it
	 * @param input
	 * String in format PACKAGE_NAME.CLASS_NAME
	 * @return
	 * CLASS_NAME
	 */
	static String extractClassNameFromInput(String input) {
		String[] parts = splitByDots(input);
		return parts[parts.length-1];
	}
	
	/**
	 * This method returns String with removed last character
	 * @param input
	 * String to be transformed
	 * @return
	 * Input String without last character of it
	 */
	static String removeLastCharacter(String input) {
		return input.substring(0, input.length()-1);
	}
}
