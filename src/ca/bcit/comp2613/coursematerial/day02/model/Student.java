package ca.bcit.comp2613.coursematerial.day02.model;

public class Student {
	private String id;
	private String firstName;
	private String lastName;
	private Integer finalMark;
	private String teacherId;
	
	
	public Student() {
		
	}
	public Student(String id, String firstName, String lastName) {
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
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getFinalMark() {
		return finalMark;
	}
	public void setFinalMark(Integer finalMark) {
		this.finalMark = finalMark;
	}

}
