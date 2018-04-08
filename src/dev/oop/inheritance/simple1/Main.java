package dev.oop.inheritance.simple1;

class A {
	public A() {
		System.out.println("From Constructor A");
	}
}

class B extends A {
	public B() {
		System.out.println("From Constructor B");
	}
}

class C extends A {}

public class Main {

	public static void main(String[] args) {
		
		// Will print:
		// From Constructor A
		// From Constructor B
		B b = new B();
		
		C c = new C(); // -> Will print: From Constructor A
		
		// A class cannot inherit a super class Constructor.
		// A super class if first fully initialized and only then the child class.
	}

}
