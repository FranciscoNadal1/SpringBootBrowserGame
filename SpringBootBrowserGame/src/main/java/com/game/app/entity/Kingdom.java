package com.game.app.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
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
	@MapKey(name = "name")
	private Map<String, Building> buildings;
	
	@ElementCollection
	private Map<String, Boolean> unlockedTroop;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "kingdom_id", referencedColumnName = "id")
	@MapKey(name = "name")
	private List<Unit> units;
	
	private int wood;
	private int rock;
	private int steel;
	private int food;

	//////////////////

	private int baseWoodGrowthRate;
	private int baseRockGrowthRate;
	private int baseSteelGrowthRate;
	private int baseFoodGrowthRate;
	

	private int extraWoodGrowthRate;
	private int extraRockGrowthRate;
	private int extraSteelGrowthRate;
	private int extraFoodGrowthRate;

	/////////////////

	private int maxWoodStored;
	private int maxRockStored;
	private int maxSteelStored;
	private int maxFoodStored;


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

	public void setMaxWoodStored(int maxWoodStored) {
		this.maxWoodStored = maxWoodStored;
	}


	public void setMaxRockStored(int maxRockStored) {
		this.maxRockStored = maxRockStored;
	}


	public void setMaxSteelStored(int maxSteelStored) {
		this.maxSteelStored = maxSteelStored;
	}


	public void setMaxFoodStored(int maxFoodStored) {
		this.maxFoodStored = maxFoodStored;
	}

	
	

	
	public void setTotalWoodGrowthRate(int totalWoodGrowthRate) {
		this.extraWoodGrowthRate = totalWoodGrowthRate;
	}

	public void setTotalRockGrowthRate(int totalRockGrowthRate) {
		this.extraRockGrowthRate = totalRockGrowthRate;
	}

	public int getTotalSteelGrowthRate() {
		return extraSteelGrowthRate;
	}

	public void setTotalSteelGrowthRate(int totalSteelGrowthRate) {
		this.extraSteelGrowthRate = totalSteelGrowthRate;
	}


	public void setTotalFoodGrowthRate(int totalFoodGrowthRate) {
		this.extraFoodGrowthRate = totalFoodGrowthRate;
	}
	
	

	public int getBaseWoodGrowthRate() {
			return baseWoodGrowthRate;
		}

	public void setBaseWoodGrowthRate(int baseWoodGrowthRate) {
		this.baseWoodGrowthRate = baseWoodGrowthRate;
	}

	public int getBaseRockGrowthRate() {
		return baseRockGrowthRate;
	}

	public void setBaseRockGrowthRate(int baseRockGrowthRate) {
		this.baseRockGrowthRate = baseRockGrowthRate;
	}

	public int getBaseSteelGrowthRate() {
		return baseSteelGrowthRate;
	}

	public void setBaseSteelGrowthRate(int baseSteelGrowthRate) {
		this.baseSteelGrowthRate = baseSteelGrowthRate;
	}

	public int getBaseFoodGrowthRate() {
		return baseFoodGrowthRate;
	}

	public void setBaseFoodGrowthRate(int baseFoodGrowthRate) {
		this.baseFoodGrowthRate = baseFoodGrowthRate;
	}

	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getExtraWoodGrowthRate() {
		return this.buildings.get("Sawmill").getProduction();
	}
	
	public int getExtraRockGrowthRate() {
		return this.buildings.get("Quarry").getProduction();
	}

	public int getExtraFoodGrowthRate() {
		return this.buildings.get("Farm").getProduction();
	}
	
	public int getExtraSteelGrowthRate() {
		return this.buildings.get("Forge").getProduction();
	}

	public int getMaxWoodStored() {
	//	return maxWoodStored;	
		return 1000 + this.buildings.get("Wood WhareHouse").getStoreCapacity();
	}

	public int getMaxRockStored() {
	//	return maxRockStored;
		return 1000 + this.buildings.get("Rock WhareHouse").getStoreCapacity();
		
	}
	public int getMaxSteelStored() {
	//	return maxSteelStored;
		return 1000 + this.buildings.get("Steel WhareHouse").getStoreCapacity();
		
	}
	public int getMaxFoodStored() {
	//	return maxFoodStored;
		return 500 + this.buildings.get("Food WhareHouse").getStoreCapacity();
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean troopIsUnlocked(String troopName) {
		
		try {
		if(this.unlockedTroop.get(troopName))
			return true;
		else
			return false;
		}catch(Exception e) {
			return false;
		}		
	}
	public void unlockTroop(String troopName) {
		
		try {
		if(this.unlockedTroop.get(troopName)) {
			
		}
		else {
			this.unlockedTroop.put(troopName, true);
		}
		}catch(Exception e) {
			this.unlockedTroop.put(troopName, true);
		}		
	}	
	
	
	public void resourcesGrow() {			

		this.wood 		= 	fillResourceUntilMax(	this.getWood(), 		this.getExtraWoodGrowthRate() + this.baseWoodGrowthRate, 		this.getMaxWoodStored());
		this.steel 		= 	fillResourceUntilMax(	this.getSteel(), 		this.getExtraSteelGrowthRate() + this.baseSteelGrowthRate, 		this.getMaxSteelStored());
		this.rock 		= 	fillResourceUntilMax(	this.getRock(), 		this.getExtraRockGrowthRate() + this.baseRockGrowthRate, 		this.getMaxRockStored());
		this.food 		= 	fillResourceUntilMax(	this.getFood(), 		this.getExtraFoodGrowthRate() + this.baseFoodGrowthRate, 		this.getMaxFoodStored());
		System.out.println("Growth");
		
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
