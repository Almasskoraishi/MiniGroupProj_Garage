/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 10, 2022
 */
package model;

/** @author Elijah Edlund */
// Class for vehicles 
// Simplified class to not need multiple objects for different vehicles and to just use vehicle instead
public class Vehicle {
	private Owner owner; // ID of owner creating the vehicle
	private String makeModelYear; // ex: Ford Focus 2004
	private String plateNum; // License plate ex: R35457

	public Vehicle() {
		super();
	}

	public Vehicle(Owner ownerID, String makeModelYear, String plateNum) {
		super();
		this.owner = ownerID;
		this.makeModelYear = makeModelYear;
		this.plateNum = plateNum;
	}

	public Owner getOwnerID() {
		return owner;
	}

	public void setOwnerID(Owner ownerID) {
		this.owner = ownerID;
	}

	public String getMakeModelYear() {
		return makeModelYear;
	}

	public void setMakeModelYear(String makeModelYear) {
		this.makeModelYear = makeModelYear;
	}

	public String getPlateNum() {
		return plateNum;
	}

	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}

	@Override
	public String toString() {
		return "Vehicle [ownerID=" + owner.toString() + ", makeModelYear=" + makeModelYear + ", plateNum=" + plateNum + "]";
	}

}
