package com.game.app.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;


@Entity
public class Kingdom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String kingdomName;
	
	private boolean isMainHomeland;
	
	@ManyToOne
	@JoinColumn(name = "gameProfile_id", referencedColumnName = "id")	
	private GameProfile gameProfile;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "kingdom_id", referencedColumnName = "id")
//	@MapKeyJoinColumn(name="name")
	@MapKey(name = "name")
	private Map<String, Building> buildings;
	
	private int wood;
	private int rock;
	private int steel;
	private int food;

	//////////////////

	private int baseWoodGrowthRate;
	private int baseRockGrowthRate;
	private int baseSteelGrowthRate;
	private int baseFoodGrowthRate;
	

	private int totalWoodGrowthRate;
	private int totalRockGrowthRate;
	private int totalSteelGrowthRate;
	private int totalFoodGrowthRate;

	/////////////////

	private int maxWoodStored;
	private int maxRockStored;
	private int maxSteelStored;
	private int maxFoodStored;

	////////////////
/*	
	@OneToMany
	@JoinColumn(name = "kingdom_id", referencedColumnName = "id")	
//	private Map<String,Building> buildings;
	private List<Building> buildings;
*/	
	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "building_id", referencedColumnName = "id")
	private List<Building> buildings;
	*/
	Kingdom(){
		this.kingdomName = "Kingdom";
		this.isMainHomeland = true;
		
		this.baseWoodGrowthRate = 50;
		this.baseRockGrowthRate = 20;
		this.baseSteelGrowthRate = 5;
		this.baseFoodGrowthRate = 10;
////////
		
		this.maxWoodStored = 10000;
		this.maxRockStored = 5000;
		this.maxSteelStored = 2000;
		this.maxFoodStored = 500;
	}
	
	Kingdom(User user){		
		kingdomName = user.getUsername() + "'s kingdom";
		
		this.baseWoodGrowthRate = 50;
		this.baseRockGrowthRate = 20;
		this.baseSteelGrowthRate = 5;
		this.baseFoodGrowthRate = 10;
////////
		
		this.maxWoodStored = 10000;
		this.maxRockStored = 5000;
		this.maxSteelStored = 2000;
		this.maxFoodStored = 500;
	}
	
	public Kingdom(String user){		
		kingdomName = user + "'s kingdom";
		
		
		this.baseWoodGrowthRate = 500;
		this.baseRockGrowthRate = 200;
		this.baseSteelGrowthRate = 50;
		this.baseFoodGrowthRate = 100;
////////
		
		this.maxWoodStored = 10000;
		this.maxRockStored = 5000;
		this.maxSteelStored = 2000;
		this.maxFoodStored = 500;

//		Building newBuilding = new Farm();
//		 new Farm().setKingdom(this);
		
//		this.buildings.put("Farm", new Farm());

	}
	////////////////////////////////

	
	public String getKingdomName() {
		return kingdomName;
	}
	public Map<String,Building> getBuildings() {
		return buildings;
	}

	public void setBuilding(Map<String,Building> building) {
		this.buildings = building;
	}
	
/*
	public Map<String, Building> getBuildings() {
		return buildings;
	}

	public void setBuilding(Map<String, Building> building) {
		this.buildings = building;
	}
*/
	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
	}

	public boolean isMainHomeland() {
		return isMainHomeland;
	}

	public void setMainHomeland(boolean isMainHomeland) {
		this.isMainHomeland = isMainHomeland;
	}

	public GameProfile getGameProfile() {
		return gameProfile;
	}

	public void setGameProfile(GameProfile gameProfile) {
		this.gameProfile = gameProfile;
	}

	public int getId() {
		return id;
	}
	
	///////////////////////////////////////////////////////////////
	

	public int getWood() {
		return wood;
	}

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

	public int getWoodGrowthRate() {
		return baseWoodGrowthRate;
	}

	public void setWoodGrowthRate(int woodGrowthRate) {
		this.baseWoodGrowthRate = woodGrowthRate;
	}

	public int getRockGrowthRate() {
		return baseRockGrowthRate;
	}

	public void setRockGrowthRate(int rockGrowthRate) {
		this.baseRockGrowthRate = rockGrowthRate;
	}

	public int getSteelGrowthRate() {
		return baseSteelGrowthRate;
	}

	public void setSteelGrowthRate(int steelGrowthRate) {
		this.baseSteelGrowthRate = steelGrowthRate;
	}

	public int getFoodGrowthRate() {
		return baseFoodGrowthRate;
	}

	public void setFoodGrowthRate(int foodGrowthRate) {
		this.baseFoodGrowthRate = foodGrowthRate;
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

	public void setMaxFoodStored(int maxFoodStored) {
		this.maxFoodStored = maxFoodStored;
	}

	
	
	////////////////////////////////////////////////////////////////

	public int getTotalWoodGrowthRate() {
		return totalWoodGrowthRate;
	}

	public void setTotalWoodGrowthRate(int totalWoodGrowthRate) {
		this.totalWoodGrowthRate = totalWoodGrowthRate;
	}

	public int getTotalRockGrowthRate() {
		return totalRockGrowthRate;
	}

	public void setTotalRockGrowthRate(int totalRockGrowthRate) {
		this.totalRockGrowthRate = totalRockGrowthRate;
	}

	public int getTotalSteelGrowthRate() {
		return totalSteelGrowthRate;
	}

	public void setTotalSteelGrowthRate(int totalSteelGrowthRate) {
		this.totalSteelGrowthRate = totalSteelGrowthRate;
	}

	public int getTotalFoodGrowthRate() {
		return totalFoodGrowthRate;
	}

	public void setTotalFoodGrowthRate(int totalFoodGrowthRate) {
		this.totalFoodGrowthRate = totalFoodGrowthRate;
	}

	public void resourcesGrow() {	
		
		//Farm farm = (Farm) this.buildings.get("Farm");
		
		/*
		Building sawmill = buildings.get("Sawmill");
		Building quarry = buildings.get("Quarry");
		Building forge = buildings.get("Forge");
		
		*/
		this.totalFoodGrowthRate 	=	this.getWoodGrowthRate() + this.buildings.get("Farm").getProduction();
		System.out.println(this.buildings.get("Farm").getProduction());
		System.out.println(totalFoodGrowthRate);
		this.totalRockGrowthRate 	=	this.getWoodGrowthRate() + this.buildings.get("Quarry").getProduction();
		this.totalSteelGrowthRate 	=	this.getWoodGrowthRate() + this.buildings.get("Forge").getProduction();
		this.totalWoodGrowthRate 	=	this.getWoodGrowthRate() + this.buildings.get("Sawmill").getProduction();

		this.wood 		= 	fillResourceUntilMax(	this.getWood(), 		this.totalWoodGrowthRate, 	this.getMaxWoodStored());
		this.steel 		= 	fillResourceUntilMax(	this.getSteel(), 		this.totalSteelGrowthRate, 	this.getMaxSteelStored());
		this.rock 		= 	fillResourceUntilMax(	this.getRock(), 		this.totalRockGrowthRate, 	this.getMaxRockStored());
		this.food 		= 	fillResourceUntilMax(	this.getFood(), 		this.totalFoodGrowthRate, 	this.getMaxFoodStored());
		
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
