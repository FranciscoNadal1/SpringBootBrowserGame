package com.game.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.dao.IUnit;
import com.game.app.entity.Kingdom;
import com.game.app.entity.Unit;
import com.game.app.service.interfaces.IUnitService;

@Service
public class UnitServiceImpl implements IUnitService {

	@Autowired
	public IUnit unitDao;
	@Override
	public void newUnit(Unit unit) {
		// TODO Auto-generated method stub
		unitDao.save(unit);

	}

	@Override
	public List<Unit> getAllUnits() {
		return (List<Unit>) unitDao.findAll();
	}

	@Override
	public List<Unit> getAllUnitsOfKingdom(Kingdom kingdom) {
		return unitDao.findUnitByKingdom(kingdom);
	}

	@Override
	public Unit getUnit(int id) {
		return unitDao.findById(id);
	}

	@Override
	public List<Unit> findUnitsAssignedToCommander(Unit commander) {
		return (List<Unit>) unitDao.findUnitsByCommander(commander);
	}

	@Override
	public List<Unit> findUnitsByCommanderIsNull() {
		return (List<Unit>) unitDao.findUnitsByCommanderIsNull();
	}

}
