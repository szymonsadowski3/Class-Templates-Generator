package pl.edu.agh.kis;

/**
 * The Class ArgsChecker, which checks if amount of command line arguments  is as desired
 * 
 * @author szymon sadowski
 */
public class ArgsChecker {
	/**
	 * Method checks if there is not enough program arguments (less or equal 1 in this case)
	 * 
	 * @param args
	 * Program arguments
	 * @throws TooFewArguments  if there is enough program arguments   
	 */
	static void checkIfLessArgsThanTwo(String[] args) throws TooFewArguments {
		if(args.length <= 1) {
			throw new TooFewArguments("Args array length is <= 1!");
		}
	}
	
	/**
	 * Method checks if there is not enough program arguments (less or equal 2 in this case)
	 * 
	 * @param args
	 * Program arguments
	 * @throws TooFewArguments  if there is enough program arguments   
	 */
	static void checkIfLessArgsThanThree(String[] args) throws TooFewArguments {
		if(args.length <= 2) {
			throw new TooFewArguments("Args array length is <= 2!");
		}
	}
}
