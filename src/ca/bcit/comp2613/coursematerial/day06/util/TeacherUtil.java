package ca.bcit.comp2613.coursematerial.day06.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ca.bcit.comp2613.coursematerial.day06.model.Teacher;

public class TeacherUtil {

	public static ArrayList<Teacher> create100RandomTeachers() {
		ArrayList<Teacher> teachers = new ArrayList<>();
		Teacher teacher = new Teacher("a00788076", "Henry", "Chan");

		teachers.add(teacher);
		teacher = new Teacher("a00123456", "Paul", "Mills");
		teachers.add(teacher);
		for (int i = 0; i < 100; i++) {
			String firstName = UUID.randomUUID().toString();
			String lastName = UUID.randomUUID().toString();
			teacher = new Teacher (Integer.toString(i), firstName, lastName);
			teachers.add(teacher);
		}
		return teachers;
	}

	public static void update(List<Teacher> teachers, Teacher teacher) {
		for (Teacher teacherLoop :teachers) {
			if (teacherLoop.getId().equals(teacher.getId())) {
				teacherLoop.setFirstName(teacher.getFirstName());
				teacherLoop.setLastName(teacher.getLastName());
				break;
			}
		}
		
	}

	
}
