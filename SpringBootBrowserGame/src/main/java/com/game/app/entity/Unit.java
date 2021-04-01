package com.game.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.game.app.entity.troops.Legionary;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Getter @Setter
public abstract class Unit {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	
	public String name;
	public String description;
	public String portrait;
	
	public int level;
	public int maxHp;
	public int currentHp;
	public int maxArmor;
	public int currentArmor;
	public int maxMana;
	public int currentMana;
	public int maxStamina; 
	public int currentStamina;
	
	public int maxSpeed;
	public int currentSpeed;
	
	public int maxAttack;
	public int currentAttack;
	public boolean isRanged;
	public boolean isMelee;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "kingdom_id", referencedColumnName = "id")
	private Kingdom kingdom;
	
	public void levelUp() {

		this.level +=1;
	}
	
	public void heal(int hp) {
		this.currentHp = this.currentHp + hp;
		
		if(this.currentHp>=this.maxHp)
			this.currentHp = this.maxHp;
	}
	
	public void heal() {
		this.currentHp = this.maxHp;
		this.currentArmor = this.maxArmor;
		this.currentMana = this.maxMana;
		this.currentStamina = this.maxStamina;
		this.currentSpeed = this.maxSpeed;
		this.currentAttack = this.maxAttack;
	}
////////////////////////////////////////////////////////

	public boolean equals(Unit unit) {

		if(		unit.getLevel() 		== 		this.getLevel() &&
				unit.getMaxHp() 		== 		this.getMaxHp() &&
				unit.getMaxMana() 		== 		this.getMaxMana() &&
				unit.getMaxStamina() 	== 		this.getMaxStamina() &&
				unit.getMaxSpeed() 		== 		this.getMaxSpeed() &&
				unit.getMaxAttack() 	== 		this.getMaxAttack() &&
				unit.getName().equals(this.getName()) &&
				unit.getMaxArmor() 		== 		this.getMaxArmor() 
			)
			return true;
		else
			return false;
	}
////////////////////////////////////////////////////////
	
	
	
	
	public static String getStaticPortrait() {
		return "a";
	}	
////////////////////////////////////////////////////////
	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}



	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPortrait() {
		return portrait;
	}

	public int getId() {
		return Id;
	}

	public int getLevel() {
		return level;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public int getMaxArmor() {
		return maxArmor;
	}

	public int getCurrentArmor() {
		return currentArmor;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public int getMaxStamina() {
		return maxStamina;
	}

	public int getCurrentStamina() {
		return currentStamina;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public int getMaxAttack() {
		return maxAttack;
	}

	public int getCurrentAttack() {
		return currentAttack;
	}

	public boolean isRanged() {
		return isRanged;
	}

	public boolean isMelee() {
		return isMelee;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}
	
}
