package dev.lambda.beforeAndAfter.sortStringArr;

import java.util.Arrays;
import java.util.Comparator;

class StringSort implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
}

public class Main {
	
	public static void main(String[] args) {
		
		// Using Class that implements the Comparator interface.
		String[] stringArray1 = {"ab", "ef", "cd"};
		Arrays.sort(stringArray1, new StringSort());
		System.out.println(Arrays.toString(stringArray1));
		
		// Using Anonymous Inner class
		String[] stringArray2 = {"ab", "ef", "cd"};
		Arrays.sort(stringArray2, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		System.out.println(Arrays.toString(stringArray2));
		
		// Using Lambda expression.
		String[] stringArray3 = {"ab", "ef", "cd"};
		Arrays.sort(stringArray3, (s1, s2) -> s1.compareTo(s2));
		System.out.println(Arrays.toString(stringArray3));
	}
}
