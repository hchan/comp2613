package ca.bcit.comp2613.coursematerial.day02;

import java.util.ArrayList;
import java.util.Arrays;

import ca.bcit.comp2613.coursematerial.day02.model.Teacher;
import ca.bcit.comp2613.coursematerial.day02.util.TeacherUtil;

public class TeacherDemo {
																												

	public static void main(String[] args) {
		ArrayList<Teacher> teachers = TeacherUtil.createTeachers();
		TeacherUtil.printTeachers(teachers);
		System.out.println("---------------");
		ArrayList<Teacher> teachersByFirstName = TeacherUtil.searchTeachersByFirstName(teachers, "PUBLISHING");
		TeacherUtil.printTeachers(teachersByFirstName);
		
		System.out.println("---------------");
		ArrayList<Teacher> teachersByFirstNameRegex = TeacherUtil.searchTeachersByFirstNameRegex(teachers, "WO.*");
		TeacherUtil.printTeachers(teachersByFirstNameRegex);
		
	}
}
