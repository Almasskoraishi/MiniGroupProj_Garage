/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 10, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/** @author Elijah Edlund */
// Class for vehicles 
// Simplified class to not need multiple objects for different vehicles and to just use vehicle instead
@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue
	@Column(name = "PLATENUM")
	private String plateNum; // License plate ex: R35457
	@Column(name = "OWNERNAME")
	private String ownerName; // Owner creating the vehicle
	@Column(name = "MAKEMODELYEAR")
	private String makeModelYear; // ex: Ford Focus 2004

	public Vehicle() {
		super();
	}

	public Vehicle(String ownerName, String makeModelYear, String plateNum) {
		super();
		this.ownerName = ownerName;
		this.makeModelYear = makeModelYear;
		this.plateNum = plateNum;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerNamme(String ownerName) {
		this.ownerName = ownerName;
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
		return "Vehicle [ownerName=" + ownerName + ", makeModelYear=" + makeModelYear + ", plateNum=" + plateNum + "]";
	}

}
