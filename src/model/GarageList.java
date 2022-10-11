/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 11, 2022
 */
package model;

import java.util.List;

/** @author Elijah Edlund */
public class GarageList {
	private int ID;
	private String garageName;
	private Owner garageOwner;
	private List<Vehicle> vehicles;

	public GarageList() {
		super();
	}

	public GarageList(int ID, String garageName, Owner garageOwner, List<Vehicle> vehicles) {
		super();
		this.ID = ID;
		this.garageName = garageName;
		this.garageOwner = garageOwner;
		this.vehicles = vehicles;
	}

	public GarageList(String garageName, Owner garageOwner, List<Vehicle> vehicles) {
		super();
		this.garageName = garageName;
		this.garageOwner = garageOwner;
		this.vehicles = vehicles;
	}

	public GarageList(String garageName, Owner garageOwner) {
		super();
		this.garageName = garageName;
		this.garageOwner = garageOwner;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getGarageName() {
		return garageName;
	}

	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	public Owner getGarageOwner() {
		return garageOwner;
	}

	public void setGarageOwner(Owner garageOwner) {
		this.garageOwner = garageOwner;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "garageList [ID=" + ID + ", garageName=" + garageName + ", garageOwner=" + garageOwner.toString() + ", vehicles="
				+ vehicles.toString() + "]";
	}

}
