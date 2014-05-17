package ca.bcit.comp2613.coursematerial.day09;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import ca.bcit.comp2613.coursematerial.day09.model.Teacher;
import ca.bcit.comp2613.coursematerial.day09.repository.TeacherRepository;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class TestDriverWithMySQLDB {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestDriverWithMySQLDB.class); 
		
		TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
		
		Teacher teacher = new Teacher();
		teacher.setId("a00788076");		
		teacher.setFirstName("HENRY");
		teacher.setLastName("Chan");
		teacherRepository.save(teacher); // note that the orphans aren't removed
		
		context.close();
		
	}
}
