import java.io.*;
import java.util.*;
public class WellCounter {
//smartgit check smargit check
	public static void main(String[] args) {
		
		//variable declarations
		Scanner console = new Scanner(System.in); //creates scanner for user input
		int count;
		int sum = 0;
		int maxCount = 0;
		int remaining = 0;
		int replicate = 0;
		ArrayList<Integer> replicates = new ArrayList<Integer>(); //stores replicate number(s)
		ArrayList<Integer> counts = new ArrayList<Integer>(); //stores counts that correspond to each replicate
		String targetChoice = "";
		String keepCounting = "y";
		
		System.out.print("Do you want to set a target number to count? (y/n)");
		targetChoice = console.next();
		console.nextLine();
		System.out.println();
		if (targetChoice.equals("y")){
			System.out.print("Total to count?");
			maxCount = console.nextInt();
			console.nextLine(); //Needed to clear new line character from previous console input.
			System.out.println();
		}
		
		while (keepCounting.equals("y")){
			count = countingPrompt(console);
			counts.add(count); //adds each new count value to the counts ArrayList
			replicate++;
			replicates.add(replicate); //adds each new replicate number to replicates ArrayList
			System.out.printf("Replicate #%d%n", replicate);
			sum += count;
			double mean = mean(counts);
			double variance = variance(mean, counts);
			double standardDeviation = standardDeviation(variance);
			summary(targetChoice, count, sum, remaining, mean, standardDeviation, maxCount, keepCounting, console);
			System.out.print("Keep counting? (y/n)");
			keepCounting = console.next();
			console.nextLine();
			System.out.println();
			if (keepCounting.equals("y")){
				remaining = maxCount - sum;
			}
		}
		
	}
			
	
	
	/*
	 * A summary of each round of counting. that prints to the console.
	 * Accepts the integer values: count, sum, remaining, and maxCount.
	 * Accept the double values: mean, and standarDeviation.
	 */
	public static void summary(String targetChoice, int count, int sum, int remaining, double mean, 
			double standardDeviation, int maxCount, String keepCounting, Scanner console){
		System.out.println();
		System.out.printf("You counted %d.%n", count);
		System.out.printf("Total counted is %d.%n", sum);
		if (targetChoice.equals("y")){
			System.out.printf("You have %d remaining.%n", remaining);
		}
		if (targetChoice.equals("y") && remaining < 0){
			System.out.println("You counted " + Math.abs(remaining) + " over your " + maxCount);
		}
		System.out.printf("The mean of your replicates is " 
				+ "%.2f%n", mean); //prints mean to first two decimal places
		System.out.printf("The standard deviation of your replicates is " 
				+ "%.2f%n", standardDeviation); //prints standard deviation to first two decimal places
		System.out.println();
		System.out.println();
	}
	
	
	/*
	 * Counts the number of characters entered.  Does not distinguish between character type.
	 * Accepts a Scanner for user input and the integer count.
	 * Returns count.
	 */
	public static int countingPrompt(Scanner console){
		System.out.println("Use Space Bar to tally larvae.");
		System.out.print("Press Enter when finished.");
		String input = console.nextLine();
		int count = input.length();
		System.out.println();
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
	 * Calculates variance.
	 * Accepts a mean and the ArrayList counts.
	 */
	public static double variance(double mean, ArrayList<Integer> counts){
		double variance = 0;
		int sum = 0;
		
		//for loop determines the difference from the mean for each element in the counts ArrayList,
		//squares that value (within the Math.pow method), and then adds it to the previous value.
		for (int i = 0; i < counts.size(); i++){
			sum += Math.pow(counts.get(i) - mean, 2);
		}
		variance = sum/counts.size();//it's possible that this should actually be counts.size()-1 if counting a subset of population
		return variance;
	}
	
	
	/*
	 * Calculates the standard deviation.
	 * Accepts variance.
	 */
	public static double standardDeviation (double variance){
		double standardDeviation = 0;
		standardDeviation = Math.sqrt(variance);
		return standardDeviation;
	}

}
