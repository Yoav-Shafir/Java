package dev.algo.arrays.removeDuplicat.custom1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class RemoveDuplicaets {
	private int[] array;
	private Entry head;
	private Entry tail;
	private int size;
	private Map<Integer, Object> map;
	
	public RemoveDuplicaets(int[] array) {
		this.array = array;
		this.map = new HashMap<>();
	}
	
	public int[] apply() {
		
		int index = 0;
		
		// Iterating over each item in the Array.
		while (index < this.array.length) {
			
			// Get the current element.
			int current = this.array[index];
			
			// Check if it's already in the map.
			if (!map.containsKey(current)) {
				
				// If not, this is the first itme we see it.
				// We create new Entry object.
				Entry newEntry = new Entry(current);
				
				// This is the first time we create an Entry object
				// to the LinkedList.
				if (size == 0) {
					
					// both, head & tail are now pointing to the new Entry.
					head = tail = newEntry;
				} else {
					
					// This is not the first Entry in the LinkedList,
					// we need to adjust the pointers.
					tail.next = newEntry;
					tail = newEntry;
				}
				
				// Finally put the new Entry in the map
				// and update the size.
				map.put(current, null);
				size++;
			}
			
			// Move to the next element in the array.
			index++;
		}
		
		// Create the final Array based on the LinkedList size.
		// and iterate over the LinkedList assigning each element to the array.
		Entry current = head;
		int[] noDuplicatesArr = new int[size];
		int i = 0;
		while (current != null) {
			noDuplicatesArr[i] = current.value;
			current = current.next;
			i++;
		}
		
		return noDuplicatesArr;
	}
	
	// Local Entry class.
	private static class Entry {
		
		private int value;
		private Entry next;
		
		public Entry(int value) {
			this.value = value;
		}
	}
}


public class Main {

	public static void main(String[] args) {
		int[] array = {0,3,7,5,9,3,7,4,4,0};
		RemoveDuplicaets rd = new RemoveDuplicaets(array);
		System.out.println(Arrays.toString(rd.apply()));
	}

}
