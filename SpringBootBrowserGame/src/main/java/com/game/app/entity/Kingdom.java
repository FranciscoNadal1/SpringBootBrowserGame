package com.game.app.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Kingdom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String kingdomName;
	
	private boolean isMainHomeland;
	
	@ManyToOne
	@JoinColumn(name = "gameProfile_id", referencedColumnName = "id")	
	private GameProfile gameProfile;
	
/*	
	@OneToMany
	@JoinColumn(name = "kingdom_id", referencedColumnName = "id")	
//	private Map<String,Building> buildings;
	private List<Building> buildings;
*/	
	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "building_id", referencedColumnName = "id")
	private List<Building> buildings;
	*/
	Kingdom(){
		this.kingdomName = "Kingdom";
		this.isMainHomeland = true;
	}
	
	Kingdom(User user){		
		kingdomName = user.getUsername() + "'s kingdom";
	}
	
	public Kingdom(String user){		
		kingdomName = user + "'s kingdom";
	}
	////////////////////////////////

	
	public String getKingdomName() {
		return kingdomName;
	}/*
	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuilding(List<Building> building) {
		this.buildings = building;
	}
	*/
/*
	public Map<String, Building> getBuildings() {
		return buildings;
	}

	public void setBuilding(Map<String, Building> building) {
		this.buildings = building;
	}
*/
	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
	}

	public boolean isMainHomeland() {
		return isMainHomeland;
	}

	public void setMainHomeland(boolean isMainHomeland) {
		this.isMainHomeland = isMainHomeland;
	}

	public GameProfile getGameProfile() {
		return gameProfile;
	}

	public void setGameProfile(GameProfile gameProfile) {
		this.gameProfile = gameProfile;
	}

	public int getId() {
		return id;
	}
	
	
}
