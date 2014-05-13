package ca.bcit.comp2613.coursematerial.day05.util;

import java.util.ArrayList;
import java.util.UUID;

import ca.bcit.comp2613.coursematerial.day05.model.Teacher;

public class TeacherUtil {

	public static ArrayList<Teacher> create100RandomTeachers() {
		ArrayList<Teacher> teachers = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			String firstName = UUID.randomUUID().toString();
			String lastName = UUID.randomUUID().toString();
			Teacher teacher = new Teacher (Integer.toString(i), firstName, lastName);
			teachers.add(teacher);
		}
		return teachers;
	}
}
