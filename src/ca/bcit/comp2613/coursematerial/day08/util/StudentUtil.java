package ca.bcit.comp2613.coursematerial.day08.util;

import java.util.ArrayList;
import java.util.Random;

import ca.bcit.comp2613.coursematerial.day08.model.Student;
import ca.bcit.comp2613.coursematerial.day08.model.Teacher;

public class StudentUtil {
	public static String LOREM_IPSUM = "In publishing and graphic design, lorem ipsum is a placeholder text commonly used to "
			+ "demonstrate the graphic elements of a document or visual presentation. By replacing the distraction of meaningful "
			+ "content with filler text of scrambled Latin it allows viewers to focus on graphical elements such as font, typography, and layout";
	/*
			"The lorem ipsum text is typically a mangled section of De finibus bonorum et malorum, a 1st-century BC Latin text by Cicero, with words "
			+ "altered, added, and removed that make it nonsensical, improper Latin" + 
			"A variation of the common lorem ipsum text has been used during typesetting since the 1960s or "
			+ "earlier, when it was popularized by advertisements for Letraset transfer sheets. It was introduced "
			+ "to the Digital Age by Aldus Corporation in the mid-1980s, which employed it in graphics and word processing templates "
			+ "for its breakthrough desktop publishing program, PageMaker for the Apple Macintosh"; 
*/
	public static ArrayList<Student> createStudents() {
		ArrayList<Student> retval = new ArrayList<>();
		String[] strs = LOREM_IPSUM.split("\\s");
		// create loop
		for (int i = 0; i < strs.length; i++) {
			Student student = new Student();
			
			student.setFirstName(strs[i].toUpperCase());
			student.setLastName(new StringBuilder(strs[i]).reverse().toString());
			retval.add(student);
		}
		return retval;
	}
	
	public static void createMappingOfStudentsToTeachers(ArrayList<Teacher> teachers, ArrayList<Student> students) {
		int teacherSize = teachers.size();
		int studentSize = students.size();
		
		for (int i = 0; i < teacherSize; i++) {
			Teacher teacher = teachers.get(i);
			for (int y = 0; y < 5; y++) {
				Random rand = new Random();
				int randIndexOfStudent = rand.nextInt(studentSize);
				if (teacher.getStudents() == null) {
					teacher.setStudents(new ArrayList<Student>());
				}
				teacher.getStudents().add(students.get(randIndexOfStudent));
			}
		}
		
	}

}
