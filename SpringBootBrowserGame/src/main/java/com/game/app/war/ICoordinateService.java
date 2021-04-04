package com.game.app.war;

public interface ICoordinateService {

	public void saveCoordinate(Coordinate coordinate);
	public Coordinate findByXAndY(Formation formation, int x, int y);
//	public Coordinate findById(int id);
	
}
