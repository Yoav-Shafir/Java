package dev.other.defaultValues;

class DefaultValues {
	// primitive types
	boolean defaultBoolean;
	char defaultChar;
	byte defaultByte;
	int defaultInt;
	long defaultLong;
	double defaultDouble;
	float defaultFloat;
	
	// Object sample
	String defaultString;
	Object defaultObject;
}

public class Main {
	
	public static void main(String[] args) {
		
		DefaultValues df = new DefaultValues();
		System.out.println("defaultBoolean: " + df.defaultBoolean);
		System.out.println("defaultChar: " + df.defaultChar);
		System.out.println("defaultByte: " + df.defaultByte);
		System.out.println("defaultInt: " + df.defaultInt);
		System.out.println("defaultLong: " + df.defaultLong);
		System.out.println("defaultDouble: " + df.defaultDouble);
		System.out.println("defaultFloat: " + df.defaultFloat);
		System.out.println("defaultString: " + df.defaultString);
		System.out.println("defaultObject: " + df.defaultObject);
	}

}
