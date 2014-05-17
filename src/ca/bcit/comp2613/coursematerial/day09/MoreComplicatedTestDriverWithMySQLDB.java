package ca.bcit.comp2613.coursematerial.day09;


import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import ca.bcit.comp2613.coursematerial.day09.model.Student;
import ca.bcit.comp2613.coursematerial.day09.model.Teacher;
import ca.bcit.comp2613.coursematerial.day09.repository.StudentRepository;
import ca.bcit.comp2613.coursematerial.day09.repository.TeacherRepository;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class MoreComplicatedTestDriverWithMySQLDB {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MoreComplicatedTestDriverWithMySQLDB.class); 
		
		TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		
		Teacher teacher = new Teacher();
		teacher.setId("a00788076");		
		teacher.setFirstName("HENRY");
		teacher.setLastName("Chan");
		Teacher teacherHenry = teacherRepository.save(teacher); 
		
		teacher.setId("a00888888");		
		teacher.setFirstName("Paul");
		teacher.setLastName("Mills");
		teacherRepository.save(teacher);
		
		teacher.setId("a00999999");		
		teacher.setFirstName("SAM");
		teacher.setLastName("Circa");
		teacherRepository.save(teacher); 
		
		for (int i = 0; i < 10; i++) {
			Student student = new Student();
			student.setFirstName(UUID.randomUUID().toString());
			student.setLastName(UUID.randomUUID().toString());
			student.setTeacherId(teacherHenry.getId());
			studentRepository.save(student);
		}
		
		
		// accessor student
		Student fifthStudent = studentRepository.findOne(5L);
		System.out.println(fifthStudent);
		Student sixthStudent = studentRepository.findOne(6L);
		if (sixthStudent != null) {
			studentRepository.delete(sixthStudent);
		}
		
		// accessor teacher
		List<Teacher> teachers = teacherRepository.findByLastName("Chan");
		System.out.println(teachers.get(0).getFirstName());
		context.close();
		
	}
}
