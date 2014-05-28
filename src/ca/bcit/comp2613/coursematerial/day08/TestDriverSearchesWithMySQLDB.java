package ca.bcit.comp2613.coursematerial.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import ca.bcit.comp2613.coursematerial.day08.model.Student;
import ca.bcit.comp2613.coursematerial.day08.model.Teacher;
import ca.bcit.comp2613.coursematerial.day08.repository.CustomQueryHelper;
import ca.bcit.comp2613.coursematerial.day08.repository.StudentRepository;
import ca.bcit.comp2613.coursematerial.day08.repository.TeacherRepository;
import ca.bcit.comp2613.coursematerial.day08.util.StudentUtil;
import ca.bcit.comp2613.coursematerial.day08.util.TeacherUtil;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class TestDriverSearchesWithMySQLDB {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(TestDriverSearchesWithMySQLDB.class);

		TeacherRepository teacherRepository = context
				.getBean(TeacherRepository.class);
		StudentRepository studentRepository = context
				.getBean(StudentRepository.class);		
		EntityManagerFactory emf = (EntityManagerFactory) context.getBean("entityManagerFactory");
		CustomQueryHelper customQueryHelper = new CustomQueryHelper(emf);
		
		//Teacher teacher = teacherRepository.findOne("2");
		
		List<Student> studentsOfTeacher = customQueryHelper.getStudentsOfTeacher("2");
		for (Student student : studentsOfTeacher) {
			System.out.println(student);
		}
		
		customQueryHelper.addStudentToTeacher("2", 1L);
		studentsOfTeacher = customQueryHelper.getStudentsOfTeacher("2");
		for (Student student : studentsOfTeacher) {
			System.out.println(student);
		}
		
		customQueryHelper.removeStudentFromTeacher("2", 1L);
		studentsOfTeacher = customQueryHelper.getStudentsOfTeacher("2");
		for (Student student : studentsOfTeacher) {
			System.out.println(student);
		}
		context.close();

	}
}
