package ca.bcit.comp2613.coursematerial.day09.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import ca.bcit.comp2613.coursematerial.day09.model.Student;
import ca.bcit.comp2613.coursematerial.day09.model.Teacher;

public class StudentUtil {

	public static ArrayList<Student> create1000RandomStudents() {
		ArrayList<Student> students = new ArrayList<>();
	
		for (int i = 0; i < 1000; i++) {
			String firstName = UUID.randomUUID().toString();
			String lastName = UUID.randomUUID().toString();
			long id = i;
			Student student = new Student (id, firstName, lastName);
			students.add(student);
		}
		return students;
	}
	
	public static void randomlyAssignStudentsToTeachers(List<Teacher> teachers,
			List<Student> students) {
		int studentArraySize = students.size();
		for (Teacher teacher: teachers) {
			Random rand = new Random();
			
			for (int i = 0; i < 10; i++) {
				int randStudentIndex = rand.nextInt(studentArraySize);
				Student randomStudent = students.get(randStudentIndex);
				if (teacher.getStudents() == null) {
					teacher.setStudents(new ArrayList<Student>());					
				}
				TeacherUtil.addToClass(teacher, randomStudent, students);
			}
		}
	}

	public static void save(List<Student> students, Student student) {
		boolean foundUpdate = false;
		for (Student studentLoop :students) {
			if (studentLoop.getId().equals(student.getId())) {
				studentLoop.setFirstName(student.getFirstName());
				studentLoop.setLastName(student.getLastName());
				foundUpdate = true;
				break;
			}
		}
		if (!foundUpdate) { // do an insert
			students.add(student);
		}
	}

	public static void delete(List<Student> students, Student student) {
		Iterator<Student> iter = students.iterator();
		while (iter.hasNext()) {
			Student studentLoop = iter.next();
			if (studentLoop.getId().equals(student.getId())) {
				iter.remove();
				break;
			}
		}
	}

	public static Student findById(Long id, List<Student> students) {
		for (Student studentLoop :students) {
			if (studentLoop.getId().equals(id)) {
				return studentLoop;
			}
			
		}
		return null;
	}
}
