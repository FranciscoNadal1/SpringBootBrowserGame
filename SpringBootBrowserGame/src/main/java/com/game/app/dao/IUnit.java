package com.game.app.dao;

import java.util.List;

import com.game.app.entity.Kingdom;
import com.game.app.entity.Unit;

public interface IUnit extends BaseRepository <Unit, Long> {

	public List<Unit> findUnitByKingdom(Kingdom kingdom);
	public Unit findById(int id);
	public List<Unit> findUnitsByCommander(Unit commander);
	public List<Unit> findUnitsByCommanderIsNull();

}
