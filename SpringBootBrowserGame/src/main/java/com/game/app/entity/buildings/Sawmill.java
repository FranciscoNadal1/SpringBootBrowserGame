package com.game.app.entity.buildings;

import javax.persistence.Entity;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;
import com.game.app.entity.Kingdom;

@Entity
public class Sawmill extends Building {

	public Sawmill() {
		this.hp = 2500;
		this.level = 0;
		this.name = "Sawmill";
		this.portrait = "https://cdna.artstation.com/p/assets/images/images/009/783/810/large/fran-fdez-conceptos-ciencia-produccion.jpg?1520883100";
	}

	int maxLevel = 30;

	String description = "Chop da trees";

	int baseWoodCost = 40;
	int baseRockCost = 500;
	int baseSteelCost = 100;
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
			production += 40;
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
