package com.game.app.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.game.app.singleton.StaticRequirements;
import com.game.app.singleton.StaticRequirementsSingleton;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Building{



	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	
	public int level;
	public int hp;
	public String name;
	public String portrait;
	
	int maxLevel;
	
	//TODO This should be a resource OBJECT, eventually
	int production;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "kingdom_id", referencedColumnName = "id")
	private Kingdom kingdom;
	////////////////////////////////////////////////////////////
	
	public Building() {
		
	}

	public Building(String name) {
		this.name = name;
		this.level = 0;
		this.hp = 500;
	}
	////////////////////////////////////////////////////////////
	
//	public abstract boolean canLevelUp();
//	public abstract void levelUp();
	
	
	
	
	public void levelUp() {
		
		StaticRequirements req = StaticRequirementsSingleton.getInstance().getStaticRequirementsFromNameAndLevel(name, level+1);
		//StaticRequirementsSingleton.getInstance().printAllStaticRequirements();		
		
		
		Kingdom currentKingdom = getKingdom();
		if (canLevelUp(req)) {
			currentKingdom.setWood(currentKingdom.getWood() - req.getWood());
			currentKingdom.setRock(currentKingdom.getRock() - req.getRock());
			currentKingdom.setSteel(currentKingdom.getSteel() - req.getSteel());

			level++;
			this.production += 10;
			unlockTroops(currentKingdom);
		}

	}
	
	public void unlockTroops(Kingdom currentKingdom) {
		if(currentKingdom.getBuildings().get("Barracks").getLevel() == 1) {
			currentKingdom.unlockTroop("Legionary");
			currentKingdom.unlockTroop("Commander");
		}
		if(currentKingdom.getBuildings().get("Barracks").getLevel() == 2) {
			currentKingdom.unlockTroop("Archer");
		}
		
	}
	
	public boolean canLevelUp(StaticRequirements requirements) {

		Kingdom currentKingdom = getKingdom();
		if ((level+1) < maxLevel) {
			if (requirements.getWood() <= currentKingdom.getWood() && requirements.getRock() <= currentKingdom.getRock()
					&& requirements.getSteel() <= currentKingdom.getSteel()

			)
				return true;

		}
		return false;
		
	}
	public boolean canLevelUp() {		

		StaticRequirements req = StaticRequirementsSingleton.getInstance().getStaticRequirementsFromNameAndLevel(name, level+1);		
		return(canLevelUp(req));
		
	}
	
	
	
	////////////////////////////////////////////////////////////
	
	
	public int getLevel() {
		return level;
	}

	public int getProduction() {
		return production;
	}

	public int getId() {
		return Id;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public abstract String getPortrait();

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	protected abstract int getStoreCapacity();
	
	
	
}
