package com.game.app.entity.buildings;

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
//		this.baseWoodCost = 300;
		this.portrait = "https://image.shutterstock.com/image-photo/essex-uk-31-august-2018-260nw-1175345272.jpg";
		production = 0;
	}

	String description = "Make food";
	int maxLevel = 30;
/*
	int baseWoodCost = 300;
	int baseRockCost = 50;
	int baseSteelCost = 20;
	*/
	public String portrait;
	
	//TODO This should be a resource OBJECT, eventually
	int production;

	public void levelUp() {
		super.levelUp(maxLevel);
		/*
		StaticRequirements req = StaticRequirementsSingleton.getInstance().getStaticRequirementsFromNameAndLevel(name, level+1);
		StaticRequirementsSingleton.getInstance().printAllStaticRequirements();		
		
		
		Kingdom currentKingdom = super.getKingdom();
		if (canLevelUp(req)) {
			currentKingdom.setWood(currentKingdom.getWood() - currentKingdom.getWood());
			currentKingdom.setRock(currentKingdom.getRock() - currentKingdom.getRock());
			currentKingdom.setSteel(currentKingdom.getSteel() - currentKingdom.getSteel());

			level++;
			this.production += 10;
		}
*/
	}
	
	public boolean canLevelUp(StaticRequirements requirements) {
		return super.canLevelUp(requirements, maxLevel);
/*
		Kingdom currentKingdom = super.getKingdom();
		if ((level+1) < maxLevel) {
			if (requirements.getWood() < currentKingdom.getWood() && requirements.getRock() < currentKingdom.getRock()
					&& requirements.getSteel() < currentKingdom.getSteel()

			)
				return true;

		}
		return false;
		*/
	}
	public boolean canLevelUp() {		

		return super.canLevelUp(maxLevel);
		/*
		StaticRequirements req = StaticRequirementsSingleton.getInstance().getStaticRequirementsFromNameAndLevel(name, level+1);		
		return(canLevelUp(req));
		*/
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
