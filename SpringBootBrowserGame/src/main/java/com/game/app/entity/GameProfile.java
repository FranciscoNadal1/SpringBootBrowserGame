package com.game.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

@Entity
@Transactional
public class GameProfile {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Resources

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "game_profile", updatable = false, nullable = false)
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

	public GameProfile() {
		this.wood = 0;
		this.rock = 0;
		this.steel = 0;
		this.food = 0;

		this.woodGrowthRate = 50;
		this.rockGrowthRate = 20;
		this.steelGrowthRate = 5;
		this.foodGrowthRate = 10;
	}
	
	public GameProfile(User user) {
		this.wood = 0;
		this.rock = 0;
		this.steel = 0;
		this.food = 0;

		this.woodGrowthRate = 50;
		this.rockGrowthRate = 20;
		this.steelGrowthRate = 5;
		this.foodGrowthRate = 10;
		
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

	//////////////////////////////////////////////////

	public int getId() {
		return id;
	}
	//////////////////////////////////////////////////

	public double getWoodGrowthRate() {
		return woodGrowthRate;
	}

	public void setWoodGrowthRate(int woodGrowthRate) {
		this.woodGrowthRate = woodGrowthRate;
	}

	public double getRockGrowthRate() {
		return rockGrowthRate;
	}

	public void setRockGrowthRate(int rockGrowthRate) {
		this.rockGrowthRate = rockGrowthRate;
	}

	public double getSteelGrowthRate() {
		return steelGrowthRate;
	}

	public void setSteelGrowthRate(int steelGrowthRate) {
		this.steelGrowthRate = steelGrowthRate;
	}

	public double getFoodGrowthRate() {
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
		this.wood += this.woodGrowthRate;
		this.steel += this.steelGrowthRate;
		this.rock += this.rockGrowthRate;
		this.food += this.foodGrowthRate;
	}

}
