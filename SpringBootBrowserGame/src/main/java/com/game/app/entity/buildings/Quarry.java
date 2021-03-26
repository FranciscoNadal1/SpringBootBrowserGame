package com.game.app.entity.buildings;

import javax.persistence.Entity;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;

@Entity
public class Quarry extends Building {

	public Quarry() {
		this.hp = 3500;
		this.level = 1;
		this.name = "Quarry";
	}

	int maxLevel = 30;

	String description = "Chop da stones";

	int baseWoodCost = 500;
	int baseRockCost = 50;
	int baseSteelCost = 10;

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
