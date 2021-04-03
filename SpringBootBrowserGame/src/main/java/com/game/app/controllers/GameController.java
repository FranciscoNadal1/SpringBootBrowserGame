package com.game.app.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.game.app.entity.Unit;
import com.game.app.entity.User;
import com.game.app.entity.buildings.production.Farm;
import com.game.app.entity.buildings.production.Forge;
import com.game.app.entity.buildings.production.Quarry;
import com.game.app.entity.buildings.production.Sawmill;
import com.game.app.entity.troops.*;
import com.game.app.globalFunctions.GlobalFunctions;
import com.game.app.service.interfaces.IBuildingService;
import com.game.app.service.interfaces.IRequirementsService;
import com.game.app.service.interfaces.IUnitService;
import com.game.app.service.interfaces.IUserService;

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
	@Autowired
	private IRequirementsService requirementsServiceDao;
	@Autowired
	private IUnitService unitService;
	
	@Autowired
	private GlobalFunctions globalFun;
	
	public Model addAttributesToModel(Model model) {
		User currentUser = userDao.findById(1);
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());
		Map<String, Building> buildings= currentKingdom.getBuildings();
		List<Unit> units = unitService.getAllUnitsOfKingdom(currentKingdom);
		List<List<Unit>> sortedListOfListUnits = globalFun.groupUnits(units);
		List<Unit> commanderList = globalFun.getCommanderList(units);
		
		model.addAttribute("game", currentUser.getGameProfile());
		model.addAttribute("buildings", buildings);
		model.addAttribute("kingdom", currentKingdom);
		model.addAttribute("units", sortedListOfListUnits);
		model.addAttribute("commanderList", commanderList);
		return model;
	}
	
	
	@GetMapping(value = "/buildings")
	public String buildings(Model model) {
		addAttributesToModel(model);	
		return "buildings";
	}
	
	@GetMapping(value = "/units")
	public String units(Model model) {
		addAttributesToModel(model);			
		return "units";
	}

	@GetMapping(value = "/barracks")
	public String barracks(Model model) {
		addAttributesToModel(model);		
		
		// TODO this should obviously be a separate object
		Map<String, String> legionary= new HashMap<String, String>();
		Map<String, String> archer= new HashMap<String, String>();
		Map<String, String> commander= new HashMap<String, String>();
		
		/////////////////////////////////////////////////////////////////
		legionary.put("portrait", Legionary.getStaticPortrait());
		legionary.put("name", Legionary.getStaticName());
		legionary.put("description", Legionary.getStaticDescription());
		/////////////////////////////////////////////////////////////////

		archer.put("portrait", Archer.getStaticPortrait());
		archer.put("name", Archer.getStaticName());
		archer.put("description", Archer.getStaticDescription());
		/////////////////////////////////////////////////////////////////

		commander.put("portrait", Commander.getStaticPortrait());
		commander.put("name", Commander.getStaticName());
		commander.put("description", Commander.getStaticDescription());
		/////////////////////////////////////////////////////////////////
		
		
		
		Map<String, Map<String,String>> availableUnits = new HashMap<String, Map<String,String>>();
		
		availableUnits.put("Legionary", legionary);
		availableUnits.put("Archer", archer);
		availableUnits.put("Commander", commander);
		
		
		model.addAttribute("availableUnits", availableUnits);
		
		return "barracks";
	}
	@Deprecated
	@GetMapping(value = "/build/{building}")
	public String buildFarm(Model model, @PathVariable(value = "building") String building) {
		
		User currentUser = userDao.findById(1);
		
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());
		model.addAttribute("game", currentUser.getGameProfile());		
		Building newBuilding = null;
		switch(building) {
		  case "Farm":
				 newBuilding = new Farm();
		    break;
		  case "Quarry":
				 newBuilding = new Quarry();
		    break;
		  case "Forge":
				 newBuilding = new Forge();
		    break;
		  case "Sawmill":
				 newBuilding = new Sawmill();
		    break;
		  default:
				 newBuilding = new Farm();
		}
		newBuilding.setKingdom(currentKingdom);
		buildingServiceDao.save(newBuilding);

		return "redirect:/buildings";
	}
	@GetMapping(value = "/levelUp/{building}")
	public String levelUpBuilding(Model model, @PathVariable(value = "building") String building) {
		User currentUser = userDao.findById(1);
		
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());		
		Building levelingUpBuilding = currentKingdom.getBuildings().get(building);
		levelingUpBuilding.levelUp();
		buildingServiceDao.save(levelingUpBuilding);

		return "redirect:/buildings";
	}	
	
	@GetMapping(value = "/train/{unitName}")
	public String trainUnit(Model model, @PathVariable(value = "unitName") String unitName) {
		User currentUser = userDao.findById(1);
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());		

		Class cls;
		try {
			if(currentKingdom.troopIsUnlocked(unitName)) {
				cls = Class.forName("com.game.app.entity.troops."+unitName);
				Unit newUnit= (Unit) cls.getDeclaredConstructor().newInstance();
				newUnit.setKingdom(currentKingdom);
				unitService.newUnit(newUnit);
			}
			else
				throw new RuntimeException(unitName + " is not unlocked");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "redirect:/barracks";
	}		
}
