package com.game.app.entity.buildings;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;

@Entity
public class Farm extends Building {

	public Farm() {
		this.hp = 500;
		this.level = 1;
		this.name = "Farm";
	}

	String description = "Make food";
	int maxLevel = 30;

	int baseWoodCost = 300;
	int baseRockCost = 50;
	int baseSteelCost = 20;

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
