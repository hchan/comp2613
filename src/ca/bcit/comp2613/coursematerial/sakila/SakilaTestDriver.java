package ca.bcit.comp2613.coursematerial.sakila;


import java.util.Iterator;

import javax.persistence.EntityManager;
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
		ActorRepository actorRepository = context.getBean(ActorRepository.class);
		
		Iterator iter = actorRepository.findAll().iterator();
		
		while (iter.hasNext()) {
			Actor actor = (Actor) iter.next();
			System.out.println(actor.getFirstName());
		}
		
		
		
		
		
		// not that the line below will break ... yeah repositories have problems. 
		// System.out.println(actor.getFilmActors().iterator().next().getFilm().getTitle());
		// soln is to doEmfQuery below
		//doEmfQuery(context);
		context.close();
		
	}

	private static void doEmfQuery(ConfigurableApplicationContext context) {
		EntityManagerFactory emf = (EntityManagerFactory) context.getBean("entityManagerFactory");
		EntityManager em = emf.createEntityManager();

		Actor actor = em.find(Actor.class, Short.parseShort("1"));
		System.out.println(actor.getFirstName());
		System.out.println(actor.getFilmActors().iterator().next().getFilm().getTitle());
	}
}
