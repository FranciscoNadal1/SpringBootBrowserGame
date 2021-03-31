package com.game.app.entity.buildings.troops;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class MageTower extends Building {


	public MageTower() {
		this.hp = 3000;
		this.level = 0;
		this.name = "Mage tower";
		this.portrait = "http://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/25807417/542e51180923d65c63a84f7d758332deee0752ef.jpg";
		super.setMaxLevel(5);
	}

	String description = "Unlock mage and healers production";

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
