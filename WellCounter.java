import java.io.*;
import java.util.*;
public class WellCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int sum = 0;
		Scanner console = new Scanner(System.in);
		int maxCount = initialPrompt(console);
		int remaining = maxCount;
		int replicate = 0;
		
		while (remaining >= 0){
			replicate++;
			System.out.println("Replicate #" + replicate);
			count = countingPrompt(console, count);
			sum += count;
			remaining = maxCount - sum;
			System.out.println();
			System.out.println("You counted " + count + " larvae.");
			System.out.println("You have " + remaining + " remaining.");
		
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
	
	

}
