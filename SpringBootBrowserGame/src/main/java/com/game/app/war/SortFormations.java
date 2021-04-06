package com.game.app.war;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.entity.Unit;

@Service
public class SortFormations {

	@Autowired
	private ICoordinate coordinateDao;
	@Autowired
	private ICoordinateService coordinateServiceDao;
	@Autowired
	private IFormation formationDao;

	public void matrixShow(Formation formation) {

		int maxX = formation.getNumberPositionsX();
		int maxY = formation.getNumberPositionsY();
		Unit commander = null;
		Coordinate commanderCoordinate = null;

		Map<Coordinate, Unit> matrixCoordinates = formation.getFormationPositions();

		for (int x = 0; x != maxX; x++) {
			for (int y = 0; y != maxY; y++) {
	//			System.out.print(coordinateServiceDao.findByXAndY(formation, x, y));
			}
	//		System.out.println();
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		for (Map.Entry<Coordinate, Unit> entry : matrixCoordinates.entrySet()) {
			if (entry.getValue().getName().equals("Commander")) {
				commander = entry.getValue();
				commanderCoordinate = coordinateDao.getCoordinateOfId(commander.getId());
				break;
			}
		}

		System.out.println("eeeey");
		System.out.println("---------------------------------");
		Coordinate emptyCoordinate = this.semiRecursiveMatrixFromCenter(matrixCoordinates, commanderCoordinate);
		System.out.println("The nearest empty coordinate is :" + emptyCoordinate);
		System.out.println();
	}
	
	public Map<Coordinate,Unit> defaultformation(Formation formation) {
		int maxX = formation.getNumberPositionsX();
		int maxY = formation.getNumberPositionsY();
		Unit commander = null;
		Coordinate commanderCoordinate = null;
		Map<Coordinate, Unit> matrixCoordinates = formation.getFormationPositions();
		Set<Unit> unitSet = new HashSet<Unit>();
		
		for (Map.Entry<Coordinate, Unit> entry : matrixCoordinates.entrySet()) {
			if (entry.getValue().getName().equals("Commander")) {
				commander = entry.getValue();
				commanderCoordinate = coordinateDao.getCoordinateOfId(commander.getId());
				break;
			}else {
				unitSet.add(entry.getValue());
			}
		}
		
		int commanderX =4;
		int commanderY =4;		
		
		coordinateServiceDao.changeCoordinateXAndY(commanderCoordinate, commanderX, commanderY);
		
		
		
		
		Iterator<Unit> iterator = unitSet.iterator();		
		while (iterator.hasNext() ) {
			Coordinate coo = coordinateDao.getCoordinateOfId(iterator.next().getId());
			Coordinate emptyCoordinate = null;
			
				emptyCoordinate = this.semiRecursiveMatrixFromCenter(matrixCoordinates, commanderCoordinate);
				 
			
			coordinateServiceDao.changeCoordinateXAndY(coo, emptyCoordinate.getX(), emptyCoordinate.getY());	
			
			iterator.remove();	
		}
		
		return matrixCoordinates;
	}

	public Coordinate semiRecursiveMatrixFromCenter(Map<Coordinate, Unit> matrix, Coordinate commander) {
		
		int index = 1;
		int middleX = commander.getX();
		int middleY = commander.getY();
		System.out.println(middleX + "-"+middleY+"<--");
		Coordinate co = null;
		
		Unit unitCmmander = matrix.get(commander);
		Formation formation = formationDao.getFormationOfUnit(unitCmmander.getId());

		while(index!=3) {
			for (int x = middleX - index; x != middleX + index + 1; x++) {
				for (int y = middleY - index; y != middleY + index + 1; y++) {
	
					if (x == middleX - index || y == middleY - index)
						try {
							System.out.println("a[" + co + "]--X" + x + "--Y" + y);
							co = coordinateServiceDao.findByXAndY(formation, x, y);		
							if(co==null)
								return new Coordinate(x,y);
							
						} catch (Exception e) {
	
						}
	
					else if (x == middleX + index || y == middleY + index)
						try {
							System.out.println("a[" + co + "]--X" + x + "--Y" + y);
							co = coordinateServiceDao.findByXAndY(formation, x, y);		
							if(co==null)
								return new Coordinate(x,y);				
						} catch (Exception e) {
	
						}
				}
			}
			index++;
		}
		
		return co;
	}

}
