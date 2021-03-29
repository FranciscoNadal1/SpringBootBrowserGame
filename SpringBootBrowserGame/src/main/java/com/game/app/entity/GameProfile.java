package com.game.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

@Entity
@Transactional
public class GameProfile implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	

	
	
	/*
	 * @Column(nullable = true) Map<String, Building> constructedBuildings;
	 */
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(referencedColumnName = "id") List<Kingdom> kingdomList;
	 */

	// Resources
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "game_profile", updatable = false, nullable = true)
	 * private User user;
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	private int wood;
	private int rock;
	private int steel;
	private int food;

	//////////////////

	private int woodGrowthRate;
	private int rockGrowthRate;
	private int steelGrowthRate;
	private int foodGrowthRate;

	/////////////////

	private int maxWoodStored;
	private int maxRockStored;
	private int maxSteelStored;
	private int maxFoodStored;

	////////////////

	public GameProfile() {
		this.wood = 0;
		this.rock = 0;
		this.steel = 0;
		this.food = 0;
/*
		this.woodGrowthRate = 50;
		this.rockGrowthRate = 20;
		this.steelGrowthRate = 5;
		this.foodGrowthRate = 10;
*/
// HACKS
		this.woodGrowthRate = 50;
		this.rockGrowthRate = 20;
		this.steelGrowthRate = 5;
		this.foodGrowthRate = 10;
////////
		
		this.maxWoodStored = 10000;
		this.maxRockStored = 5000;
		this.maxSteelStored = 2000;
		this.maxFoodStored = 500;

	}

	public GameProfile(User user) {
		this();
		this.user = user;
	}

	///////////////////////
	public int getWood() {
		return wood;
	}

///////////////////////////////////////////////
	
	
	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getRock() {
		return rock;
	}

	public void setRock(int rock) {
		this.rock = rock;
	}

	public int getSteel() {
		return steel;
	}

	public void setSteel(int steel) {
		this.steel = steel;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getMaxWoodStored() {
		return maxWoodStored;
	}

	public void setMaxWoodStored(int maxWoodStored) {
		this.maxWoodStored = maxWoodStored;
	}

	public int getMaxRockStored() {
		return maxRockStored;
	}

	public void setMaxRockStored(int maxRockStored) {
		this.maxRockStored = maxRockStored;
	}

	public int getMaxSteelStored() {
		return maxSteelStored;
	}

	public void setMaxSteelStored(int maxSteelStored) {
		this.maxSteelStored = maxSteelStored;
	}

	public int getMaxFoodStored() {
		return maxFoodStored;
	}

	public void setMaxFoodStored(int maxFoodlStored) {
		this.maxFoodStored = maxFoodlStored;
	}

	//////////////////////////////////////////////////
	/*
	 * public List<Kingdom> getKingdomList() { return kingdomList; }
	 * 
	 * public void setKingdomList(List<Kingdom> kingdomList) { this.kingdomList =
	 * kingdomList; }
	 */
	public int getId() {
		return id;
	}
	//////////////////////////////////////////////////

	public int getWoodGrowthRate() {
		return woodGrowthRate;
	}

	public void setWoodGrowthRate(int woodGrowthRate) {
		this.woodGrowthRate = woodGrowthRate;
	}

	public int getRockGrowthRate() {
		return rockGrowthRate;
	}

	public void setRockGrowthRate(int rockGrowthRate) {
		this.rockGrowthRate = rockGrowthRate;
	}

	public int getSteelGrowthRate() {
		return steelGrowthRate;
	}

	public void setSteelGrowthRate(int steelGrowthRate) {
		this.steelGrowthRate = steelGrowthRate;
	}

	public int getFoodGrowthRate() {
		return foodGrowthRate;
	}

	public void setFoodGrowthRate(int foodGrowthRate) {
		this.foodGrowthRate = foodGrowthRate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	///////////////////////////////

	public void resourcesGrow() {	

		this.wood 		= 	fillResourceUntilMax(	this.getWood(), 		this.getWoodGrowthRate(), 	this.getMaxWoodStored());
		this.steel 		= 	fillResourceUntilMax(	this.getSteel(), 		this.getSteelGrowthRate(), 	this.getMaxSteelStored());
		this.rock 		= 	fillResourceUntilMax(	this.getRock(), 		this.getRockGrowthRate(), 	this.getMaxRockStored());
		this.food 		= 	fillResourceUntilMax(	this.getFood(), 		this.getFoodGrowthRate(), 	this.getMaxFoodStored());
		
	}
	
	public int fillResourceUntilMax(int resource, int growthRate, int maxStorage) {
		
		int resourceAfter 	= 	resource 	+ 	growthRate;
		
		if(resourceAfter > maxStorage) {
			resource = maxStorage;
		}else if(resourceAfter == maxStorage) {
			resource = maxStorage;
		}else {
			resource += growthRate;
		}
		
		return resource;
	}

}
