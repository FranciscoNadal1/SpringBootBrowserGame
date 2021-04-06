package com.game.app.war;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.entity.Unit;
import com.game.app.service.interfaces.IUnitService;

@Service
public class FormationServiceImpl implements IFormationService {

	@Autowired
	private ICoordinate coordinateDao;
	@Autowired
	private ICoordinateService coordinateServiceDao;
	@Autowired
	private IFormation formationDao;
	@Autowired
	private IUnitService unitServiceDao;


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
	
	@Transient
	public Map<Coordinate,Unit> sortToTurtleFormation(Map<Coordinate,Unit> mapToSort) {
		Map<Coordinate, Unit> auxiliarFormationMap = mapToSort;

		Unit commander = null;
		Set<Unit> melee = new HashSet<Unit>();
		Set<Unit> ranged = new HashSet<Unit>();
		Set<Unit> others = new HashSet<Unit>();
		Formation formation = new Formation();
		
		for (Map.Entry<Coordinate,Unit> entry : mapToSort.entrySet()) {

				 if(entry.getValue().getName().equals("Commander")) {
					formationDao.getFormationOfUnit(entry.getValue().getId());
					
					formation = formationDao.getFormationOfUnit(entry.getValue().getId());
					// TODO NEED TO DO THIS
					//coordinateDao.changeCoordinateOfUnit(entry.getValue().getId(), 5, 5);			
					commander = entry.getValue();
				}
				 else{
					 if(entry.getValue().isMelee) 
						 melee.add(entry.getValue());
					 else if(entry.getValue().isRanged) 
						 ranged.add(entry.getValue());
					 else
						 others.add(entry.getValue());
					
				}					
		}		 

		Coordinate one = coordinateDao.getCoordinateOfId(commander.getId());

		int iteratorMelee;
		int maxMelee = melee.size();
		
		Iterator<Unit> iterator = melee.iterator();

		int commanderX =3;
		int commanderY =3;
		
		
		coordinateServiceDao.changeCoordinateXAndY(one, commanderX, commanderY);

		int f = commanderX-2;		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//	FIRST LINE OF MELEE FIGHTERS	/////////////////////////////////////////////////
		if(melee.size() >= 5) {
		int z=0;
			while (iterator.hasNext() && z !=5) {
				Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
				coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX-2, f);
				f++;
				iterator.remove();
				z++;
			}
		}
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX-1, commanderY);		
			iterator.remove();	
		}
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX-1, commanderY+1);		
			iterator.remove();	
		}
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX-1, commanderY-1);		
			iterator.remove();	
		}

		//////////////////////////////////////////////////////////////////////////////////////
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX-1, commanderY-2);		
			iterator.remove();	
		}
		
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX-1, commanderY+2);		
			iterator.remove();	
		}
		

		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX, commanderY-2);		
			iterator.remove();	
		}
		
		
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX, commanderY+2);		
			iterator.remove();	
		}

		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX+1, commanderY-2);		
			iterator.remove();	
		}
		
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX+1, commanderY+2);		
			iterator.remove();	
		}
		
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX+2, commanderY-2);		
			iterator.remove();	
		}
		
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX+2, commanderY+2);		
			iterator.remove();	
		}

		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX, commanderY+1);		
			iterator.remove();	
		}
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX, commanderY-1);		
			iterator.remove();	
		}
		
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX+1, commanderY+1);		
			iterator.remove();	
		}
		if(iterator.hasNext()) {
			Coordinate meleeC = coordinateDao.getCoordinateOfId(iterator.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(meleeC, commanderX+1, commanderY-1);		
			iterator.remove();	
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	FIRST LINE OF RANGED FIGHTERS	/////////////////////////////////////////////////

		Iterator<Unit> iteratorRanged = ranged.iterator();
		int a = commanderX-2;
		int q=3;
		if(ranged.size() >= 5) {
			q=0;
				while (iteratorRanged.hasNext() && q !=5) {
					Coordinate rangedC = coordinateDao.getCoordinateOfId(iteratorRanged.next().getId());
					coordinateServiceDao.changeCoordinateXAndY(rangedC, commanderX+4, a);
					a++;
					iteratorRanged.remove();
					q++;
				}
			}
		a= commanderX-2;
		if(ranged.size() >= 5) {
			q=0;
				while (iteratorRanged.hasNext() && q !=5) {
					Coordinate rangedC = coordinateDao.getCoordinateOfId(iteratorRanged.next().getId());
					coordinateServiceDao.changeCoordinateXAndY(rangedC, commanderX+5, a);
					a++;
					iteratorRanged.remove();
					q++;
				}
			}		
		a= commanderX-2;
		if(ranged.size() >= 5) {
			q=0;
				while (iteratorRanged.hasNext() && q !=5) {
					Coordinate rangedC = coordinateDao.getCoordinateOfId(iteratorRanged.next().getId());
					coordinateServiceDao.changeCoordinateXAndY(rangedC, commanderX+6, a);
					a++;
					iteratorRanged.remove();
					q++;
				}
			}
		
		if(iteratorRanged.hasNext()) {
			Coordinate rangedC = coordinateDao.getCoordinateOfId(iteratorRanged.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(rangedC, commanderX+3, commanderY-2);		
			iteratorRanged.remove();	
		}
		
		if(iteratorRanged.hasNext()) {
			Coordinate rangedC = coordinateDao.getCoordinateOfId(iteratorRanged.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(rangedC, commanderX+3, commanderY+2);		
			iteratorRanged.remove();	
		}
		if(iteratorRanged.hasNext()) {
			Coordinate rangedC = coordinateDao.getCoordinateOfId(iteratorRanged.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(rangedC, commanderX+3, commanderY-1);		
			iteratorRanged.remove();	
		}
		
		if(iteratorRanged.hasNext()) {
			Coordinate rangedC = coordinateDao.getCoordinateOfId(iteratorRanged.next().getId());
			coordinateServiceDao.changeCoordinateXAndY(rangedC, commanderX+3, commanderY+1);		
			iteratorRanged.remove();	
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 

		
		return auxiliarFormationMap;
	}	
}
