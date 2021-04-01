package com.game.app.service.interfaces;

import java.util.List;

import com.game.app.entity.Kingdom;
import com.game.app.entity.Unit;

public interface IUnitService {
	public void newUnit(Unit unit);
	public List<Unit> getAllUnits();
	public List<Unit> getAllUnitsOfKingdom(Kingdom kingdom);
}
