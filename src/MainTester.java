import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

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

		// Make owner
		Owner owner = new Owner();
		owner.setName("Eli");

		// Make vehicle
		Vehicle veh = new Vehicle(owner.getName(), "Ford Focus 2007", "ABC-123");

		// insert vehicle to database
		vh.insertVehicle(veh);

		// print vehicles from database
		List<Vehicle> vehs = vh.showAllVehicles();
		for (Vehicle v : vehs) {
			System.err.println(v.toString());
		}
	}
}