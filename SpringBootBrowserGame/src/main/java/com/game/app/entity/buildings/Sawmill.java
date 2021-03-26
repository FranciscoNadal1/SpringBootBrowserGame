package com.game.app.entity.buildings;

import javax.persistence.Entity;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;

@Entity
public class Sawmill extends Building {

	public Sawmill() {
		this.hp = 2500;
		this.level = 1;
		this.name = "Sawmill";
	}

	int maxLevel = 30;

	String description = "Chop da trees";

	int baseWoodCost = 40;
	int baseRockCost = 500;
	int baseSteelCost = 100;

	public void levelUp() {
		GameProfile gameProfile = super.getKingdom().getGameProfile();
		if (canLevelUp()) {
			gameProfile.setWood(gameProfile.getWood() - (baseWoodCost * level));
			gameProfile.setRock(gameProfile.getRock() - (baseRockCost * level));
			gameProfile.setSteel(gameProfile.getSteel() - (baseSteelCost * level));

			level++;
		}

	}

	public boolean canLevelUp() {
		GameProfile gameProfile = super.getKingdom().getGameProfile();

		if (level < maxLevel) {
			if ((baseWoodCost * level) < gameProfile.getWood() && (baseRockCost * level) < gameProfile.getRock()
					&& (baseSteelCost * level) < gameProfile.getSteel()

			)
				return true;

		}
		return false;
	}
////////////////////////////////////////////////////////////////////////////////////

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

}
