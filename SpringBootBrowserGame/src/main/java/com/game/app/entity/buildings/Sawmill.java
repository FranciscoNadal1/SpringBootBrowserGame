package com.game.app.entity.buildings;

import javax.persistence.Entity;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;
import com.game.app.entity.Kingdom;
import com.game.app.singleton.StaticRequirements;
import com.game.app.singleton.StaticRequirementsSingleton;

@Entity
public class Sawmill extends Building {

	public Sawmill() {
		this.hp = 2500;
		this.level = 0;
		this.name = "Sawmill";
		this.portrait = "https://cdna.artstation.com/p/assets/images/images/009/783/810/large/fran-fdez-conceptos-ciencia-produccion.jpg?1520883100";
	}

	int maxLevel = 30;

	String description = "Chop da trees";

	public String portrait;
	//TODO This should be a resource OBJECT, eventually
	int production;
	public void levelUp() {
		super.levelUp(maxLevel);
	}
	
	public boolean canLevelUp(StaticRequirements requirements) {
		return super.canLevelUp(requirements, maxLevel);
	}
	public boolean canLevelUp() {		

		return super.canLevelUp(maxLevel);
	}
////////////////////////////////////////////////////////////////////////////////////

	public int getProduction() {
		return production;
	}

	@Override
	public String getPortrait() {
		return this.portrait;
	}

	public String getDescription() {
		return description;
	}


}
