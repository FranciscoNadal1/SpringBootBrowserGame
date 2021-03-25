package com.game.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.dao.IGameProfile;
import com.game.app.entity.GameProfile;

@Service
public class GameProfileServiceImpl implements IGameProfileService{

	@Autowired
	private IGameProfile gameProfileDao;
	
	@Override
	public void save(GameProfile gameProfile) {
		gameProfileDao.save(gameProfile);
	}

}
