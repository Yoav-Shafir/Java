package dev.collections.set.custom1;

import java.util.HashMap;
import java.util.Map;

// Example of how to put, get, remove Employee object in custom HashSet.

// Main take away - The most common implementation is HashSet which means that the set
// is backed by a map, all set values are being inserted to the map as keys,
// this is how we get uniqueness.

class Employee {
	private String id;
    private String name;
    
    public Employee(String id, String name) {
    	this.id = id;
        this.name = name;
	}
    
    @Override
    public String toString() {
           return "Employee[id=" + id + ", name=" + name + "] ";
    }
    
    @Override
    // helps in checking equality of employee objects used as key in entry objects.
    public boolean equals(Object o){
    	if (o == null) {
    		return false;
    	}
    	
    	if (this.getClass() != o.getClass()) {
    		return false;
    	}
    	
    	Employee e = (Employee) o;
    	
    	return e.id.equals(this.id) && e.name.equals(this.name);  
    }
    
    @Override
    // helps in finding bucket’s index on which data will be stored.
    public int hashCode(){
       return id.hashCode() + name.hashCode();      
    }
}

// HashSet is backed by a HashMap
// It makes no guarantees about the sequence of the elements when you iterate them.
class HashSetCustom<E> {
	
	private Map<E, Object> map;
	
	public HashSetCustom() {
		map = new HashMap<>();
	}
	
	// add objects in SetCustom.
	public void add(E value){
		E key = value;
        map.put(key, null);    
	}
	
	public boolean contains(E value){
		E key = value;
		return map.containsKey(key);
	}
	 
	public void remove(E value){
		E key = value;
		map.remove(key);
	}
	
	public void display() {
		for (E key: map.keySet()) {
			E value = key;
			System.out.println(value);
		}
	}
}

public class Main {

	public static void main(String[] args) {
		HashSetCustom<Employee> hashSetCustom = new HashSetCustom<>();
		hashSetCustom.add(new Employee("1", "Yoav"));
		hashSetCustom.add(new Employee("2", "Eiyar"));
		
		hashSetCustom.display();
	}
}
