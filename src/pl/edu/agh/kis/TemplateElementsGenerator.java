package pl.edu.agh.kis;

import java.util.ArrayList;


/**
 * This class is used to generate some code snippets that could be used to construct whole class template
 * @author szymon sadowski
 *
 */
public class TemplateElementsGenerator {
	static String getPackage(String pack) {
		return ("package " + pack + ";");
	}
	
	/**
	 * This method generates Javadoc code for class
	 * @param name
	 * Name of the class which will be generated
	 * @return
	 * ArrayList of Strings that contains lines of generated Javadoc code
	 */
	static ArrayList<String> getClassJavadoc(String name) {
		ArrayList<String> generatedLines = new ArrayList<String>();

		generatedLines.add("/**");
		generatedLines.add(" * To jest wygenerowana automatycznie klasa " + name);
		generatedLines.add(" *");
		generatedLines.add(" */");

		return generatedLines;
	}
	
	/**
	 * This method generates "class prototype" code
	 * @param name
	 * Name of class for which "class prototype" will be generated
	 * @return
	 * Single line of code which holds "class prototype"
	 */
	static String getClassPrototype(String name) {
		return ("public class " + name); // + " {"
	}

	/**
	 * This method generates javadoc for default constructor
	 * @param name
	 * name of class for which "javadoc for default constructor" will be generated
	 * @return
	 * ArrayList of Strings that contains lines of generated "javadoc for default constructor" code
	 */
	static ArrayList<String> getDefaultConstructorJavadoc(String name) {
		ArrayList<String> generatedLines = new ArrayList<String>();

		generatedLines.add("    /**");
		generatedLines.add("     * Domyslny konstruktor klasy " + name);
		generatedLines.add("     */");

		return generatedLines;
	}

	/**
	 * This method generates code of "default constructor body"
	 * @param name
	 * name of class for which "default constructor body" will be generated
	 * @return
	 * ArrayList of Strings that contains lines of generated "default constructor body" code
	 */
	static ArrayList<String> getDefaultConstructorBody(String name) {
		ArrayList<String> generatedLines = new ArrayList<String>();

		generatedLines.add("    public " + name + "() {");
		generatedLines.add("        // metoda wygenerowana - nalezy uzupelnic implementacje");
		generatedLines.add("    }");

		return generatedLines;
	}
	
	/**
	 * This method generates code of "javadoc for main method"
	 * @param name
	 * name of class for which "javadoc for main method" will be generated
	 * @return
	 * ArrayList of Strings that contains lines of generated "javadoc for main method" code
	 */
	static ArrayList<String> getMainJavadoc(String name) {
		ArrayList<String> generatedLines = new ArrayList<String>();

		generatedLines.add("    /**");
		generatedLines.add("     * Metoda main automatycznie wygenerowana ");
		generatedLines.add("     * @param args tablica argumentow przekazanych do programu");
		generatedLines.add("     */");

		return generatedLines;
	}
	
	/**
	 * This method generates code of "main method body"
	 * @param name
	 * name of class for which "main method body" will be generated
	 * @return
	 * ArrayList of Strings that contains lines of generated "main method body" code
	 */
	static ArrayList<String> getMainBody(String name) {
		ArrayList<String> generatedLines = new ArrayList<String>();

		generatedLines.add("    public static void main(String[] args) {");
		generatedLines.add(
				"        System.out.println(\"Metoda jeszcze nie jest zaimplementowana - tylko wygenerowany wzorzec.\");");
		generatedLines.add("    }");

		return generatedLines;
	}
}
