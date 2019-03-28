package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class InsertionSort {
	
	public static ListADT<Integer> insertionSort(ListADT<Integer> input) {
		ListADT<Integer> sorted = new JavaList<>();
		while (input.size() > 0) {
			int value = input.removeFront();
			Integer index = null;
			for (int i = 0; i < input.size(); i++) {
				if (sorted.size() == 0) {
					sorted.addFront(value);
					break;
				} else {
					if (input.getIndex(i) > value) {
						index = i;
						break;
					}
				}
			}
			if (index != null) {
				sorted.addIndex(index, value);
			} else {
				input.addBack(value);
			}
		}
		return sorted;
	}
}
