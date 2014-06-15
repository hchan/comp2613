package ca.bcit.comp2613.coursematerial.fth;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class CustomQueryHelper {
	private EntityManagerFactory emf;

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public CustomQueryHelper(EntityManagerFactory emf) {
		this.emf = emf;
	}

	// report - I want the color of my query report to be ... green (hint as in the
	// color of
	// his skin
	// http://wowpedia.org/File:Grom_Glowei_Cropped.jpg?version=a9ab91e8ee037e2a547ee570eb42a117
	// )
	public List<Character> mysteriousQuery() {
		List<Character> retval = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em.createNativeQuery(
					" select * from character where race=5", Character.class);
			// query.setParameter("teacher_id", teacherId);
			retval = query.getResultList();
		} catch (Exception e) {

		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
		}
		return retval;
	}

}
