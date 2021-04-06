package com.game.app.war;

public interface ICoordinateService {

	public void saveCoordinate(Coordinate coordinate);
	public Coordinate findByXAndY(Formation formation, int x, int y);
//	public Coordinate findById(int id);
	public void coordinateSwap(Coordinate one, Coordinate two);
	public void changeCoordinateXAndY(Coordinate coordinate, int x, int y);
	public void coordinateSwap(Formation formation, int oneX, int oneY, int twoX, int twoY);
	
}
