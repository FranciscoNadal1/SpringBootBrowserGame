package com.game.app.war;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImpl implements ICoordinateService {

	@Autowired
	private ICoordinate coordinateDao;
	
	@Autowired
	private FormationServiceImpl formationServiceDao;
	
	@Autowired
	private IFormation formationDao;

	@Override
	public void saveCoordinate(Coordinate coordinate) {
		coordinateDao.save(coordinate);
		
	}

	@Override
	public Coordinate findByXAndY(Formation formation, int x, int y) {
		//formation.getFormationPositions().containsKey(coordinateDao)
		
		for(Coordinate coordinate : coordinateDao.findByXAndY(x, y)) {
			if(formationServiceDao.isCoordinateInThisFormation(formation, coordinate)) {
				//System.out.println(coordinate);
				return coordinate;
			}
			
		}
		return null;
		//List<Coordinate> coordinatesByXY = (List<Coordinate>) coordinateDao.findByXAndY(x, y);
		//return formation.get
	}
	
	@Transient
	public void coordinateSwap(Coordinate one, Coordinate two) {
		
		if(!(one == null || two == null)) {
			System.out.println("one + " +one);
			System.out.println("two + " +two);
			int auxX = one.getX();
			int auxY = one.getY();
			//Coordinate aux = one;
	
			one.setX(two.getX());
			one.setY(two.getY());
	
			two.setX(auxX); 
			two.setY(auxY);
			
			coordinateDao.save(one);
			coordinateDao.save(two);	
			System.out.println("saved");
			return;
		}
		if((one == null) && !(two == null)) {
			System.out.println("one is null");
		}
		if(!(one == null) && (two == null)) {
			System.out.println("two is null");
			
		}
	}
	@Transient
	public void coordinateSwap(Formation formation, int oneX, int oneY, int twoX, int twoY) {
		/*
		Coordinate aux = one;

		one.setX(two.getX());
		one.setY(two.getY());

		two.setX(aux.getX());
		two.setY(aux.getY());
		
		coordinateDao.save(one);
		coordinateDao.save(two);		
		*/
	}

	
	
	@Override
	public void changeCoordinateXAndY(Coordinate coordinate, int x, int y) {
		// TODO Auto-generated method stub

		Formation aux = formationDao.getFormationOfCoordinate(coordinate.getId());
		Coordinate co = aux.getCoordinateFromXY(x, y);
		
		if(aux.getFormationPositions().get(co) == null) {
			System.out.println("THIS IS NULL");
			coordinate.setX(x);
			coordinate.setY(y);

			coordinateDao.save(coordinate);			
			
		}else {
			this.coordinateSwap(coordinate, co);
			System.out.println("THERE IS A UNIT HERE");
			
		}
			
		/*
		aux.getFormationPositions().get(new Coordinate(x,y));

		
		// TODO Lo que falla es aqui
		
		List<Coordinate> coo = coordinateDao.findByXAndY(x, y);
		Coordinate co = null;
		for (Coordinate c : coo) {
			if(formationServiceDao.isCoordinateInThisFormation(aux, c)) {
				co = c;
			}				
		}			
		
		if(co == null) {*/
		
	/*}else {
			System.out.println("IM HERE");
							
			
			this.coordinateSwap(coordinate, co);
		}*/

	}	
}
