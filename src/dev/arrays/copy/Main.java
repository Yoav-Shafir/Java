package dev.arrays.copy;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		
		// Copy methods
		int[] src = {1,2,3,4,5};
		int[] dest = new int[10];
		
		// Using the System class arraycopy static method.
		
		// Object src,
        // int srcPos,
        // Object dest,
        // int destPos,
        // int length
		System.arraycopy(src, 0, dest, 0, src.length);
		System.out.println(Arrays.toString(dest)); // -> will print [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
		
	}

}
