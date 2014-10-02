import java.io.*;
import java.util.*;
public class WellCounter {

	public static void main(String[] args) {
		
		//variable declarations
		int count = 0;
		int sum = 0;
		Scanner console = new Scanner(System.in); //creates scanner for user input
		int maxCount = 0;
		int remaining = maxCount;
		int replicate = 0;
		ArrayList<Integer>replicates = new ArrayList<Integer>(); //stores replicate number(s)
		ArrayList<Integer> counts = new ArrayList<Integer>(); //stores counts that correspond to each replicate
		double mean = 0;
		double standardDeviation = 0;
		String choice = "";
		String keepCounting = "y";
		
		System.out.print("Do you want to set a target number to count? (y/n)");
		choice = console.next();
		if (choice.equals("y")){
			System.out.print("Total to count?");
			maxCount = console.nextInt();
			console.nextLine(); //Needed to clear new line character from previous console input.
			System.out.println();
		}
		while (keepCounting.equals("y")){
			count(choice, remaining, replicate, replicates, count, console, counts, sum, mean, standardDeviation, maxCount, keepCounting);
			summary(choice, count, remaining, mean, standardDeviation, maxCount, keepCounting, console);
		}
	}
	
	/*
	 * Gathers count information and prints out the remaining left to count from the set maximum 
	 * after each replicate is counted
	 * Accepts a long list of parameters to store/print the counts, mean, and standard deviation.
	 */
	public static void count(String choice, int remaining, int replicate, ArrayList<Integer> replicates, int count, Scanner console, 
			ArrayList<Integer>counts, int sum, double mean, double standardDeviation, int maxCount, String keepCounting){
			replicate++;
			replicates.add(replicate); //adds each new replicate number to replicates ArrayList
			System.out.printf("Replicate #%d%n", replicate);
			count = countingPrompt(console, count);
			counts.add(count); //adds each new count value to the counts ArrayList
			sum += count;
			mean = mean(counts);
			standardDeviation = standardDeviation(mean, counts);
			remaining = maxCount - sum;
			summary(choice, count, remaining, mean, standardDeviation, maxCount, keepCounting, console);
	}
	
	
	/*
	 * A summary of each round of counting. that prints to the console.
	 * Accepts the integer values: count, remaining, and maxCount.
	 * Accept the double values: mean, and standarDeviation.
	 */
	public static String summary(String choice, int count, int remaining, double mean, 
			double standardDeviation, int maxCount, String keepCounting, Scanner console){
		System.out.println();
		System.out.printf("You counted %d.%n", count);
		if (choice.equals("y")){
			System.out.printf("You have %d remaining.%n", remaining);
		}
		if (remaining < 0){
			System.out.println("You counted " + Math.abs(remaining) + " over your " + maxCount);
		}
		System.out.printf("The current mean of your replicates is " 
				+ "%.2f%n", mean); //prints mean to first two decimal places
		System.out.printf("The current standard deviation of your replicates is " 
				+ "%.2f%n", standardDeviation); //prints standard deviation to first two decimal places
		System.out.println();
		System.out.println();
		System.out.print("Keep counting? (y/n)");
		keepCounting = console.next();
		return keepCounting;
	}
	
	
	/*
	 * Counts the number of characters entered.  Does not distinguish between character type.
	 * Accepts a Scanner for user input and the integer count.
	 * Returns count.
	 */
	public static int countingPrompt(Scanner console, int count){
		System.out.println("Use Space Bar to tally larvae.");
		System.out.print("Press Enter when finished.");
		String input = console.nextLine();
		count = input.length();
		return count;
	}
	
	/*
	 * Calculates the mean.
	 * Accepts the ArrayList counts.
	 * Returns mean.
	 */
	public static double mean (ArrayList<Integer> counts){
		double mean = 0;
		double sum = 0;
		
		//for loop over each element in the counts ArrayList and adds them together as sum
		for (int i = 0; i < counts.size(); i++){
			sum += counts.get(i);
		}
		mean = sum/counts.size();
		return mean;
	}
	
	
	/*
	 * Calculates standard deviation.
	 * Accepts a double, mean, and ArrayList counts.
	 * Returns standardDeviation.
	 * Possibly should make this just calculate variance...
	 */
	public static double standardDeviation(double mean, ArrayList<Integer> counts){
		double variance = 0;
		double standardDeviation = 0;
		int sum = 0;
		
		//for loop determines the difference from the mean for each element in the counts ArrayList,
		//squares that value (within the Math.pow method), and then adds it to the previous value.
		for (int i = 0; i < counts.size(); i++){
			sum += Math.pow(counts.get(i) - mean, 2);
		}
		variance = sum/counts.size();//it's possible that this should actually be counts.size()-1 if counting a subset of population
		standardDeviation = Math.sqrt(variance);
		return standardDeviation;
	}

}
