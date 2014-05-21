package ca.bcit.comp2613.coursematerial.day02.util;

import java.util.ArrayList;

import ca.bcit.comp2613.coursematerial.day02.model.Teacher;

public class TeacherUtil {

	public static String LOREM_IPSUM = "In publishing and graphic design, lorem ipsum is a placeholder text commonly used to "
			+ "demonstrate the graphic elements of a document or visual presentation. By replacing the distraction of meaningful "
			+ "content with filler text of scrambled Latin it allows viewers to focus on graphical elements such as font, typography, and layout" + 
			"The lorem ipsum text is typically a mangled section of De finibus bonorum et malorum, a 1st-century BC Latin text by Cicero, with words "
			+ "altered, added, and removed that make it nonsensical, improper Latin" + 
			"A variation of the common lorem ipsum text has been used during typesetting since the 1960s or "
			+ "earlier, when it was popularized by advertisements for Letraset transfer sheets. It was introduced "
			+ "to the Digital Age by Aldus Corporation in the mid-1980s, which employed it in graphics and word processing templates "
			+ "for its breakthrough desktop publishing program, PageMaker for the Apple Macintosh"; 

	public static ArrayList<Teacher> createTeachers() {
		ArrayList<Teacher> retval = new ArrayList<>();
		String[] strs = LOREM_IPSUM.split("\\s");
		// create loop
		for (int i = 0; i < strs.length; i++) {
			Teacher teacher = new Teacher();
			teacher.setId(Integer.toString(i));
			teacher.setFirstName(strs[i].toUpperCase());
			teacher.setLastName(new StringBuilder(strs[i]).reverse().toString());
			retval.add(teacher);
		}
		return retval;
	}

	public static void printTeachers(ArrayList<Teacher> teachers) {
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}

	public static ArrayList<Teacher> searchTeachersByFirstName(ArrayList<Teacher> teachers, 
			String firstName) {
		ArrayList<Teacher> retval = new ArrayList<>();
		for (Teacher teacher : teachers) {
			if (teacher.getFirstName().equals(firstName)) {
				retval.add(teacher);
			}
		}
		return retval;
	}

	public static ArrayList<Teacher> searchTeachersByFirstNameRegex(
			ArrayList<Teacher> teachers, String regex) {
		ArrayList<Teacher> retval = new ArrayList<>();
		for (Teacher teacher : teachers) {
			 if (teacher.getFirstName().matches(regex)) {
			// if (teacher.getFirstName().matches("(?i)Dum.*")) { // how about this regex?
			// if (teacher.getFirstName().matches("(?)DUM")) { // how about this regex?
				 System.out.println(teacher);
			 }
		}
		return retval;
	}
}
