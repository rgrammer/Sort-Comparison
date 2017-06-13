package SortComparison;

import java.io.*;
import java.util.*;

public class UserInput {

	/**
	* Asks the user to enter the name of text file containing the list of numbers to be sorted 
	* 
	* @throws FileNotFoundException
	*/
	
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void setElements() throws FileNotFoundException
	{
		// User is asked how many ints are in the file
		int numInts = 0;
		System.out.println("Enter the number of integers in the input file (ex. 5000, 10000, 20000, 50000)");
		Scanner input = new Scanner(System.in);	
		numInts = input.nextInt();
		input.nextLine();
		//If the number of ints is less than 2 the user is promtped that this is not enough ints
		if(numInts < 2)
		{
			System.out.println("You need to have at least two integers in your file to be sorted!");
		}
		//User is asked to enter the name of a file containing their list to be sorted
		else
		{
			String fileName = "";
			System.out.println("Type the name of the text file containing the list of numbers you would like sorted:");	
			fileName = input.nextLine();
			if(fileName != "")
			{	
				//User file is read in if it is a valid file name 
				T[] inputArray;
				Integer nextVal;
				Scanner scanIn = null;
				scanIn = new Scanner(new BufferedReader(new FileReader(fileName))); 
				T[] tempArray = (T[]) new Comparable[numInts];
				inputArray = tempArray;
				int i = 0;
				int intCount = 0;
				//Continue to read ints if there are more ints in the file
				while(scanIn.hasNextInt()){
					nextVal = scanIn.nextInt();
					inputArray[i++] = (T) nextVal;
					intCount++;
				}
				scanIn.close();
		
				//Do sorts if the number of integers indicated by the user is equal to the number in the file. Time sort algorithms
				if(intCount == numInts)
				{
					long bubblestartTime = System.currentTimeMillis();
					BubbleSort.bubblesort(inputArray);
					long bubblestopTime = System.currentTimeMillis();
					long heapstartTime = System.currentTimeMillis();
					HeapSort.heapsort(inputArray);
					long heapstopTime = System.currentTimeMillis();
					//Print out elapsed time during sorts
					System.out.println("Bubble Sort took " + (bubblestopTime - bubblestartTime) + " miliseconds.");
					System.out.println("Heap Sort took " + (heapstopTime - heapstartTime) + " miliseconds.");
				}
				//Print promt if the file did not contain the indicated number of ints
				else
				{
					System.out.println("Your file does not contain the correct number of integers. Try again.");
				}
			}
			//Print prompt if the user did not enter a file name
			else
			{
				System.out.println("You did not enter a file name. Try again. ");
			}
		}
		input.close();
	}		
}
