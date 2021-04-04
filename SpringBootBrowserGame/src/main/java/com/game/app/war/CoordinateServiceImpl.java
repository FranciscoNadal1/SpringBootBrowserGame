package com.game.app.war;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImpl implements ICoordinateService {

	@Autowired
	private ICoordinate coordinateDao;
	
	@Autowired
	private FormationServiceImpl formationDao;

	@Override
	public void saveCoordinate(Coordinate coordinate) {
		coordinateDao.save(coordinate);
		
	}

	@Override
	public Coordinate findByXAndY(Formation formation, int x, int y) {
		//formation.getFormationPositions().containsKey(coordinateDao)
		
		for(Coordinate coordinate : coordinateDao.findByXAndY(x, y)) {
			if(formationDao.isCoordinateInThisFormation(formation, coordinate)) {
				//System.out.println(coordinate);
				return coordinate;
			}
			
		}
		return null;
		//List<Coordinate> coordinatesByXY = (List<Coordinate>) coordinateDao.findByXAndY(x, y);
		//return formation.get
	}
	
}
