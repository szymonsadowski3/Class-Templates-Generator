package pl.edu.agh.kis;

import java.io.IOException;

/**
 * Main class, which runs whole application
 * 
 * @author szymon sadowski
 *
 */
public class Main {

	/**
	 * @param args
	 *            Arguments from command line... 1st argument should be as
	 *            follows: [path to file, which contains commands] ; 2nd :
	 *            [desired name of output directory for generated code-files]
	 * @throws IOException
	 * @throws TooFewArguments
	 */
	public static void main(String[] args) throws IOException, TooFewArguments {
		ArgsChecker.checkIfLessArgsThanTwo(args);

		String pathToFileWithCommands = args[0];
		String desiredPathToDirectoryForProject = args[1];

		String[] lines = FileReader.readLines(pathToFileWithCommands);

		ClassGenerator classGenerator = new ClassGenerator();

		for (String line : lines) {
			String[] entries = line.split("\\s+");
			classGenerator.generateClassToFile(entries, desiredPathToDirectoryForProject);
		}
	}
}