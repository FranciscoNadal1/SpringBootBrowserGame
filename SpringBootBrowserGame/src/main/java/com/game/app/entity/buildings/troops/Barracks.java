package com.game.app.entity.buildings.troops;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class Barracks extends Building {


	public Barracks() {
		this.hp = 3000;
		this.level = 0;
		this.name = "Barracks";
		this.portrait = "https://i.imgur.com/W6rFzZr.jpg";
		super.setMaxLevel(5);
	}

	String description = "Train troops";

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
