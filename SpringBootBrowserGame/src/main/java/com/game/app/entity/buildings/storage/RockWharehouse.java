package com.game.app.entity.buildings.storage;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class RockWharehouse extends Building {


	public RockWharehouse() {
		this.hp = 2500;
		this.level = 0;
		this.name = "Rock WhareHouse";
		this.portrait = "https://previews.123rf.com/images/elarina/elarina1704/elarina170401369/76534115-fondo-industrial-con-el-mont%C3%B3n-de-grava-delante-del-cielo-extracci%C3%B3n-de-grava-construcci%C3%B3n-de-carreteras-mont.jpg";
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
