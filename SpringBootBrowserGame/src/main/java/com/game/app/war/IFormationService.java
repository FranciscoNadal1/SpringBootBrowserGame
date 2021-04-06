package com.game.app.war;

import java.util.Map;

import com.game.app.entity.Unit;

public interface IFormationService {
	public boolean isCoordinateInThisFormation(Formation formation, Coordinate coordinate);
	public Map<Coordinate,Unit> sortToTurtleFormation(Map<Coordinate,Unit> mapToSort);
}
