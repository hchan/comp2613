package ca.bcit.comp2613.coursematerial.sakila;


import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import ca.bcit.comp2613.coursematerial.day08.model.Teacher;
import ca.bcit.comp2613.coursematerial.day08.repository.TeacherRepository;
import ca.bcit.comp2613.coursematerial.sakila.model.Actor;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class SakilaTestDriver {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SakilaTestDriver.class); 
		
		EntityManagerFactory emf = (EntityManagerFactory) context.getBean("entityManagerFactory");
		Actor actor = emf.createEntityManager().find(Actor.class, 1);
		System.out.println(actor);
		context.close();
		
	}
}
