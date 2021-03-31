package com.game.app.entity.buildings.storage;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class FoodWharehouse extends Building {


	public FoodWharehouse() {
		this.hp = 2500;
		this.level = 0;
		this.name = "Food WhareHouse";
		this.portrait = "https://www.chinadaily.com.cn/travel/img/attachement/jpg/site1/20141202/f8bc126e491615e7ae8816.jpg";
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
