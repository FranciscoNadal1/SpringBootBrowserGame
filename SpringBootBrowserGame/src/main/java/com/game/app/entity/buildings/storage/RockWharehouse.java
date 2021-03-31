package com.game.app.entity.buildings.storage;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class RockWharehouse extends Building {


	public RockWharehouse() {
		this.hp = 2500;
		this.level = 0;
		this.name = "Rock WhareHouse";
		this.portrait = "https://cdna.artstation.com/p/assets/images/images/009/783/810/large/fran-fdez-conceptos-ciencia-produccion.jpg?1520883100";
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
