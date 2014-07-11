package ca.bcit.comp2613.coursematerial.day08;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import ca.bcit.comp2613.coursematerial.day08.model.Teacher;
import ca.bcit.comp2613.coursematerial.day08.repository.TeacherRepository;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class TestDriverWithMySQLDB {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestDriverWithMySQLDB.class); 
		
		TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
		
		Teacher teacher = new Teacher();
		teacher.setId("applesucks");		
		teacher.setFirstName("Apple");
		teacher.setLastName("Sucks");
		teacherRepository.save(teacher); 
		
		context.close();
		
	}
}
