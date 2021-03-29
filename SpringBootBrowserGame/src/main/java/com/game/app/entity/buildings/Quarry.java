package com.game.app.entity.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;
import com.game.app.entity.Kingdom;

@Entity
public class Quarry extends Building {

	public Quarry() {
		this.hp = 3500;
		this.level = 0;
		this.name = "Quarry";
		this.portrait = "https://www.masonrymagazine.com/wp-content/uploads/2018/08/ollo.jpg";
	
		
	
	
	}

	int maxLevel = 30;

	String description = "Chop da stones";

	int baseWoodCost = 500;
	int baseRockCost = 50;
	int baseSteelCost = 10;
	//TODO This should be a resource OBJECT, eventually
	int production;
	
	@Lob
	@Column(length = 30000)
	public String portrait;

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

}
