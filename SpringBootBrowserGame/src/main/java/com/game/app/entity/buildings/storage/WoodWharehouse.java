package com.game.app.entity.buildings.storage;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class WoodWharehouse extends Building {


	public WoodWharehouse() {
		this.hp = 2500;
		this.level = 0;
		this.name = "Wood WhareHouse";
		this.portrait = "https://images.fineartamerica.com/images-medium-large-5/giant-wood-pile-with-shovel-and-ax-donna-wilson.jpg";
		super.setMaxLevel(10);
	}

	String description = "Chop da trees";

	public String portrait;
	//TODO This should be a resource OBJECT, eventually
	int storeCapacity;
	

////////////////////////////////////////////////////////////////////////////////////
	public int getStoreCapacity() {
//		return this.storeCapacity;

		return (int) (this.level * 2.5 * 1000);
	}

	@Override
	public String getPortrait() {
		return this.portrait;
	}

	public String getDescription() {
		return description;
	}
	
	
}
