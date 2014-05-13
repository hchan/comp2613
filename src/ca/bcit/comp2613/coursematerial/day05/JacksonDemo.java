/**
 * May 12, 2014
 */
package ca.bcit.comp2613.coursematerial.day05;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import ca.bcit.comp2613.coursematerial.day05.model.Teacher;

/**
 * @author Henry
 *
 */
public class JacksonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Teacher> teachers = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			String firstName = UUID.randomUUID().toString();
			String lastName = UUID.randomUUID().toString();
			Teacher teacher = new Teacher (Integer.toString(i), firstName, lastName);
			teachers.add(teacher);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			objectMapper.writeValue(baos, teachers);
			System.out.println(baos.toString());
			
			ArrayList<Teacher> teachersCopy = objectMapper.readValue(baos.toString(), new TypeReference<ArrayList<Teacher>>(){});
			
			int randomIndex = 5;
			System.out.println(teachersCopy.get(randomIndex).getFirstName());
			System.out.println(teachers.get(randomIndex).getFirstName());
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
