package com.game.app.entity.troops;

import javax.persistence.Entity;

import com.game.app.entity.Unit;

@Entity
public class Legionary extends Unit {

	public Legionary() {
		super.maxHp = 200;
		super.maxArmor = 50;
		super.maxMana = 0;
		super.maxStamina = 10;
		super.maxSpeed = 100;
		super.maxAttack = 10;
		
		super.currentHp = super.maxHp;
		super.currentArmor = super.maxArmor;
		super.currentMana = super.maxMana;
		super.currentStamina = super.maxStamina;
		super.currentSpeed = super.maxSpeed;
		super.currentAttack = super.maxAttack;
		
		
		super.isMelee = true;
		super.isRanged = false;
		
		super.level = 1;
		super.name = "Legionary";
		super.portrait = "https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-of-a-roman-legionary-18-andrea-mazzocchetti.jpg";
	}
	
}
