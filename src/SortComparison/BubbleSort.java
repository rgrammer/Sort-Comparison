package SortComparison;

public class BubbleSort {

	/** 
	* Defines the bubble sort algorithm, an algorithm that compares adjacent items in an array and 
	* sorts the items if they are not in the correct order. The smallest value will bubble to the 
	* beginning of the array, this may take multiple passes. This algorithm has an O(n^2) complexity
	* 
	* pre: table contains Comparable items 
	* post: table is sorted
	* @param table The array to be sorted
	*/
	
	public static <T extends Comparable<T>> void bubblesort(T[] table) {
		int pass = 1; 
		boolean exchanges = false;
		
		do {
			// Invariant: Elements after table.length - pass + 1 
			// are in place. 
			exchanges = false; // No exchanges yet.
			// Compare each pair of adjacent elements.
			for (int i = 0; i < table.length - pass; i++) {
				if (table[i].compareTo(table[i + 1]) > 0) {
					// Exchange pair.
					T temp = table[i];
					table[i] = table[i + 1];
					table[i + 1] = temp;
					exchanges = true;  // Set flag.
				}
			}
			pass++;
		} while (exchanges);
		// assert: Array is sorted.
	}
}
			

