package com.game.app.war;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.game.app.dao.BaseRepository;

public interface IFormation  extends BaseRepository <Formation, Long>{

	Formation save(Formation formation);

	@Query(value="Select formation.* from unit_coordinate, formation where formation.id = unit_coordinate.formation_id and unit_coordinate.units_id = :unitId", nativeQuery=true)
	public Formation getFormationOfUnit(@Param("unitId") int unitId);
	
	
	@Query(value="Select 	formation.* 	from 	unit_coordinate, coordinate, formation	where 	coordinate.id = unit_coordinate.coordinate_id 	and formation.id = unit_coordinate.formation_id	and coordinate.id = :coordinateId" + 
			"", nativeQuery=true)
	public Formation getFormationOfCoordinate(@Param("coordinateId") int coordinateId);
}
