package com.game.app.entity.buildings.troops;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class Stable extends Building {


	public Stable() {
		this.hp = 3000;
		this.level = 0;
		this.name = "Stable";
		this.portrait = "https://slm-assets.secondlife.com/assets/11287979/view_large/Medieval_horse_stable_1.jpg?1426874474";
		super.setMaxLevel(3);
	}

	String description = "Unlock horses, unlock mounted troops";

	public String portrait;
	//TODO This should be a resource OBJECT, eventually
	int storeCapacity;
	

////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String getPortrait() {
		return this.portrait;
	}

	public String getDescription() {
		return description;
	}

	@Override
	protected int getStoreCapacity() {
		return 0;
	}
}
