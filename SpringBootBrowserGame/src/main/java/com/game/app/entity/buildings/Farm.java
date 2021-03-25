package com.game.app.entity.buildings;

import javax.persistence.Entity;

import com.game.app.entity.Building;

@Entity
public class Farm extends Building {

	public Farm() {
		this.hp = 500;
		this.level = 1;
		this.name = "Farm";
	}

	int maxLevel = 5;

	public void levelUp() {
		if (level < maxLevel)
			level++;

	}

	public boolean canLevelUp() {

		if (level < maxLevel)
			return true;

		return false;
	}
}
