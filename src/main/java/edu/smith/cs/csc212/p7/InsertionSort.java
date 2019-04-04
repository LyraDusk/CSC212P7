package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class InsertionSort {
	/*
	 * Sorts a list by taking the first item off the list and inserting it
	 * into a sorted list at the correct index.
	 * Takes one list and returns a new one.
	 */
	public static ListADT<Integer> insertionSort(ListADT<Integer> input) {
		ListADT<Integer> sorted = new JavaList<>();
		int size = input.size();
		while (sorted.size() < size) {
			int value = input.removeFront();
			Integer index = null;
			if (sorted.size() == 0) {
				sorted.addFront(value);
				continue;
			}
			
			//Get the first higher index to insert the value
			for (int i = 0; i < sorted.size(); i++) {
				if (sorted.getIndex(i) > value) {
					index = i;
					break;
				} else {
					index = -1;
				}
			}
			// if value is the highest, add to back
			if (index == -1) {
				sorted.addBack(value);
			// else, add it to its index
			} else {
				sorted.addIndex(index, value);
			}
			
		}
		return sorted;
	}
}
