package dev.generics.getPutPrinciple.simple1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// http://www.softwaregeek.net/2013/02/get-and-put-principle-in-java-generics.html

// Use an extends wildcard when you only get values out of a structure, 
// use a super wildcard when you only put values into a structure, 
// and don’t use a wildcard when you both get and put.

class CollectionUtils {
	// Assume we need to implement a method which gets the values from a source collection 
	// and adds them to a destination collection. It might look like this:		
	public static <T> void addAll1(Collection<T> dst, Collection<T> src) {
		for (T element: src) {
			dst.add(element);
		}
	}
	
	// 2nd version
	public static <T> void addAll2(Collection<? super T> dst, Collection<T> src) {
		for (T element: src) {
			dst.add(element);
		}
	}
	
	public static <T> void addAll3(Collection<? super T> dst, Collection<? extends T> src) {
		for (T element : src) {
			dst.add(element);
		}
	}
}

public class Master {

	public static void main(String[] args) {
		
		// This code is perfectly fine and will work.
		Collection<Integer> src1 = Arrays.asList(1, 2, 3, 4);
		Collection<Integer> dst1 = new ArrayList<Integer>();
		
		CollectionUtils.addAll1(dst1, src1);
		System.out.println(dst1); // -> will print [1, 2, 3, 4]
		
		
		// However, the addAll1() method is not flexible enough.
		// If we would like to to append contents of the src collection to the dst collection of typed Collection<Object>
		// which is a very valid use case,
		// the current implementation of the addAll() method disallows this:
		
		Collection<Integer> src2 = Arrays.asList(1, 2, 3, 4);
		Collection<Object> dst2 = new ArrayList<Object>();
		
		// addAll1(dst2, src2); // -> compile time error
		
		// So we need to use the addAll2() method.
		// Since we only put values in dst2, if dst2 will be of a type
		// that is super of src2 it will always be possible to put inside values of src2.
		CollectionUtils.addAll2(dst2, src2);
		
		// This is how we provided an explicit type parameter for generic method invocation.
		// So the compiler sees the method signature like this -> <Number>addAll2(Collection<? super Number>, Collection<Number>)
		// The problem is that the actual arguments are        -> (Collection<Object>, Collection<Integer>)
		//CollectionUtils.<Number>addAll2(dst2, src2); // -> compie time error
		
		// This will work,
		// The compiler sees the method signature like this    -> addAll3(Collection<? super Number> dst, Collection<? extends Number> src)
		// and the arguments are                              -> (Collection<Object>, Collection<Integer>)
		// So the compiler is happy.
		CollectionUtils.<Number>addAll3(dst2, src2);
		
		// Another Example:
		
		// Use an extends wildcard when you only get return values out of a method, 
		// use a super wildcard when you only pass arguments into a method, 
		// and don’t use a wildcard when you both get and pass.
		
		// creates a reference list and points it to an instance of ArrayList<Integer>. 
		// This line tries to add an integer value to ArrayList<Integer> by accessing it via wildcard-typed reference list.
		List<? extends Number> list1 = new ArrayList<Integer>();
		// list1.add(7); // compile-time error
		
		// why do we get compile time error?
		// because otherwise we could have done something like that:
		
		// List<? extends Number> list = new ArrayList<Double>();
		// list.add(7);
		 
		// This compiles without an error because null literal according to JLS can be of any reference type.
		list1.add(null);
		
		// This line also compiles and works as expected.
		Number value1 = list1.get(0);
		
		// So how can we solve it?
		List<? super Integer> list2 = new ArrayList<Integer>();
		
		//  This time compiler allows the call because type parameter is guaranteed to be a super-type of Integer class; 
		// hence it is safe to pass an instance of Integer class itself as an argument to the add() method.
		list2.add(7);
		// Number value2 = list2.get(0); // compile-time error
		Object value3 = list2.get(0);
		
	}
}
