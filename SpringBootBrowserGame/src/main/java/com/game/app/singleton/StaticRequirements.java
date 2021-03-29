package com.game.app.singleton;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class StaticRequirements{


	
	private String name;
	
	
	private int level;
	
	private int wood;
	private int rock;
	private int food;
	private int steel;
	
	// Required buildings, investigations... format building-level. For example : Farm-4
	@ElementCollection
	List<String> required;
	
	public StaticRequirements() {
	}

	public StaticRequirements(String name, int level, int wood, int rock,  int steel, int food) {
		super();
		this.name = name;
		this.level = level;
		this.wood = wood;
		this.rock = rock;
		this.food = food;
		this.steel = steel;
	}
	
public StaticRequirements(String name, int level, int wood, int rock, int food, int steel, List<String> required) {
		super();
		this.name = name;
		this.level = level;
		this.wood = wood;
		this.rock = rock;
		this.food = food;
		this.steel = steel;
		this.required = required;
	}

////////////////////////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getRock() {
		return rock;
	}

	public void setRock(int rock) {
		this.rock = rock;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getSteel() {
		return steel;
	}

	public void setSteel(int steel) {
		this.steel = steel;
	}

	public List<String> getRequired() {
		return required;
	}

	public void setRequired(List<String> required) {
		this.required = required;
	}
	
	

////////////////////////////////////////////////////////////////////
	
	
	
	
	
////////////////////////////////////////////////////////////////////
}
