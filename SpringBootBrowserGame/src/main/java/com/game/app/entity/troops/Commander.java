package com.game.app.entity.troops;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.game.app.entity.Unit;
import com.game.app.war.Formation;

@Entity
public class Commander extends Unit {

	public static String staticDescription = "A commander is the base of an army";
	public static String staticName = "Commander";
	public static String staticPortrait = "https://c8.alamy.com/comp/BRA1HR/49-bc-roman-julius-caesar-cesar-leads-his-troops-from-horseback-across-BRA1HR.jpg";
	public String commanderName;

	/*
	@OneToMany
	private List<Unit> unitsAssigned;
	
	*/
	@OneToOne(cascade = {CascadeType.ALL})
	public Formation troopFormation;
	
	public Commander() {
		super.maxHp = 500;
		super.maxArmor = 250;
		super.maxMana = 20;
		super.maxStamina = 20;
		super.maxSpeed = 300;
		super.maxAttack = 25;
		
		super.currentHp = super.maxHp;
		super.currentArmor = super.maxArmor;
		super.currentMana = super.maxMana;
		super.currentStamina = super.maxStamina;
		super.currentSpeed = super.maxSpeed;
		super.currentAttack = super.maxAttack;
		super.description = Commander.getStaticDescription();
		
		super.isMelee = true;
		super.isRanged = false;
		
		super.level = 1;
		super.name = Commander.getStaticName();
		super.portrait = Commander.getStaticPortrait();
		
		this.commanderName = this.setToRandomName();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public static String getStaticDescription() {
		return staticDescription;
	}
	public String getCommanderName() {
		return commanderName;
	}	
	
	public String setToRandomName() {
		List<String> nameList = new LinkedList<String>();
		
		nameList.add("Spurius");
		nameList.add("Salonius");
		nameList.add("Mancinus");
		nameList.add("Lucius");
		nameList.add("Aurelius");
		nameList.add("Cico");
		nameList.add("Aulus");
		nameList.add("Piscius");
		nameList.add("Eulogius");
		nameList.add("Cossus");
		nameList.add("Albatius");
		nameList.add("Statius");
		nameList.add("Sisenna");
		nameList.add("Maecilius");
		nameList.add("Afer");
		nameList.add("Gallus  ");
		nameList.add("Fufius");
		nameList.add("Silvanus");
		nameList.add("Cossus  ");
		nameList.add("Licinius");
		nameList.add("Pacatianus");
		nameList.add("Lar");
		nameList.add("Tadius");
		nameList.add("Paetus");
		nameList.add("Decius");
		nameList.add("Albanius");
		nameList.add("Octobrianus");
		nameList.add("Tiberius");
		nameList.add("Accoleius");
		nameList.add("Castorius");
		
		int randomNum = ThreadLocalRandom.current().nextInt(0, nameList.size());
		return nameList.get(randomNum);
	}	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	




	@Override
	public void addToCommander(Unit commander) {

	}
	
	public Formation getTroopFormation() {
		return troopFormation;
	}

	public void setTroopFormation(Formation troopFormation) {
		this.troopFormation = troopFormation;
	}

	public void setCommanderName(String commanderName) {
		this.commanderName = commanderName;
	}

	

	
	public static String getStaticName() {
		return staticName;
	}
	public static String getStaticPortrait() {
		return staticPortrait;
	}
}
