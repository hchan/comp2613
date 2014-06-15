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

	public List<Character> mysteriousQuery() {
		List<Character> retval = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em
					.createNativeQuery(
							" select * from character",
									Character.class);
			//query.setParameter("teacher_id", teacherId);
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
