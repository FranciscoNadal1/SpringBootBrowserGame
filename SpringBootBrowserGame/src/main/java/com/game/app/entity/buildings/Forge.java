package com.game.app.entity.buildings;

import javax.persistence.Entity;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;
import com.game.app.entity.Kingdom;

@Entity
public class Forge extends Building {

	public Forge() {
		this.hp = 1500;
		this.level = 0;
		this.name = "Forge";
		this.portrait = "https://media.sketchfab.com/models/f798514d4054444384bc03521f4bd141/thumbnails/0223215623134229a18dfb8efbe644ee/e2243d63b1ef4a9788429c3a3fc45d06.jpeg";
	}

	int maxLevel = 10;
	int baseWoodCost = 200;
	int baseRockCost = 500;
	int baseSteelCost = 50;
	public String portrait;
	
	//TODO This should be a resource OBJECT, eventually
	int production;

	String description = "Make steel";

	public void levelUp() {
		Kingdom currentKingdom = super.getKingdom();
		if (canLevelUp()) {
			currentKingdom.setWood(currentKingdom.getWood() - (baseWoodCost * (level+1)));
			currentKingdom.setRock(currentKingdom.getRock() - (baseRockCost * (level+1)));
			currentKingdom.setSteel(currentKingdom.getSteel() - (baseSteelCost * (level+1)));

			level++;
			production += 5;
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

}
