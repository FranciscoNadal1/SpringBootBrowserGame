package com.game.app.entity.buildings.production;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.game.app.entity.Building;
import com.game.app.entity.Kingdom;
import com.game.app.entity.Requirements;
import com.game.app.globalFunctions.GetRequirements;
import com.game.app.service.RequirementsServiceImpl;
import com.game.app.singleton.StaticRequirements;
import com.game.app.singleton.StaticRequirementsSingleton;

@Entity
public class Farm extends Building {


	
	public Farm() {
		this.hp = 500;
		this.level = 0;
		this.name = "Farm";
		this.portrait = "https://image.shutterstock.com/image-photo/essex-uk-31-august-2018-260nw-1175345272.jpg";
		production = 0;
		super.setMaxLevel(30);
	}

	String description = "Make food";

	public String portrait;
	
	//TODO This should be a resource OBJECT, eventually
	int production;

////////////////////////////////////////////////////////////////////////////////////

	public int getProduction() {
	//	return production;
		return this.level * 10;
	}
	
	@Override
	public String getPortrait() {
		return this.portrait;
	}
	

	public String getDescription() {
		return description;
	}

}
