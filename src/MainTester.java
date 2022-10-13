import java.util.List;
import controller.GarageListHelper;
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
		GarageListHelper gh = new GarageListHelper();

		// Make owner
		Owner owner = new Owner("Eli");

		// Make vehicle
		// Important !!! plate number is the primary key so you cannot have duplicate entries for the plate num
		Vehicle veh = new Vehicle(owner.getName(), "Ford Focus 2007", "ABC-123");
		Vehicle veh2 = new Vehicle(owner.getName(), "Ford Focus 2008", "ABC-124");

		// insert vehicle to database
		vh.insertVehicle(veh);
		vh.insertVehicle(veh2);
		
		GarageList garage = new GarageList("Eli's Garage", owner);
		garage.setVehicles(vh.showAllVehicles());
		gh.insertNewGarageList(garage);
		

		System.out.println("print vehicles from database (colored text)");
		List<Vehicle> vehs = vh.showAllVehicles();
		for (Vehicle v : vehs) {
			System.err.println(v.toString());
		}

		System.out.println("print owners (colored text)");
		List<Owner> owners = oh.showAllOwners();
		for (Owner o : owners) {
			System.err.println(o.toString());
		}
		System.out.println("Print garage lists (colored text)");
		List<GarageList> garages = gh.getGarages();
		for (GarageList gl : garages) {
			System.err.println(gl.toString());
		}
	}
}