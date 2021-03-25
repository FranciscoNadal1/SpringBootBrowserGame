package com.game.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.game.app.dao.IGameProfile;
import com.game.app.dao.IUser;
import com.game.app.entity.GameProfile;
import com.game.app.entity.User;
import com.game.app.service.IGameProfileService;
import com.game.app.service.IUserService;

@Controller
public class GameController {
	
	@Autowired
	private IUserService daoUserService;
	

	@Autowired
	private IUser userDao;
	@Autowired
	private IGameProfile gameProfileDao;
	
	@GetMapping(value = "/test")
	public String test(Model model) {
		User currentUser = userDao.findById(1);
/*
		User user = new User("admin");		
		userDao.save(user);
*/		
		
		model.addAttribute("game", currentUser.getGameProfile());
		
		return "test";
	}
}
