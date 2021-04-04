package com.game.app.war;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;

import com.game.app.entity.Unit;

import lombok.Getter;


@Entity
@Getter
public class Formation implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,  mappedBy = "id")
	 * 
	 */
	@ElementCollection
	@MapKeyJoinColumn(name="coordinate_id")
	private Map<Coordinate, Unit> formationPositions;
	
	int numberPositionsX = 10;
	int numberPositionsY = 10;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*
	@OneToOne(cascade = {CascadeType.ALL})
	public Unit commander;
	*/
	
	public Formation() {
		formationPositions = new HashMap<Coordinate, Unit>();
		formationPositions = fillMap(formationPositions);	

	}
	public Formation(Unit commander) {
		formationPositions = new HashMap<Coordinate, Unit>();
		formationPositions = fillMap(formationPositions);
	}
	
////////////////////////////////////////////////////////////////
	public Map<Coordinate, Unit> fillMap(/*int numberPositionsX, int numberPositionsY, */Map<Coordinate, Unit> map) {
		
		for(int x = 0; x <= this.numberPositionsX; x++){
			for(int y = 0; y <= numberPositionsY; y++){
				map.put(new Coordinate(x,y), null);
			}
	}
		return formationPositions;
	}
	public Unit getUnitFromPosition(int x, int y) {		
		return this.getFormationPositions().get(new Coordinate(x,y));		
	}
	
	public static Coordinate getCoordinate(int x, int y) {
		
		return new Coordinate(x,y);
		/*
		this.getFormationPositions().containsKey(key)*/
		
	}		
	
	public Map<Coordinate, Unit> getFormationPositions() {
		return formationPositions;
	}

	public void setFormationPositions(Map<Coordinate, Unit> formationPositions) {
		this.formationPositions = formationPositions;
	}
	

	public boolean hasUnit(Coordinate coordinate) {
		try {
		if(this.formationPositions.get(coordinate).equals(null))
			return false;
		return true;
		}catch(Exception e) {
			return false;			
		}
	}
	public int getNumberPositionsX() {
		return numberPositionsX;
	}
	public int getNumberPositionsY() {
		return numberPositionsY;
	}
	
	
	
	
}
