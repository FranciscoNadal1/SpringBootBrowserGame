package com.game.app.service.interfaces;

import java.util.List;

import com.game.app.entity.Kingdom;
import com.game.app.entity.Unit;

public interface IUnitService {
	public void newUnit(Unit unit);
	public List<Unit> getAllUnits();
	public List<Unit> getAllUnitsOfKingdom(Kingdom kingdom);
	public Unit getUnit(int id);
	public List<Unit> findUnitsAssignedToCommander(Unit commander);
	public List<Unit> findUnitsByCommanderIsNull();
	//////////////////////////////////////////////////////////////////
	public void trainUnit(Kingdom currentKingdom, String unitName);
	public void addUnit(Kingdom currentKingdom, String unitName);
	public void addUnitToCommander(Unit commander, Unit unit);
	public void addUnitToCommander(Unit commander, Unit unit, int x, int y);
}
