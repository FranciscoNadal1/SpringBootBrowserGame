package com.game.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.game.app.dao.IGameProfile;
import com.game.app.entity.User;
import com.game.app.service.IUserService;

@Controller
public class GameController {
	
	@Autowired
	private IUserService daoUserService;
	
	@GetMapping(value = "/test")
	public String test(Model model) {

		User user = new User("admin");
		daoUserService.createNewUser(user);
		/////////////////////
		/*
		
		GameProfile gameProfile = new GameProfile(user);
		

		user.setGameProfile(gameProfile);	

		gameProfile.setUser(user);
		daoGameProfile.save(gameProfile);	
		daoUser.save(user);
		*/
		////////////////////

		model.addAttribute("game", user.getGameProfile());
		return "test";
	}
}
