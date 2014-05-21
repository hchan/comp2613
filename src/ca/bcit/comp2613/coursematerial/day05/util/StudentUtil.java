package ca.bcit.comp2613.coursematerial.day05.util;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import ca.bcit.comp2613.coursematerial.day02.model.Student;
import ca.bcit.comp2613.coursematerial.day02.model.Teacher;

public class StudentUtil {

	public static ArrayList<Student> create1000RandomStudents() {
		ArrayList<Student> students = new ArrayList<>();
	
		for (int i = 0; i < 1000; i++) {
			String firstName = UUID.randomUUID().toString();
			String lastName = UUID.randomUUID().toString();
			Student student = new Student (Integer.toString(i), firstName, lastName);
			students.add(student);
		}
		return students;
	}
	
	public static void randomlyAssignStudentsToTeachers(ArrayList<Teacher> teachers,
			ArrayList<Student> students) {
		int studentArraySize = students.size();
		for (Teacher teacher: teachers) {
			Random rand = new Random();
			int randStudentIndex = rand.nextInt(studentArraySize);
			for (int i = 0; i < 10; i++) {
				Student randomStudent = students.get(randStudentIndex);
				randomStudent.setTeacherId(teacher.getId());
			}
		}
	}

	
}
