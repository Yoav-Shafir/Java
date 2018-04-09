package dev.oop.interfaces.serializable.simple1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Serialization is a mechanism of converting the state of an object into a byte stream.
// Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.
// This mechanism is used to persist the object.

// https://www.geeksforgeeks.org/serialization-in-java/
class Demo implements java.io.Serializable
{
    public int a;
    public String b;
 
    // Default constructor
    public Demo(int a, String b)
    {
        this.a = a;
        this.b = b;
    }
 
}
public class Main {

	public static void main(String[] args) {
		Demo object = new Demo(1, "geeksforgeeks");
        String filename = "file.ser";
        
        // Serialization 
        try {
        	//Saving of object in a file
        	// BTW, we have stream decoration here.
        	FileOutputStream file = new FileOutputStream(filename);
        	ObjectOutputStream out = new ObjectOutputStream(file);
        	
        	// Method for serialization of object
            out.writeObject(object);
            
            out.close();
            file.close();
             
            System.out.println("Object has been serialized");
		} catch (IOException e) {
            System.out.println("IOException is caught");
		}
        
        // Deserialization
        Demo object1 = null;
        
        try {
        	// Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
             
            // Method for deserialization of object
            object1 = (Demo)in.readObject();
             
            in.close();
            file.close();
             
            System.out.println("Object has been deserialized ");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
		} catch (IOException e) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException is caught");
		}
	}

}
