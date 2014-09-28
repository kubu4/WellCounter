import java.io.*;
import java.util.*;
public class WellCounter {

	public static void main(String[] args) {
		
		//variable declarations
		int count = 0;
		int sum = 0;
		Scanner console = new Scanner(System.in); //creates scanner for user input
		int maxCount = initialPrompt(console);
		int remaining = maxCount;
		int replicate = 0;
		ArrayList<Integer>replicates = new ArrayList<Integer>(); //stores replicate number(s)
		ArrayList<Integer> counts = new ArrayList<Integer>(); //stores counts that correspond to each replicate
		double mean;
		double standardDeviation;
		
		while (remaining > 0){
			replicate++;
			replicates.add(replicate); //adds each new replicate number to replicates ArrayList
			System.out.printf("Replicate #%i%n", replicate);
			count = countingPrompt(console, count);
			counts.add(count); //adds each new count value to the counts ArrayList
			sum += count;
			mean = mean(counts);
			standardDeviation = standardDeviation(mean, counts);
			remaining = maxCount - sum;
			summary(count, remaining, mean, standardDeviation, maxCount);
			
			}
		
		}
	
	/*
	 * A summary of each round of counting. that prints to the console.
	 * Accepts the integer values: count, remaining, and maxCount.
	 * Accept the double values: mean, and standarDeviation.
	 */
	public static void summary(int count, int remaining, double mean, double standardDeviation, int maxCount){
		System.out.println();
		System.out.printf("You counted %i larvae.%n", count);
		System.out.printf("You have %i remaining.%n", remaining);
		System.out.printf("The current mean of your replicates is " + "%.2f%n", mean); //prints mean to first two decimal places
		System.out.printf("The current standard deviation of your replicates is " + "%.2f%n", standardDeviation); //prints standard deviation to first two decimal places
		System.out.println();
		if (remaining < 0){
			System.out.println("You counted " + Math.abs(remaining) + " over your " + maxCount);
		}
	}
	
	/*
	 * Initiates the program.
	 * Accepts a Scanner to allow user to set maximum number to count.
	 */
	public static int initialPrompt(Scanner console) {
		System.out.print("Do you want to set a target number to count? (y/n)")
		String answer = console.next();
		if (answer.equalsIgnoreCase(answer y)){
			int maxCount = 0;
			System.out.print("Total larvae to count?");
			maxCount = console.nextInt();
			console.nextLine(); //Needed to clear new line character from previous console input.
			System.out.println();
			return maxCount;
		}
		
		console.nextLine(); //Needed to clear new line character from previous console input.
		System.out.println();
		
	}
	
	/*
	 * Counts the number of characters entered.  Does not distinguish between character type.
	 * Accepts a Scanner for user intup and the integer count.
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
