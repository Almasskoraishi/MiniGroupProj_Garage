/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 12, 2022
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;
import model.Vehicle;

/** @author Elijah Edlund */
public class VehicleHelper {
	static EntityManagerFactory emfac = Persistence.createEntityManagerFactory("MiniGroupProj_Garage");

	// insert a vehicle
	public void insertVehicle(Vehicle v) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}

	// show all
	public List<Vehicle> showAllVehicles() {
		EntityManager em = emfac.createEntityManager();
		List<Vehicle> allVehicles = em.createQuery("SELECT i FROM Vehicle i").getResultList();
		return allVehicles;
	}

	// delete a vehicle
	public void deleteItem(Vehicle toDelete) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Vehicle> typedQ = em.createQuery(
				"SELECT v FROM Vehicle v WHERE v.ownerName = :selectedOwnerName and v.makeModelYear = :selectedMakeModelYear and v.plateNum = :selectedPlateNum",
				Vehicle.class);
		typedQ.setParameter("selectedOwnerName", toDelete.getOwnerName());
		typedQ.setParameter("selectedMakeModelYear", toDelete.getMakeModelYear());
		typedQ.setParameter("selectedPlateNum", toDelete.getPlateNum());
		typedQ.setMaxResults(1);
		Vehicle result = typedQ.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	// search for vehicle by plate num
	public Vehicle searchForVehicleByPlateNum(String plateNum) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		Vehicle found = em.find(Vehicle.class, plateNum);
		em.close();
		return found;
	}

	// update
	public void updateVehicle(Vehicle toEdit) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	// search by owner
	public List<Vehicle> searchForVehicleByOwner(String ownerName) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Vehicle> typedQ = em.createQuery("SELECT v FROM Vehicle v WHERE v.ownerName = :selectedOwnerName",
				Vehicle.class);
		typedQ.setParameter("selectedOwnerName", ownerName);
		List<Vehicle> found = typedQ.getResultList();
		em.close();
		return found;
	}

	public void cleanUp() {
		emfac.close();
	}

}
