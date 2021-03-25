package com.game.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.game.app.dao.IBuilding;
import com.game.app.dao.IGameProfile;
import com.game.app.dao.IKingdom;
import com.game.app.dao.IUser;
import com.game.app.entity.Building;
import com.game.app.entity.Kingdom;
import com.game.app.entity.User;
import com.game.app.entity.buildings.Farm;
import com.game.app.service.IBuildingService;
import com.game.app.service.IUserService;

@Controller
public class GameController {
	
	@Autowired
	private IUserService daoUserService;
	

	@Autowired
	private IUser userDao;
	@Autowired
	private IGameProfile gameProfileDao;
	@Autowired
	private IKingdom kingdomDao;
	@Autowired
	private IBuilding buildingDao;
	@Autowired
	private IBuildingService buildingServiceDao;
	
	@GetMapping(value = "/test")
	public String test(Model model) {
		User currentUser = userDao.findById(1);
		
//		currentUser.getGameProfile().getKingdomList()
/*
		User user = new User("admin");		
		userDao.save(user);
*/		
		
		model.addAttribute("game", currentUser.getGameProfile());
		
		return "test";
	}

	@GetMapping(value = "/buildFarm")
	public String buildFarm(Model model) {
		User currentUser = userDao.findById(1);

	//	currentUser.getGameProfile()currentUser
		
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());
		
		System.out.println("Current realm : "+currentKingdom.getKingdomName());

		model.addAttribute("game", currentUser.getGameProfile());
		
		
//		currentKingdom.getBuildings().put("Farm", new Building());
//		currentKingdom.getBuildings().add(new Building());
//		kingdomDao.save(currentKingdom);
//		kingdomDao.fi
		
//	currentUser.getGameProfile().
		Building newFarm = new Farm();
		newFarm.setKingdom(currentKingdom);
		buildingServiceDao.save(newFarm);

		return "redirect:/test";
	}
	@GetMapping(value = "/levelUp/{building}")
	public String levelUpBuilding(Model model, @PathVariable(value = "building") String building) {
		User currentUser = userDao.findById(1);
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());
		
		Building farm = new Farm();
		farm = buildingDao.findByName("farm");

		farm.levelUp();
		buildingServiceDao.save(farm);

		return "redirect:/test";
	}	
	
}
