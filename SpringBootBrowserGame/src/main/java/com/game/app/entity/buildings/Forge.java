package com.game.app.entity.buildings;

import javax.persistence.Entity;

import com.game.app.entity.Building;
import com.game.app.entity.GameProfile;
import com.game.app.entity.Kingdom;
import com.game.app.singleton.StaticRequirements;
import com.game.app.singleton.StaticRequirementsSingleton;

@Entity
public class Forge extends Building {

	public Forge() {
		this.hp = 1500;
		this.level = 0;
		this.name = "Forge";
		this.portrait = "https://media.sketchfab.com/models/f798514d4054444384bc03521f4bd141/thumbnails/0223215623134229a18dfb8efbe644ee/e2243d63b1ef4a9788429c3a3fc45d06.jpeg";
	}

	int maxLevel = 10;
	public String portrait;
	
	//TODO This should be a resource OBJECT, eventually
	int production;

	String description = "Make steel";

////////////////////////////////////////////////////////////////////////////////////
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
