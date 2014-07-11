package ca.bcit.comp2613.coursematerial.day09.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// let the datbase create the id (think sequence: 1, 2, 3, 4...)
	private Long id;
	private String firstName;
	private String lastName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	//@ManyToMany(fetch=FetchType.EAGER)
	//@Fetch (FetchMode.JOIN) // note that the fetchmode will be select ... damn bug with Spring Data!
	@JoinTable(name = "teacher_student",
	joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "teacher_id") })
	private List<Teacher> teachers;

	public Student() {
		
	}
	
	
	


	public Student(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public Student(String id, String firstName, String lastName) {
		super();
		this.id = Long.parseLong(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// cool, I have a getter for Id - but no setter ...
	// @GeneratedValue(strategy=GenerationType.AUTO) prevents us from using a
	// setter at runtime
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

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", teachers=" + teachers + "]";
	}


}
