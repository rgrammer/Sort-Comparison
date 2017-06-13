package SortComparison;

import java.io.*;

public class runSortComparison {
	/**
	* This program allows the user to enter the name of a file which contains 
	* a series of integers and displays the amount of time in milliseconds that
	* it takes for a heapsort and a bubblesort to sort the integers in the file
	* 
	* @param  args
	* @throws FileNotFoundException 
	*/
	
	public static void main(String args[]) throws FileNotFoundException 
	{
			//Try to run the program
			try
			{
				UserInput runProgram = new UserInput();
				runProgram.setElements();
			}
			
			//Catch all if invalid entry is made
			catch(Exception e)
			{
				System.out.println("Invalid entry");
			}
	}
}
