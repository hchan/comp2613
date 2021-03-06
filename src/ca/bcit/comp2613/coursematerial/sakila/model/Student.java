package ca.bcit.comp2613.coursematerial.sakila.model;

// Generated Jul 10, 2014 9:29:20 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "student", catalog = "sakila")
public class Student implements java.io.Serializable {

	private Long id;
	private String firstName;
	private String lastName;
	private Set<TeacherStudent> teacherStudents = new HashSet<TeacherStudent>(0);

	public Student() {
	}

	public Student(String firstName, String lastName,
			Set<TeacherStudent> teacherStudents) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.teacherStudents = teacherStudents;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<TeacherStudent> getTeacherStudents() {
		return this.teacherStudents;
	}

	public void setTeacherStudents(Set<TeacherStudent> teacherStudents) {
		this.teacherStudents = teacherStudents;
	}

}
