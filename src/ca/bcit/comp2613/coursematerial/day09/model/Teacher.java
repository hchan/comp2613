package ca.bcit.comp2613.coursematerial.day09.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Teacher {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "teacher_student",
	joinColumns = { @JoinColumn(name = "teacher_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private List<Student> students;
	
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
