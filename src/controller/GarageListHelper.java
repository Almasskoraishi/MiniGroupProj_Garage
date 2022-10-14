/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 13, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GarageList;

/** @author Elijah Edlund */
public class GarageListHelper {
	static EntityManagerFactory emfac = Persistence.createEntityManagerFactory("MiniGroupProj_Garage");

	// insert a new garage list
	public void insertNewGarageList(GarageList g) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}

	// view all garage lists
	public List<GarageList> getGarages() {
		EntityManager em = emfac.createEntityManager();
		List<GarageList> allGarages = em.createQuery("SELECT g FROM GarageList g").getResultList();
		return allGarages;
	}

	// delete a garage list
	public void deleteGarage(GarageList toDel) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		// sql
		TypedQuery<GarageList> typedQ = em.createQuery("SELECT g FROM GarageList g WHERE g.ID = :selectedId",
				GarageList.class);
		// use id
		typedQ.setParameter("selectedId", toDel.getID());
		typedQ.setMaxResults(1);
		// save result
		GarageList result = typedQ.getSingleResult();
		// delete
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	// search for garage list by id
	public GarageList searchForListDetailsById(Integer tempId) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		GarageList found = em.find(GarageList.class, tempId);
		em.close();
		return found;
	}
	
	// update garage list
	public void updateList(GarageList toEdit) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
