package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class SelectionSort {
	/*
	 *  Selection sort takes an input list and returns a sorted output list.
	 */

	public static ListADT<Integer> selectionSort(ListADT<Integer> input) {
		ListADT<Integer> sorted = new JavaList<>();
		while (input.size() > 0) {
			// Get the index of the minimum value
			int minIndex = 0;
			for (int i = 0; i < input.size(); i++) {
				if (input.getIndex(i) < input.getIndex(minIndex)) {
					minIndex = i;
				}
			}
			// Remove that index from unsorted, add to sorted
			int value = input.removeIndex(minIndex);
			sorted.addBack(value);
			
		}
		return sorted;
	}
}
