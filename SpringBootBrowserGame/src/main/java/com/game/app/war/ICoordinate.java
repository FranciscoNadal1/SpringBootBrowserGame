package com.game.app.war;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.game.app.dao.BaseRepository;

public interface ICoordinate  extends BaseRepository <Coordinate, Long>{

	List<Coordinate> findByXAndY(int x, int y);
	Coordinate save(Coordinate coordinate);
	

	@Query(value="Select coordinate.* from coordinate, unit_coordinate where unit_coordinate.coordinate_id=coordinate.id and unit_coordinate.units_id = :unitId", nativeQuery=true)
	public Coordinate getCoordinateOfId(@Param("unitId") int unitId);
	 
	@Query(value="UPDATE coordinate, unit_coordinate SET coordinate.x = :positionX, coordinate.y= :positionY WHERE unit_coordinate.coordinate_id=coordinate.id and unit_coordinate.units_id = :unitId", nativeQuery=true)
	@Modifying
	@Transactional
	public void changeCoordinateOfUnit(@Param("unitId") int unitId, @Param("positionX") int positionX, @Param("positionY") int positionY);

}
