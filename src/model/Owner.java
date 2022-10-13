/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 10, 2022
 */
package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** @author Elijah Edlund */
// Class for the owner of the vehicles
@Entity
@Table(name = "owner")
public class Owner {
	@Id
	@GeneratedValue
	private int ID;
	private String name;

	public Owner() {
		super();
	}

	public Owner(String name) {
		super();
		this.name = name;
	}

	public Owner(int ID, String name) {
		super();
		this.ID = ID;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Owner [ID=" + ID + ", name=" + name + "]";
	}

}