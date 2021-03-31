package com.game.app.controllers;

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
import com.game.app.entity.Requirements;
import com.game.app.entity.User;
import com.game.app.entity.buildings.production.Farm;
import com.game.app.entity.buildings.production.Forge;
import com.game.app.entity.buildings.production.Quarry;
import com.game.app.entity.buildings.production.Sawmill;
import com.game.app.globalFunctions.GlobalFunctions;
import com.game.app.service.IBuildingService;
import com.game.app.service.IRequirementsService;
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
	
	@Autowired
	private IRequirementsService requirementsServiceDao;
	
	@GetMapping(value = "/buildings")
	public String test(Model model) {
		User currentUser = userDao.findById(1);
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());
		Map<String, Building> buildings= currentKingdom.getBuildings();
		
//		currentUser.getGameProfile().getKingdomList()
/*
		User user = new User("admin");		
		userDao.save(user);
*/		
		model.addAttribute("game", currentUser.getGameProfile());
		model.addAttribute("buildings", buildings);
		model.addAttribute("kingdom", currentKingdom);
		/*
		List<Requirements> requirements = requirementsServiceDao.getAllRequirements();	
		Requirements req  = requirements.get(1);
			System.out.println(req.getName() + " - " + req.getLevel());
			*/
	//		Requirements requ = requirementsServiceDao.getRequirementByNameAndLevel("Farm", 1);
			
	//	Requirements requs = GlobalFunctions.getRequirement(requ.getName(), requ.getLevel());
	//		System.out.println("AAAAA-" + requs.getName());
			
		return "buildings";
	}

	@GetMapping(value = "/build/{building}")
	public String buildFarm(Model model, @PathVariable(value = "building") String building) {
		
		User currentUser = userDao.findById(1);

	//	currentUser.getGameProfile()currentUser
		
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());
		

		model.addAttribute("game", currentUser.getGameProfile());
		
		
//		currentKingdom.getBuildings().put("Farm", new Building());
//		currentKingdom.getBuildings().add(new Building());
//		kingdomDao.save(currentKingdom);
//		kingdomDao.fi
		
//	currentUser.getGameProfile().
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
		System.out.println(levelingUpBuilding.getHp());
		System.out.println(levelingUpBuilding.getLevel());
		System.out.println(levelingUpBuilding.getHp());
		/*
		Building farm = new Farm();
		farm = buildingDao.findByName("farm");
*/
		levelingUpBuilding.levelUp();
		buildingServiceDao.save(levelingUpBuilding);

		return "redirect:/buildings";
	}	
	
}
