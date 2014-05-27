package ca.bcit.comp2613.coursematerial.day06.util;

import java.util.ArrayList;
import java.util.UUID;

import ca.bcit.comp2613.coursematerial.day06.model.Teacher;

public class TeacherUtil {

	public static ArrayList<Teacher> create100RandomTeachers() {
		ArrayList<Teacher> teachers = new ArrayList<>();
		Teacher teacher = new Teacher("1", "Henry", "Chan");

		teachers.add(teacher);
		teacher = new Teacher("2", "Paul", "Mills");
		teachers.add(teacher);
		for (int i = 0; i < 100; i++) {
			String firstName = UUID.randomUUID().toString();
			String lastName = UUID.randomUUID().toString();
			teacher = new Teacher (Integer.toString(i), firstName, lastName);
			teachers.add(teacher);
		}
		return teachers;
	}

	
}
