// -------------------------------------------------------
// Assignment 4
// Written by: Brandon Tam 40100539
// For COMP 248 Section U – Winter 2021
// --------------------------------------------------------
//
// This Class is the components of the creatures in the game.
//

import java.lang.Math;
import java.util.Date;

public class Creature {

	// Data Members
	private static final int FOOD2HEALTH = 6;
	private static final int HEALTH2POWER = 4;

	private static int numStillAlive = 0;

	private String name;
	private int foodUnits;
	private int healthUnits;
	private int firePowerUnits;
	private Date dateCreated;
	private Date dateDied;

	// Constructor
	public Creature(String name) {
		setName(name);

		setFoodUnits((int) (Math.random() * 11 + 1));
		setHealthUnits((int) (Math.random() * 6 + 1));

		this.firePowerUnits = (int) (Math.random() * 10);
		this.dateCreated = new Date();
		this.dateDied = null;

		numStillAlive += 1;
	}

	// Methods
	// Get Private Variables
	public String getName() {
		return name;
	}

	public int getFoodUnits() {
		return foodUnits;
	}

	public int getHealthUnits() {
		return healthUnits;
	}

	public int getFirePowerUnits() {
		return firePowerUnits;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateDied() {
		return dateDied;
	}

	public static int getNumStillAlive() {
		return numStillAlive;
	}

	// Set Variables
	public void setName(String newName) {
		this.name = newName;
	}

	public void setFoodUnits(int n) {
		this.foodUnits = n;
	}

	public void setHealthUnits(int n) {
		this.healthUnits = n;
	}

	public void reduceFirePowerUnits(int n) {
		this.firePowerUnits = this.firePowerUnits - n;
	}

	// Playable actions
	public int earnFood() {
		int randFood = (int) (Math.random() * 16);
		setFoodUnits(this.foodUnits + randFood);
		normalizeUnits();

		return randFood;
	}

	public void attacking(Creature player) {
		reduceFirePowerUnits(2);

		int stealFood = (int) Math.ceil((double) player.getFoodUnits() / (double) 2);
		int stealHealth = (int) Math.ceil((double) player.getHealthUnits() / (double) 2);

		setFoodUnits(this.foodUnits + stealFood);
		setHealthUnits(this.healthUnits + stealHealth);

		normalizeUnits();

		player.setFoodUnits(player.getFoodUnits() - stealFood);
		player.setHealthUnits(player.getHealthUnits() - stealHealth);

		player.healthFoodUnitsZero();
	}

	// Information strings
	public String toString() {
		String description = "Name: " + getName() + " Food Units: " + getFoodUnits() + " Health Units: "
				+ getHealthUnits() + " Fire Power Units: " + getFirePowerUnits() + " Date Created: " + getDateCreated()
				+ " Date Died: " + getDateDied();

		return description;

	}

	public String showStatus() {
		String status = getFoodUnits() + " food units, " + getHealthUnits() + " health units, " + getFirePowerUnits()
				+ " fire power units.";

		return status;
	}

	// Other
	private void died() {
		this.dateDied = new Date();
		numStillAlive -= 1;
	}

	public boolean isAlive() {
		if (dateDied == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean healthFoodUnitsZero() {
		if (this.healthUnits == 0 && this.foodUnits == 0) {
			if (getDateDied() == null) {
				died();
			}
			return true;
		} else {
			return false;
		}
	}

	public void normalizeUnits() {
		int ratio = (int) (getFoodUnits() / FOOD2HEALTH);
		setFoodUnits(getFoodUnits() - ratio * FOOD2HEALTH);
		setHealthUnits(getHealthUnits() + ratio);

		int ratio2;
		if (getHealthUnits() % HEALTH2POWER == 0) {
			ratio2 = (int) (getHealthUnits() / HEALTH2POWER) - 1;
		} else {
			ratio2 = (int) (getHealthUnits() / HEALTH2POWER);
		}

		setHealthUnits(getHealthUnits() - ratio2 * HEALTH2POWER);
		this.firePowerUnits = getFirePowerUnits() + ratio2;
	}

}
