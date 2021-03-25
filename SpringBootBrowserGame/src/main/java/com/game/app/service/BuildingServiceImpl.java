package com.game.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.dao.IBuilding;
import com.game.app.entity.Building;

@Service
public class BuildingServiceImpl implements IBuildingService {

	@Autowired
	private IBuilding buildingDao;
	
	@Override
	public void save(Building building) {
		buildingDao.save(building);
	}
}
