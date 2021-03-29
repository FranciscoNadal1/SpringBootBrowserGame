package com.game.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
	public abstract boolean canLevelUp();
	public abstract void levelUp();
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
	
	
	
}
