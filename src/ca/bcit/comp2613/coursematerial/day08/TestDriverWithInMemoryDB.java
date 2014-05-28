package ca.bcit.comp2613.coursematerial.day08;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import ca.bcit.comp2613.coursematerial.day08.model.Teacher;
import ca.bcit.comp2613.coursematerial.day08.repository.TeacherRepository;

@EnableAutoConfiguration
public class TestDriverWithInMemoryDB {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestDriverWithInMemoryDB.class); 
		
		TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
		
		Teacher teacher = new Teacher();
		teacher.setId("a00788076");		
		teacher.setFirstName("HENRY");
		teacher.setLastName("Chan");
		teacherRepository.save(teacher); 
		
		context.close();
		
	}
}
