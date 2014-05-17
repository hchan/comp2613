package ca.bcit.comp2613.coursematerial.day09.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // let the datbase create the id (think sequence: 1, 2, 3, 4...)
	private Long id;
	private String firstName;
	private String lastName;
	@Transient // don't save the teacher to the DB, but we will save the teacherId
	private Teacher teacher;
	private String teacherId;
	
	
	
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	// cool, I have a getter for Id - but no setter ... @GeneratedValue(strategy=GenerationType.AUTO) prevents us from using a setter at runtime
	public Long getId() {
		return id;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		return id + ": " + firstName + " " + lastName;
	}
}
