package dev.exceptions.customException;

// Creating a checked Exception by extending Exception.
class CustomException extends Exception {
	
	public CustomException() {	
		super();
	}
	
	public CustomException(String message) {
		super(message);
	}
}

//Creating a unchecked Exception by extending RuntimeException.
class CustomUnCheckedException extends RuntimeException {
	
	public CustomUnCheckedException() {	
		super();
	}
	
	public CustomUnCheckedException(String message) {
		super(message);
	}
}

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		try {
			main.throwCheckedException();
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Inside finally block");
		}
		
		main.throwUnCheckedException();

	}
	
	// Checked Exception.
	private void throwCheckedException() throws CustomException {
		System.out.println("Inside Main.throwCheckedException method");
		throw new CustomException("This is a custom checked Exception");
	}
	
	// Unchecked Exception.
	private void throwUnCheckedException() {
		System.out.println("Inside Main.throwUnCheckedException method");
		throw new CustomUnCheckedException("This is a custom unchecked Exception");
	}

}
