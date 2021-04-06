package com.game.app.war;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "coordinate")
public class Coordinate  implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int x;
	private int y;

	public Coordinate() {
		
	}
	

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[x: " + x + ", y:" + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Coordinate coordinateToCompare = (Coordinate) obj;
		if(coordinateToCompare.getX() == this.getX())
			if(coordinateToCompare.getY() == this.getY())
				return true;		
		return false;
	}

	
	
/////////////////////////////////////////////////////////////

	public int getX() {
		return x;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
