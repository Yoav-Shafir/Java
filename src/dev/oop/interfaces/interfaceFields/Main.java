package dev.oop.interfaces.interfaceFields;

interface MyInterface {
	
	// Fields are always public, static and final.
	public static final String FOO = "Foo";
	String BAR = "Bar";
}

public class Main {

	public static void main(String[] args) {
		System.out.println(MyInterface.FOO);
		System.out.println(MyInterface.BAR);
	}

}
