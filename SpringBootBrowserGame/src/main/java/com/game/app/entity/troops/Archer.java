package com.game.app.entity.troops;

import javax.persistence.Entity;

import com.game.app.entity.Unit;

@Entity
public class Archer extends Unit {

	public static String staticDescription = "Basic ranged soldier";
	public static String staticName = "Archer";
	public static String staticPortrait = "https://lordsandknights.enjoyed.today/common/fansite_kit/units/NordicArcher.png";
	
	public Archer() {
		super.maxHp = 100;
		super.maxArmor = 20;
		super.maxMana = 0;
		super.maxStamina = 10;
		super.maxSpeed = 120;
		super.maxAttack = 8;
		
		super.currentHp = super.maxHp;
		super.currentArmor = super.maxArmor;
		super.currentMana = super.maxMana;
		super.currentStamina = super.maxStamina;
		super.currentSpeed = super.maxSpeed;
		super.currentAttack = super.maxAttack;
		super.description = Archer.getStaticDescription();
		
		super.isMelee = false;
		super.isRanged = true;
		
		super.level = 1;
		super.name = Archer.getStaticName();
		super.portrait = Archer.getStaticPortrait();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static String getStaticDescription() {
		return staticDescription;
	}
	public static String getStaticName() {
		return staticName;
	}
	public static String getStaticPortrait() {
		return staticPortrait;
	}
}
