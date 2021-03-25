package com.game.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.game.app.dao.IGameProfile;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user", updatable = false, nullable = false)
	private GameProfile gameProfile;

	public User() {
	}
	
	public User(String username) {
		this.username = username;
		this.gameProfile = new GameProfile();
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
