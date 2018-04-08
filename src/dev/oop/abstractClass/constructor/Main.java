package dev.oop.abstractClass.constructor;

// abstract class can have a constructor, although we cannot instantiate it.
abstract class A {
	public A() {
		System.out.println("From abstract A constructor");
	}
}

class B extends A {}

public class Main {

	public static void main(String[] args) {
		new B(); // -> Will print From abstract A constructor
	}

}
