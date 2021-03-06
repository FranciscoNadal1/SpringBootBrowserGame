package com.game.app.entity.buildings.production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;
import com.game.app.entity.Kingdom;
import com.game.app.singleton.StaticRequirements;
import com.game.app.singleton.StaticRequirementsSingleton;

@Entity
public class Quarry extends Building {

	public Quarry() {
		this.hp = 3500;
		this.level = 0;
		this.name = "Quarry";
		this.portrait = "https://www.masonrymagazine.com/wp-content/uploads/2018/08/ollo.jpg";
		super.setMaxLevel(30);	
	}

	//int maxLevel;

	String description = "Chop da stones";

	//TODO This should be a resource OBJECT, eventually
	int production;
	
	@Lob
	@Column(length = 30000)
	public String portrait;
	public void levelUp() {
		super.levelUp();
	}
	

////////////////////////////////////////////////////////////////////////////////////

	public int getProduction() {
		//return production;
		return this.level * 10;
	}

	@Override
	public String getPortrait() {
		return this.portrait;
	}

	public String getDescription() {
		return description;
	}


	@Override
	protected int getStoreCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}
}
