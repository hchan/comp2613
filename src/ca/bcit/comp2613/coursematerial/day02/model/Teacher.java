package ca.bcit.comp2613.coursematerial.day02.model;

public class Teacher {
	private String id;
	private String firstName;
	private String lastName;
	public Teacher() {
		
	}
	public Teacher(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {	
		// kinda JSON'ish, but not 100% there
		// fyi, there's a tool for that ;)
		return "id = " + id + ", firstName = " + firstName + ", lastName = " + lastName; 
	}

}
