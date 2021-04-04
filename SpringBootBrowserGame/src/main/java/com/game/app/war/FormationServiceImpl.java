package com.game.app.war;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormationServiceImpl implements IFormationService {

	@Autowired
	private ICoordinate coordinateDao;


	public boolean isCoordinateInThisFormation(Formation formation, Coordinate coordinate) {
	
		List<Integer> coordinateIds = new LinkedList<Integer>();
		
		 for (Coordinate name : formation.getFormationPositions().keySet()) {
	            System.out.println("key: " + name);	            
	            coordinateIds.add(name.getId());
		 }
		 
		 if(coordinateIds.contains(coordinate.getId()))
				return true;
		 else
		 		return false;
	}	
}
