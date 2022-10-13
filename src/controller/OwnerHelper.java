/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 13, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

/** @author Elijah Edlund */
public class OwnerHelper {
	static EntityManagerFactory emfac = Persistence.createEntityManagerFactory("MiniGroupProj_Garage");

	// insert owner
	public void insertOwner(Owner o) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

	// return list of all owners
	public List<Owner> showAllOwners() {
		EntityManager em = emfac.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT o FROM Owner o").getResultList();
		return allOwners;
	}

	// try to return owner with matching name
	public Owner findOwner(String nameToLookup) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQ = em.createQuery("SELECT o FROM Owner o WHERE o.ownerName = :selectedName",
				Owner.class);
		typedQ.setParameter("selectedName", nameToLookup);
		typedQ.setMaxResults(1);
		Owner foundOwner;
		try {
			foundOwner = typedQ.getSingleResult();
		} catch (NoResultException e) {
			foundOwner = new Owner(nameToLookup);
		}
		em.close();
		return foundOwner;
	}

}
