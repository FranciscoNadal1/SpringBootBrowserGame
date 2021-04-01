package com.game.app.service.interfaces;

import java.util.List;

import com.game.app.entity.GameProfile;
import com.game.app.entity.User;


public interface IUserService {


	public List<User> listAllUsers();
	public void saveOrEditUser(User user);
	
}
