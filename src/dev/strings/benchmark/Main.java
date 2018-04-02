package dev.strings.benchmark;

// Simple String concat vs StringBuffer append vs StringBuilder append bench mark.

public class Main {

	public static void main(String[] args) {
		appendStrings();
		
		// Thread safe.
		appendStringBuffer();
		
		// Non Thread safe.
		appendStringBuilder();
	}
	
	// This method is the slowest!,
	// each time the JVM creates a new Object,
	// this consumes a lot of memory in total.
	private static void appendStrings() {
		long start = System.currentTimeMillis();
		String first = "First";
		String second = "Second";
		for (int i = 0; i < 50000; i++) {
			first = first + second;
		}
		long end = System.currentTimeMillis();
		System.out.println("Total running time for String is: " + (end - start) + " millis.");
	}
	
	// Thread safe.
	private static void appendStringBuffer() {
		long start = System.currentTimeMillis();
		StringBuffer first = new StringBuffer("First");
		String second = "Second";
		for (int i = 0; i < 50000; i++) {
			first.append(second);
		}
		long end = System.currentTimeMillis();
		System.out.println("Total running time for String is: " + (end - start) + " millis.");
	}
	
	// This method is the fastest!
	// no synchronization under the hood.
	// Non Thread safe.
	private static void appendStringBuilder() {
		long start = System.currentTimeMillis();
		StringBuffer first = new StringBuffer("First");
		String second = "Second";
		for (int i = 0; i < 50000; i++) {
			first.append(second);
		}
		long end = System.currentTimeMillis();
		System.out.println("Total running time for String is: " + (end - start) + " millis.");
	}
}
