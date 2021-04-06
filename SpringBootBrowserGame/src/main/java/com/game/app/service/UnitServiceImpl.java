package com.game.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.dao.IUnit;
import com.game.app.entity.Kingdom;
import com.game.app.entity.Unit;
import com.game.app.entity.troops.Commander;
import com.game.app.service.interfaces.IUnitService;
import com.game.app.war.Coordinate;
import com.game.app.war.Formation;
import com.game.app.war.ICoordinate;
import com.game.app.war.ICoordinateService;
import com.game.app.war.IFormation;

@Service
public class UnitServiceImpl implements IUnitService {

	@Autowired
	private IUnitService unitService;

	@Autowired
	private ICoordinate coordinationDao;
	@Autowired
	private IFormation formationDao;
	@Autowired
	public IUnit unitDao;
	
	@Autowired
	private ICoordinateService coordinationServiceDao;
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
	
//////////////////////////////////////////////////////////////////////////////////////////
	public void addUnit(Kingdom currentKingdom, String unitName) {
		Class cls;
		try {			
				cls = Class.forName("com.game.app.entity.troops."+unitName);
				Unit newUnit= (Unit) cls.getDeclaredConstructor().newInstance();
				newUnit.setKingdom(currentKingdom);
				unitService.newUnit(newUnit);
				
				if(newUnit.getName().equals("Commander")) {
					Formation formation = new Formation(newUnit);
					((Commander) newUnit).setTroopFormation(formation);
					formationDao.save(formation);
					
					addUnitToCommander(newUnit,newUnit);
					
				}
			
			else
				throw new RuntimeException(unitName + " is not unlocked");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void trainUnit(Kingdom currentKingdom, String unitName) {
		Class cls;
		try {
			if(currentKingdom.troopIsUnlocked(unitName)) {
				cls = Class.forName("com.game.app.entity.troops."+unitName);
				Unit newUnit= (Unit) cls.getDeclaredConstructor().newInstance();
				newUnit.setKingdom(currentKingdom);
				unitService.newUnit(newUnit);
				
				if(newUnit.getName().equals("Commander")) {
					Formation formation = new Formation(newUnit);
					((Commander) newUnit).setTroopFormation(formation);
					formationDao.save(formation);
					
					addUnitToCommander(newUnit,newUnit);
					
				}
			}
			else
				throw new RuntimeException(unitName + " is not unlocked");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void addUnitToCommander(Unit commander, Unit unit) {
		
		
		Formation formation =  ((Commander)commander).getTroopFormation();
		
		boolean flag = false;
		for(int x = 0; x <= formation.getNumberPositionsX(); x++){
			for(int y = 0; y <= formation.getNumberPositionsY(); y++){		
				Coordinate actualCoordinate = coordinationServiceDao.findByXAndY(formation, x, y);
				if(!formation.getFormationPositions().containsKey(actualCoordinate)) {

					if(!formation.hasUnit(actualCoordinate)) {	
					
						System.out.println("");
						
						addUnitTo(formation, unit, x, y);
						flag = true;					
					}
				}
				if(flag)break;
			}
			if(flag)break;
		}
		
		
		unit.setCommander(commander);
		unitService.newUnit(unit);
		
	}
	
	public void addUnitToCommander(Unit commander, Unit unit, int x, int y) {
		
		
		Formation formation =  ((Commander)commander).getTroopFormation();
		
		boolean flag = false;
		for(; x <= formation.getNumberPositionsX(); x++){
			for(; y <= formation.getNumberPositionsY(); y++){		
				Coordinate actualCoordinate = coordinationServiceDao.findByXAndY(formation, x, y);
				if(!formation.getFormationPositions().containsKey(actualCoordinate)) {

					if(!formation.hasUnit(actualCoordinate)) {	
					
						System.out.println("");
						
						addUnitTo(formation, unit, x, y);
						flag = true;					
					}
				}
				if(flag)break;
			}
			if(flag)break;
		}
		
		
		unit.setCommander(commander);
		unitService.newUnit(unit);
		
	}
	
	@Transient
	public void addUnitTo(Formation formation, Unit unitToAdd, int x, int y) {
		Coordinate coordinate = new Coordinate(x,y);		
		formation.getFormationPositions().put(coordinate, unitToAdd);
		
			coordinationDao.save(coordinate);
		formationDao.save(formation);
	}
	
}
