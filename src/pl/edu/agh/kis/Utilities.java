package pl.edu.agh.kis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Class which performs some utility operations on Strings
 * @author szymon
 *
 */
public class Utilities {
	
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
	
	static void printArrayList(ArrayList<String> input) {
		for(String s : input) {
			System.out.println(s);
		}
	}
	
	public static <K,V> HashMap<V,K> reverse(Map<K,V> map) {
	    HashMap<V,K> rev = new HashMap<V, K>();
	    for(Map.Entry<K,V> entry : map.entrySet())
	        rev.put(entry.getValue(), entry.getKey());
	    return rev;
	}
	
	static ArrayList<Command> removeDuplicateValuesFromListOfCommands(ArrayList<Command> list) {
		ArrayList<Command> clean = new ArrayList<Command>();
		
		HashMap<String, String> toReturn = new HashMap<String, String>();
		
		for(Command c : list) {
			toReturn.put(c.getValue(), c.getKey());
		}
		
		for (Map.Entry<String, String> entry : toReturn.entrySet()) {
			clean.add(new Command(entry.getValue(), entry.getKey()));
		}
		
		return clean;
	}
}
