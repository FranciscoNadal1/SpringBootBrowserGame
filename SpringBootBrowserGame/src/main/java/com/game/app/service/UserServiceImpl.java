package com.game.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.dao.IGameProfile;
import com.game.app.dao.IUser;
import com.game.app.entity.GameProfile;
import com.game.app.entity.User;
import com.game.app.service.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	public IUser userDao;
	
	@Autowired
	public IGameProfile gameProfileDao;
	
	@Override
	public List<User> listAllUsers() {
		return (List<User>) userDao.findAll();
	}
	
	
//	User user = new User("admin");
//	GameProfile gameProfile = new GameProfile();
	
//	gameProfile.setUser(user);
//	user.setGameProfile(gameProfile);

//	daoUser.save(user);
//	daoGameProfile.save(gameProfile);		
	

	
	public void saveOrEditUser(User user) {		
		userDao.save(user);				
	}	
	
	
}
