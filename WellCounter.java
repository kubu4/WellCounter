import java.io.*;
import java.util.*;
public class WellCounter {

	public static void main(String[] args) {

		int count = 0;
		int sum = 0;
		Scanner console = new Scanner(System.in);
		int maxCount = initialPrompt(console);
		int remaining = maxCount;
		int replicate = 0;
		ArrayList<Integer>replicates = new ArrayList<Integer>(); //stores replicate number(s)
		ArrayList<Integer> counts = new ArrayList<Integer>(); //stores counts that correspond to each replicate
		
		while (remaining >= 0){
			replicate++;
			add.replicates(replicate); //adds new replicate number to replicates ArrayList
			System.out.println("Replicate #" + replicate);
			count = countingPrompt(console, count);
			add.counts(count); //adds new count value to the counts ArrayList
			sum += count;
			remaining = maxCount - sum;
			System.out.println();
			System.out.println("You counted " + count + " larvae.");
			System.out.println("You have " + remaining + " remaining.");
			if (remaining < 0){
				System.out.println("You counted " + Math.abs(remaining) + " over your " + maxCount);
			}
		
		}
	}
		
	public static int initialPrompt(Scanner console) {
		int maxCount = 0;
		System.out.print("Total larvae to count?");
		maxCount = console.nextInt();
		console.nextLine(); //Needed to clear new line character from previous console input.
		System.out.println();
		return maxCount;
	}
	
	
	public static int countingPrompt(Scanner console, int count){
		System.out.println("Use Space Bar to tally larvae.");
		System.out.print("Press Enter when finished.");
		String input = console.nextLine();
		count = input.length();
		return count;
	}
	
	public double mean (ArrayList<Integer> counts){
		double mean = 0;
		int sum = 0;
		
		//for loop over each element in the counts ArrayList and adds them together as sum
		for (int i = 0; i < counts.size(); i++){
			sum += counts.get(i);
		}
		mean = sum/counts.size();
		return mean;
	}
	
	public double standardDeviation(double mean, ArrayList<Integer> counts){
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
