package com.game.app.service;

import java.util.List;

import com.game.app.entity.GameProfile;
import com.game.app.entity.User;


public interface IUserService {


	public List<User> listAllUsers();
	public void createNewUser(User user);
}
