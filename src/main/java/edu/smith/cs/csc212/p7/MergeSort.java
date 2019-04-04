package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.DoublyLinkedList;
import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class MergeSort {
	/*
	 * Recursive MergeSort, which breaks the list down and builds it back up again recursively
	 * Takes a list, returns a new one. 
	 */
	public static ListADT<Integer> mergeSortRecursive(ListADT<Integer> input) {
		if (input.size() <= 1) {
			return input;
		} else {
			int size = input.size();
			int half = size / 2;
			int last = input.size();
			ListADT<Integer> half1 = input.slice(0,half);
			ListADT<Integer> half2 = input.slice(half, last);
			half1 = mergeSortRecursive(half1);
			half2 = mergeSortRecursive(half2);
			ListADT<Integer> sorted = combineHelper(half1, half2);
			System.out.println(sorted);
			return sorted;
		}
		
		
	}
	/*
	 * Iterative mergesort, which breaks the list down into single lists one by one, and then sorts them back together
	 * Takes a single list and returns a new sorted one.
	 */
	public static ListADT<Integer> mergeSortIterative(ListADT<Integer> input) {
		ListADT<ListADT<Integer>> queue = new DoublyLinkedList<>();
		for (int i: input) {
			ListADT<Integer> single = new JavaList<>();
			single.addBack(i);
			queue.addBack(single);
		}
		while (queue.size() > 1) {
			ListADT<Integer> first = queue.removeFront();
			ListADT<Integer> second = queue.removeFront();
			ListADT<Integer> sorted = combineHelper(first, second);
			queue.addBack(sorted);
		}
		return queue.getFront();
	}
	/*
	 * The function that combines lists in the Recursive MergeSort. 
	 * Takes two sorted lists and combines them into one.s
	 */
	public static ListADT<Integer> combineHelper(ListADT<Integer> list1, ListADT<Integer> list2) {
		ListADT<Integer> sorted = new JavaList<>();
		while (list1.size() > 0 && list2.size() > 0) {
			int value1 = list1.getFront();
			int value2 = list2.getFront();
			if (value1 < value2) {
				sorted.addBack(value1);
				list1.removeFront();
			} else {
				sorted.addBack(value2);
				list2.removeFront();
			}
		}
		if (list1.size() > 0) {
			sorted.addAll(list1);
		}
		if (list2.size() > 0) {
			sorted.addAll(list2);
			
		}
		return sorted;
	}
	
}
