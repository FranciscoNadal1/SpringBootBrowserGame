package com.game.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.dao.IKingdom;
import com.game.app.entity.Kingdom;

@Service
public class KingdomServiceImpl implements IKingdomService {

	@Autowired
	private IKingdom kingdomDao;
	

	public void saveKingdom(Kingdom kingdom) {		
		kingdomDao.save(kingdom);				
	}	
}
