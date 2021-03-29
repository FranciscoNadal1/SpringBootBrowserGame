package com.game.app.entity.buildings;

import javax.persistence.Entity;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;
import com.game.app.entity.Kingdom;

@Entity
public class Farm extends Building {

	public Farm() {
		this.hp = 500;
		this.level = 0;
		this.name = "Farm";
		this.baseWoodCost = 300;
		this.portrait = "https://image.shutterstock.com/image-photo/essex-uk-31-august-2018-260nw-1175345272.jpg";
		production = 0;
	}

	String description = "Make food";
	int maxLevel = 30;

	int baseWoodCost = 300;
	int baseRockCost = 50;
	int baseSteelCost = 20;
	public String portrait;
	
	//TODO This should be a resource OBJECT, eventually
	int production;

	public void levelUp() {
		Kingdom currentKingdom = super.getKingdom();
		if (canLevelUp()) {
			currentKingdom.setWood(currentKingdom.getWood() - (baseWoodCost * (level+1)));
			currentKingdom.setRock(currentKingdom.getRock() - (baseRockCost * (level+1)));
			currentKingdom.setSteel(currentKingdom.getSteel() - (baseSteelCost * (level+1)));

			level++;
			this.production += 10;
		}

	}
	

	public boolean canLevelUp() {
		Kingdom currentKingdom = super.getKingdom();

		if ((level+1) < maxLevel) {
			if ((baseWoodCost * (level+1)) < currentKingdom.getWood() && (baseRockCost * (level+1)) < currentKingdom.getRock()
					&& (baseSteelCost * (level+1)) < currentKingdom.getSteel()

			)
				return true;

		}
		return false;
	}
////////////////////////////////////////////////////////////////////////////////////

	public int getProduction() {
		return production;
	}
	
	public int getBaseWoodCost() {
		return baseWoodCost;
	}

	public void setBaseWoodCost(int baseWoodCost) {
		this.baseWoodCost = baseWoodCost;
	}

	public int getBaseRockCost() {
		return baseRockCost;
	}

	public void setBaseRockCost(int baseRockCost) {
		this.baseRockCost = baseRockCost;
	}

	public int getBaseSteelCost() {
		return baseSteelCost;
	}

	public void setBaseSteelCost(int baseSteelCost) {
		this.baseSteelCost = baseSteelCost;
	}

	@Override
	public String getPortrait() {
		return this.portrait;
	}
	

	public String getDescription() {
		return description;
	}

}
