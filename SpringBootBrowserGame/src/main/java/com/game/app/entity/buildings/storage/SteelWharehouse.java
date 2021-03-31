package com.game.app.entity.buildings.storage;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class SteelWharehouse extends Building {


	public SteelWharehouse() {
		this.hp = 2500;
		this.level = 0;
		this.name = "Steel WhareHouse";
		this.portrait = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQX8OMpbsxRJ6Mb5hmCqGpL2CQkkUXOIYjfjg&usqp=CAU";
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
