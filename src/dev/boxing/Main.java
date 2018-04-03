package dev.boxing;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// autoboxing from int to Integer.
		Integer myNumber = 8; // Auto-Boxing through assignment.
		
		unBoxingThroughMethodInvocation();
		
		autoBoxingWithList();
		
		sumEven();
	}

	private static void unBoxingThroughMethodInvocation() {
		// 1. Unboxing through method invocation.
		int absVal = absoluteValue(new Integer(-8));
		System.out.println("absolute value of -8 is = " + absVal);
	}

	private static int absoluteValue(int i) {
		System.out.println("Inside absoluteValue(int i)");
		return (i < 0) ? -i : i;
	}
	
	// If we uncomment this method, it will be prefered by the compiler,
	// because Integer i as an argument is a better match
//	private static int absoluteValue(I.nteger i) {
//		System.out.println("Inside absoluteValue(Integer i)");
//		return (i < 0) ? -i : i;
//	}
	
	private static void autoBoxingWithList() {
		List<Double> ld = new ArrayList<>();
		double pi = 3.1416;
		
		// This operation failed before Java 1.5,
		// list could accept only objects.
		ld.add(pi); // pi is autoboxed through method invocation.
		
		pi = ld.get(0); // Unboxing through assignment.
		System.out.println("pi = " + pi);
	}
	
	private static int sumEven() {
		List<Integer> li = addIntToList();
		int sum = 0;
		for (Integer i : li) {
			// The compiler does not generate and error
			// because it invokes the i.intValue() method.
			if (i % 2 == 0) {
				sum += 1;
			}
		}
		System.out.println("sum of Even is = " + sum);
		return sum;
	}
	
	public static List<Integer> addIntToList() {
		List<Integer> li = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			// Auto-boxing - compiler convert the code into -> li.add(Integer.valueOf(i))
			li.add(i);
		}
		return li;
	}
}
