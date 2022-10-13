import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import controller.OwnerHelper;
import controller.VehicleHelper;
import model.GarageList;
import model.Owner;
import model.Vehicle;

/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 10, 2022
 */

/** @author Elijah Edlund */
public class MainTester {
	public static void main(String[] args) {

		// Vehicle database testing
		VehicleHelper vh = new VehicleHelper();
		OwnerHelper oh = new OwnerHelper();

		// Make owner
		Owner owner = new Owner();
		owner.setName("Eli");
		oh.insertOwner(owner);

		// Make vehicle
		Vehicle veh = new Vehicle(owner.getName(), "Ford Focus 2007", "ABC-123");

		// insert vehicle to database
		vh.insertVehicle(veh);

		// print vehicles from database (colored text)
		List<Vehicle> vehs = vh.showAllVehicles();
		for (Vehicle v : vehs) {
			System.err.println(v.toString());
		}

		// print owners (colored text)
		List<Owner> owners = oh.showAllOwners();
		for (Owner o : owners) {
			System.err.println(o.toString());
		}
	}
}