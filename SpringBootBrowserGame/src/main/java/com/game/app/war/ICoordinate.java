package com.game.app.war;

import java.util.List;

import com.game.app.dao.BaseRepository;

public interface ICoordinate  extends BaseRepository <Coordinate, Long>{

	List<Coordinate> findByXAndY(int x, int y);
	Coordinate save(Coordinate coordinate);

}
