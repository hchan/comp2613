package ca.bcit.comp2613.coursematerial.day09.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import ca.bcit.comp2613.coursematerial.day09.model.Student;
import ca.bcit.comp2613.coursematerial.day09.model.Teacher;

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

	public static void save(List<Teacher> teachers, Teacher teacher) {
		boolean foundUpdate = false;
		for (Teacher teacherLoop :teachers) {
			if (teacherLoop.getId().equals(teacher.getId())) {
				teacherLoop.setFirstName(teacher.getFirstName());
				teacherLoop.setLastName(teacher.getLastName());
				foundUpdate = true;
				break;
			}
		}
		if (!foundUpdate) { // do an insert
			teachers.add(teacher);
		}
	}

	public static void delete(List<Teacher> teachers, Teacher teacher) {
		Iterator<Teacher> iter = teachers.iterator();
		while (iter.hasNext()) {
			Teacher teacherLoop = iter.next();
			if (teacherLoop.getId().equals(teacher.getId())) {
				iter.remove();
				break;
			}
		}
	}

	public static Teacher findById(String id, List<Teacher> teachers) {
		for (Teacher teacherLoop :teachers) {
			if (teacherLoop.getId().equals(id)) {
				return teacherLoop;
			}
			
		}
		return null;
	}

	public static void removeFromClass(Teacher teacher, Student student) {
		if (teacher.getStudents() != null) {
			Iterator<Student> iter = teacher.getStudents().iterator();
			while (iter.hasNext()) {
				Student studentLoop = iter.next();
				if (studentLoop.getId().equals(student.getId())) {
					iter.remove();
					break;
				}
			}
		}
		
	}

	public static void addToClass(Teacher teacher, Student student, List<Student> students) {
		if (teacher.getStudents() == null) {
			teacher.setStudents(new ArrayList<Student>());
		}
		for (Student studentLoop : teacher.getStudents()) {
			if (studentLoop.getId().equals(student.getId())) {
				return; // already in class
			}
		}
		
		student = StudentUtil.findById(student.getId(), students);
		teacher.getStudents().add(student);
	}

	
}
