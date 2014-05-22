package ca.bcit.comp2613.coursematerial.day09;


import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import ca.bcit.comp2613.coursematerial.day09.util.StudentUtil;
import ca.bcit.comp2613.coursematerial.day09.model.Student;
import ca.bcit.comp2613.coursematerial.day09.model.Teacher;
import ca.bcit.comp2613.coursematerial.day09.repository.StudentRepository;
import ca.bcit.comp2613.coursematerial.day09.repository.TeacherRepository;
import ca.bcit.comp2613.coursematerial.day09.util.TeacherUtil;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class TestDriverInsertsWithMySQLDB {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestDriverInsertsWithMySQLDB.class); 
		
		TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		ArrayList<Teacher> teachers = TeacherUtil.createTeachers();
	
		teacherRepository. save(teachers);
		
		
		ArrayList<Student> students = StudentUtil.createStudents();
		studentRepository.save(students);
		StudentUtil.createMappingOfStudentsToTeachers(teachers, students);
		teacherRepository.save(teachers);
		
		Teacher teacher = (Teacher) teacherRepository.findByLastName("nI").get(0);
		teacher.setFirstName("Henry");
		teacher.setLastName("Chan");
		teacherRepository.save(teacher);
		context.close();
		
	}
}
