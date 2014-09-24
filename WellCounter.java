import java.io.*;
import java.util.*;
public class WellCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		Scanner console = new Scanner(System.in);
		int maxCount;
		
		System.out.print("Total larvae to count?");
		maxCount = console.nextInt();
		console.nextLine(); //Needed to clear new line character from previous console input.
		System.out.println();
		
		System.out.println("Use Space Bar to tally larvae.");
		System.out.print("Press Enter when finished.");
		
		String input = console.nextLine();
		count = input.length();
		
		System.out.println();
		System.out.println("You counted " + count + " larvae.");
		System.out.println("You have " + (maxCount - count) + " remaining.");
		
	}

}
