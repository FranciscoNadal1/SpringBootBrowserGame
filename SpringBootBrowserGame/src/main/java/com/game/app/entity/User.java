package com.game.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user", updatable = false, nullable = true)
	private GameProfile gameProfile;
*/
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private GameProfile gameProfile;
	
	
	public User() {
	}
	
	public User(String username) {
		this.username = username;
		this.gameProfile = new GameProfile(this);
		

		
		//newKingdom.setGameProfile(this);
	//	this.gameProfile.getKingdomList().add(new Kingdom("asdf"));
		
	}
////////////////////////////////////////////////////////////////////
	

	public int getId() {
		return id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public GameProfile getGameProfile() {
		return gameProfile;
	}

	public void setGameProfile(GameProfile gameProfile) {
		this.gameProfile = gameProfile;
	}
	
	
	
}
