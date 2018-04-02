package dev.strings.createString;

public class Main {
	
	// Strings literal are being created in the String pool and a re reused.
	// String constructor created new Objects in the heap no matter what is the value.
	
	public static void main(String[] args) {
		String first = "myTestString"; // Created in the String pool
		String second = "myTestString"; // Will hold a reference of "frist".
		String third = new String("myTestString"); // Created in the heap
		String fourth = new String("myTestString"); // Created in the heap
		
		System.out.println(first == second); // true
		System.out.println(first == "myTestString"); // true
		System.out.println(first == third); // false
		System.out.println(third == fourth); // false
		
		System.out.println(first == "my" + "Test" + "String"); // true
		
		// equals checks only the actual value
		System.out.println(first.equals(third)); // true
		System.out.println("first's hashCode: " + first.hashCode() + " third's hashCode: " + third.hashCode());
		
		// Important - although 2 strings can return true when using the compare method and also have the
		// same hashCode, still they can be exist in 2 different places in memory.
	}

}
