import java.util.ArrayList;
import java.util.List;

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
		// testing basic logic
		// The idea here would be you create an owner
		Owner owner1 = new Owner();
		owner1.setID(1);
		owner1.setName("Eli Edlund");
		// Then you create the vehicles you want in your garage
		Vehicle car1 = new Vehicle(owner1, "Ford Focus 2007", "ABC-123");
		Vehicle car2 = new Vehicle(owner1, "Ford Focus 2008", "ABC-124");
		Vehicle car3 = new Vehicle(owner1, "Ford Focus 2009", "ABC-125");
		// Add them to a list to pass to the garage
		List<Vehicle> elisVehicles = new ArrayList<Vehicle>();
		elisVehicles.add(car1);
		elisVehicles.add(car2);
		elisVehicles.add(car3);
		// create a garage with owner info and list of vehicles
		GarageList elisGarage = new GarageList(owner1.getID(), "Eli's garage", owner1, elisVehicles);
		System.out.println(elisGarage.toString());

	}

}