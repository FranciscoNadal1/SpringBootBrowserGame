package com.game.app.service.interfaces;

import java.util.List;

import com.game.app.entity.Kingdom;

public interface IKingdomService {
	public void saveKingdom(Kingdom kingdom);

	public List<Kingdom> getAllKingdoms();
}
