package com.game.app.war;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Transient;

import com.game.app.entity.Unit;

import lombok.Getter;


@Entity
public class Formation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,  mappedBy = "id")
	 * 
	 */
	@ElementCollection
	@CollectionTable(name="unit_coordinate")
	@MapKeyJoinColumn(name="coordinate_id")
	private Map<Coordinate, Unit> units;
	
	int numberPositionsX = 10;
	int numberPositionsY = 10;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public Formation() {
		units = new HashMap<Coordinate, Unit>();
		units = fillMap(units);	

	}
	public Formation(Unit commander) {
		units = new HashMap<Coordinate, Unit>();
		units = fillMap(units);
	}
	
////////////////////////////////////////////////////////////////
	
	
	
////////////////////////////////////////////////////////////////
	public Coordinate getCoordinateFromXY(int x, int y) {
		for (Map.Entry<Coordinate, Unit> entry : this.getFormationPositions().entrySet()) {
			if(entry.getKey().getX() == x && entry.getKey().getY() == y)
				return entry.getKey();
		}
		return null;		
	}
	public Map<Coordinate, Unit> fillMap(/*int numberPositionsX, int numberPositionsY, */Map<Coordinate, Unit> map) {
		
		for(int x = 0; x <= this.numberPositionsX; x++){
			for(int y = 0; y <= numberPositionsY; y++){
				map.put(new Coordinate(x,y), null);
			}
	}
		return units;
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
		return units;
	}

	public void setFormationPositions(Map<Coordinate, Unit> formationPositions) {
		this.units = formationPositions;
	}
	

	public boolean hasUnit(Coordinate coordinate) {
		try {
		if(this.units.get(coordinate).equals(null))
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
