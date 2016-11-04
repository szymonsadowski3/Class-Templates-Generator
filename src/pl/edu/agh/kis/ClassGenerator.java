package pl.edu.agh.kis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassGenerator class, which performs generating source code of class blank
 * template
 * 
 * @author szymon
 *
 */
public class ClassGenerator {

	/**
	 * ClassStructure field, which represents structure of class template, which
	 * is going to be generated
	 */
	private ClassStructure structure;

	/**
	 * Default class constructor
	 */
	ClassGenerator() {
		structure = new ClassStructure();
	}

	/**
	 * This method restores default structure of class template
	 */
	void cleanClassStructure() {
		structure = new ClassStructure();
	}

	/**
	 * This method generates template for class with given name and in given
	 * package
	 * 
	 * @param name
	 *            Name of class, for which template will be generated
	 * @param pack
	 *            Name of package, which will contain generated class template
	 * @return
	 */
	ArrayList<String> generateClass(String name, String pack) {
		ArrayList<String> generatedLines = new ArrayList<String>();

		generatedLines.add(TextGenerator.getPackage(pack));

		if (structure.hasClassJavadoc())
			generatedLines.addAll(TextGenerator.getClassJavadoc(name));

		generatedLines.add(TextGenerator.getClassPrototype(name) + " {");

		if (structure.hasConstructorJavadoc())
			generatedLines.addAll(TextGenerator.getDefaultConstructorJavadoc(name));

		generatedLines.addAll(TextGenerator.getDefaultConstructorBody(name));

		if (structure.hasMainJavadoc() && structure.hasMain())
			generatedLines.addAll(TextGenerator.getMainJavadoc(name));

		if (structure.hasMain())
			generatedLines.addAll(TextGenerator.getMainBody(name));

		generatedLines.add("}");

		return generatedLines;
	}

	/**
	 * This method generates template for class with given name and in given
	 * package and saves the generated code to created project, whose directory
	 * path is set by argument /projectRoot/
	 * 
	 * @param packageAndClassName
	 *            String in format PACKAGE_NAME.CLASS_NAME, for example ->
	 *            pl.edu.agh.kis.Mario
	 * @param projectRoot
	 *            Path to directory, where project will be created
	 * @throws IOException
	 */
	void generateClassToFile(String packageAndClassName, String projectRoot) throws IOException {
		if (packageAndClassName.equals(""))
			throw new IOException("Empty command string!");

		String[] splitted = TextUtilities.splitByDots(packageAndClassName);
		String[] directoryStructure = Arrays.copyOf(splitted, splitted.length - 1);

		String packageDirectoryPath = DirectoryCreator.createDirs(projectRoot, directoryStructure);
		String packageName = TextUtilities.extractPackageNameFromInput(packageAndClassName);
		String className = TextUtilities.extractClassNameFromInput(packageAndClassName);

		ArrayList<String> generatedSource = generateClass(className, packageName);

		String resultFilePath = packageDirectoryPath + "/" + className + ".java";

		FileWriter.writeLines(resultFilePath, generatedSource.toArray(new String[0]));
	}

	/**
	 * This method generates template for class with given name and in given
	 * package and saves the generated code to created project, whose directory
	 * path is set by argument /projectRoot/ . This method differs from method
	 * generateClassToFile(String packageAndClassName, String projectRoot)
	 * because it can also generate field and Getters & Setters for them. It can
	 * also control the generated template (for example it can switch off
	 * javadoc generation or main method generation
	 * 
	 * @param input
	 *            First String is in format PACKAGE_NAME.CLASS_NAME Further
	 *            Strings are in format COMMAND=VALUE
	 * 
	 *            Field commands (they will generate fields for classes and
	 *            Getters & Setters for them):
	 * 
	 *            byte=FIELD_NAME short=FIELD_NAME int=FIELD_NAME
	 *            long=FIELD_NAME float=FIELD_NAME double=FIELD_NAME
	 *            char=FIELD_NAME String=FIELD_NAME boolean=FIELD_NAME
	 * 
	 *            Controlling commands (they will switch off some code segments
	 *            is generated class):
	 * 
	 *            class_javadoc=false 
	 *            constructor_javadoc=false
	 *            main_javadoc=false 
	 *            main=false
	 * 
	 * @param projectRoot
	 * @throws IOException
	 */
	void generateClassToFile(String[] input, String projectRoot) throws IOException {
		String packageAndClassName = input[0];

		if (packageAndClassName.equals(""))
			throw new IOException("Empty command string!");

		String[] splitted = TextUtilities.splitByDots(packageAndClassName);
		String[] directoryStructure = Arrays.copyOf(splitted, splitted.length - 1);

		String packageDirectoryPath = DirectoryCreator.createDirs(projectRoot, directoryStructure);

		String packageName = TextUtilities.extractPackageNameFromInput(packageAndClassName); // With
																								// dot
		packageName = TextUtilities.removeLastCharacter(packageName);

		String className = TextUtilities.extractClassNameFromInput(packageAndClassName);

		String[] entries = Arrays.copyOfRange(input, 1, input.length); // Array with 1st element removed											

		for (String s : entries) {
			Command command = new Command(s);
			structure.addToCommandList(command);
		}

		structure.processCommands();

		ArrayList<String> generatedSource = generateClass(className, packageName);

		/*for (Command c : structure.getFields()) {
			ArrayList<String> performed = new ArrayList<String>();
			performed = FieldGenerator.generateCode(c);
			generatedSource.addAll(generatedSource.size() - 1, performed);
		}*/
		
		generatedSource.addAll( generatedSource.size() - 1, structure.generateCodeConnectedWithFields() );

		String resultFilePath = packageDirectoryPath + "/" + className + ".java";

		FileWriter.writeLines(resultFilePath, generatedSource.toArray(new String[0]));

		cleanClassStructure();
	}
}

/**
 * Auxiliary class, which represents structure of generated class
 * 
 * @author szymon
 *
 */
class ClassStructure {
	private boolean hasClassJavadoc = true;
	private boolean hasMainJavadoc = true;
	private boolean hasConstructorJavadoc = true;
	private boolean hasMain = true;

	/**
	 * This ArrayList stores commands given by the user in input file. Possible commands are: 
	 *            byte=FIELD_NAME short=FIELD_NAME int=FIELD_NAME
	 *            long=FIELD_NAME float=FIELD_NAME double=FIELD_NAME
	 *            char=FIELD_NAME String=FIELD_NAME boolean=FIELD_NAME
	 * 
	 *            class_javadoc=false 
	 *            constructor_javadoc=false
	 *            main_javadoc=false 
	 *            main=false
	 */
	private ArrayList<Command> commandList = new ArrayList<Command>();

	/**
	 * This ArrayList stores the representations of fields, that will be generated.
	 * Representation syntax: TYPE=FIELD_NAME, for example int=counter
	 */
	private ArrayList<Command> fields = new ArrayList<Command>();

	/**
	 * @param command
	 *            Command, which will be appended to /commandList/
	 */
	void addToCommandList(Command command) {
		commandList.add(command);
	}

	/**
	 * This method transforms class structure according to specified commands
	 */
	void processCommands() {
		for (Command c : commandList) {
			if ((c.getKey().equals("main_javadoc")) && (c.getValue().equals("false"))) {
				hasMainJavadoc = false;
				continue;
			}
			if ((c.getKey().equals("main")) && (c.getValue().equals("false"))) {
				hasMain = false;
				continue;
			}
			if (c.getKey().equals("class_javadoc") && c.getValue().equals("false")) {
				hasClassJavadoc = false;
				continue;
			}
			if (c.getKey().equals("constructor_javadoc") && c.getValue().equals("false")) {
				hasConstructorJavadoc = false;
				continue;
			}
			if (FieldGenerator.checkIfCommandRefersToField(c)) {
				fields.add(c);
			}
		}
	}
	
	ArrayList<String> generateCodeConnectedWithFields() {
		ArrayList<String> performed = new ArrayList<String>();
		
		for (Command c : getFields()) {
			performed.addAll( FieldGenerator.generateCode(c) );
		}
		
		return performed;
	}

	/**
	 * @return value of hasClassJavadoc field
	 */
	public boolean hasClassJavadoc() {
		return hasClassJavadoc;
	}

	/**
	 * @return value of hasMainJavadoc field
	 */
	public boolean hasMainJavadoc() {
		return hasMainJavadoc;
	}

	/**
	 * @return value of hasConstructorJavadoc field
	 */
	public boolean hasConstructorJavadoc() {
		return hasConstructorJavadoc;
	}

	/**
	 * @return value of hasMain field
	 */
	public boolean hasMain() {
		return hasMain;
	}

	/**
	 * @return reference to /fields/ ArrayList
	 */
	public ArrayList<Command> getFields() {
		return fields;
	}
}
