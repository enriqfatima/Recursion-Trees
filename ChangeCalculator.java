package edu.miracosta.cs113.change;

import java.io.File;
import java.util.ArrayList;
import java.util.IOException;
/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */

	public class ChangeCalculator {
	// coin values for ONE {quarter, dime, nickle, pennies}
	static int[] coinValues {25, 10, 5, 1} ;
	//implement ArrayList c
	static ArrayList<Integer> c;
	private static ArrayList<String> combos = new ArrayList<String>() ;

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    
        // TODO:
        /* Implement a recursive solution... which will dispense change for a given amount of money. 
    	 * The method will display and return the total number of combinations of 
    	 * quarters, dimes, nickels, and pennies that equal the desired amount and 
    	 * all of the combinations as well. Avoid duplication.
    	 */
    	//makeChange(cents, 0, 0, 0, cents); // return the value at the last position of the list (cents)
    	
    	public static int calculateChange(int cents) {

    		c = new ArrayList<Integer>();

    		//list
    		for (int i = 0; i < cents + 1; i++){
    			c.add(0);
    		}
    		c.set(0, 1); //set the first element to 1 making 0 cent 

    	for (int i = 0; i < coinValues.length; i++) { //nested loop to loop through the values of the arraylsit

    		for (int j = 0; j < cents + 1; j++) {
    			if (coinValues[i] <= j) //Once the coins value is bigger than the loop we can keep expanding our count recursively
    				c.set(j, c.get(j) + c.get(j - coinValues[i])); //update the list by setting the index equal to the current index added to the old value (c.get j - coinvalues[i])
    			}
    		}
    	makeChange(cents, 0, 0, 0, cents); // return the value at the last position of the list (cents)

    	for(String string : combos) { //Print combinations to console
    		System.out.println(string);
    	}
    	return c.get(cents);
    	}
    	
    }
    
	public static void  makeChange(int total, int nQuarter, int nDiMe, int nNickle, int nPenny){
		final int Quarter = coinValues[0], DIME = coinValues[1], NICKLE = coinValues[2], PENNY = coinValues[3];
		
		//String combo: 
		String comboOfString = "[" + nQuarter + ", " + nDimes + ", " + nNickle + ", " + nPenny + "]";
		if(!combos.contains(combination)) combos.add(combination); 
		// Cases:
				if (nPenny >= 5)
					makeChange(total, nQuarter, nDime, nNickel + 1, nPenny - 5);
				if (nPenny >= 10)
					makeChange(total, nQuarter, nDime + 1, nNickel, nPenny - 10);
				if (nPenny >= 25)
					makeChange(total, nQuarter + 1, nDime, nNickel, nPenny - 25);
	}
    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) 
    {
        // TODO:
        // This when calculateChange is complete. Note that 
    	// the text file must be created within this directory.
    	calculateChange(int cents) ;
    	
    	try {
    		File myFile = new File (new File("CoinCombinations.txt")); //new file
    		myFile.close(); // close the file
    	}
    	catch (FileNotFoundException ex) //print exception 
    	{
    		System.err.println("Error file not found exception for file: " + ex);
    	}
    	makechange(int cents);
    }

} // End of class ChangeCalculator