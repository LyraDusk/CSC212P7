package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class InsertionSort {
	
	public static ListADT<Integer> insertionSort(ListADT<Integer> input) {
		ListADT<Integer> sorted = new JavaList<>();
		while (input.size() > 0) {
			int value = input.removeFront();
			Integer index = null;
			if (sorted.size() == 0) {
				sorted.addFront(value);
				System.out.println("a");
				continue;
			}
			for (int i = 0; i < sorted.size(); i++) {
				if (sorted.getIndex(i) > value) {
					index = i;
					System.out.println("b");
					break;
				} else {
					System.out.println("c");
					continue;
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
