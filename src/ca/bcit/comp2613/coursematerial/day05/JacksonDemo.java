/**
 * May 12, 2014
 */
package ca.bcit.comp2613.coursematerial.day05;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import ca.bcit.comp2613.coursematerial.day02.model.Teacher;
import ca.bcit.comp2613.coursematerial.day05.util.TeacherUtil;

/**
 * @author Henry
 *
 */
public class JacksonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Teacher> teachers = TeacherUtil.create100RandomTeachers();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			objectMapper.writeValue(baos, teachers);
			String teachersAsJSONString = baos.toString();
			System.out.println(teachersAsJSONString);
			
			ArrayList<Teacher> teachersCopy = objectMapper.readValue(teachersAsJSONString, new TypeReference<ArrayList<Teacher>>(){});
			
			int randomIndex = 5;
			System.out.println(teachersCopy.get(randomIndex).getFirstName());
			System.out.println(teachers.get(randomIndex).getFirstName());
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
