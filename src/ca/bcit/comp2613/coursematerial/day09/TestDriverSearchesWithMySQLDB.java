package ca.bcit.comp2613.coursematerial.day09;


import java.util.ArrayList;
import java.util.List;

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
public class TestDriverSearchesWithMySQLDB {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestDriverSearchesWithMySQLDB.class); 
		
		TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		
	Teacher teacher = teacherRepository.findOne("0");
	
	List<Student> studentsOfFirstTeacher = teacher.getStudents();
		for (Student student: studentsOfFirstTeacher) {
			System.out.println(student);
		}
		context.close();
		
	}
}
