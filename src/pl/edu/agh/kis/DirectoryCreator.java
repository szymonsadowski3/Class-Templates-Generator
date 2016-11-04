package pl.edu.agh.kis;

import java.io.File;

/**
 * This class creates directories in order to make a Java project
 * @author szymon
 *
 */
public class DirectoryCreator {
	/**
	 * This method create directory of desired path
	 * @param path
	 * relative path
	 */
	public static void createDir(String path) {
		File dir = new File(path);
		dir.mkdirs();;
	}
	
	/**
	 * This method creates structure of directories
	 * @param projectRoot
	 * Path of project directory
	 * @param path
	 * Array of folder names. Folders will be created on the next and next levels of nesting
	 * @return
	 * String which represents package of the Project (folder.folder.folder   ... )
	 */
	public static String createDirs(String projectRoot, String[] path) {
		StringBuilder packagePath = new StringBuilder(projectRoot + "/");
		
		for(String s : path)
			packagePath.append(s + "/");
		
		packagePath.setLength(packagePath.length() - 1); //Removing "/" at the end of StringBuilder
		
		createDir(packagePath.toString());
		
		return packagePath.toString();
	}
}
