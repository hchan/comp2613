package ca.bcit.comp2613.coursematerial.day02;

import java.util.ArrayList;
import java.util.Arrays;

import ca.bcit.comp2613.coursematerial.day02.model.Teacher;

public class TeacherDemo {
	public static String LOREM_IPSUM = "Lorem Ipsum is simply dummy text of the printing and typesetting industry"; // copy
																													// and
																													// pasted
																													// from:
																													// http://www.lipsum.com/

	public static void main(String[] args) {
		ArrayList<Teacher> teachers = new ArrayList<>();
		String[] strs = LOREM_IPSUM.split("\\s");
		// create loop
		for (int i = 0; i < strs.length; i++) {
			Teacher teacher = new Teacher();
			teacher.setId(Integer.toString(i));
			teacher.setFirstName(strs[i].toUpperCase());
			teacher.setLastName(new StringBuilder(strs[i]).reverse().toString());
			teachers.add(teacher);
		}

		// print out all teachers
		System.out.println(Arrays.toString(teachers.toArray()));
		System.out.println("-------------");

		// find a dum(my) - quite literally!! teacher via regex
		// Reference: http://www.rexegg.com/regex-quickstart.html
		for (Teacher teacher : teachers) {
			 if (teacher.getFirstName().matches("DUM.*")) {
			// if (teacher.getFirstName().matches("(?i)Dum.*")) { // how about this regex?
			// if (teacher.getFirstName().matches("(?)DUM")) { // how about this regex?
				 System.out.println(teacher);
			 }
		}
	}
}
