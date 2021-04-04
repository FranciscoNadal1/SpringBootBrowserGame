package com.game.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.game.app.entity.troops.Archer;
import com.game.app.entity.troops.Commander;
import com.game.app.entity.troops.Legionary;
import com.game.app.globalFunctions.GlobalFunctions;
import com.game.app.service.interfaces.IBuildingService;
import com.game.app.service.interfaces.IRequirementsService;
import com.game.app.service.interfaces.IUnitService;
import com.game.app.service.interfaces.IUserService;
import com.game.app.war.Coordinate;
import com.game.app.war.Formation;
import com.game.app.war.ICoordinate;
import com.game.app.war.ICoordinateService;
import com.game.app.war.IFormation;

import net.minidev.json.JSONObject;

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
	private IFormation formationDao;
	@Autowired
	private ICoordinate coordinationDao;
	@Autowired
	private ICoordinateService coordinationServiceDao;
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
		model.addAttribute("unitFormation", commanderList);
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
	
	@GetMapping(value = "/commander/{id}")
	public String showCommander(Model model, @PathVariable(value = "id") int id) {
		addAttributesToModel(model);			
		Unit commander = unitService.getUnit(id);
		model.addAttribute("commander", commander);

		Formation formation =  ((Commander)commander).getTroopFormation();
		model.addAttribute("formationMap", formation.getFormationPositions());


		
		List<Unit> unassignedUnit = unitService.findUnitsByCommanderIsNull();
		List<Unit> assignedUnit = unitService.findUnitsAssignedToCommander(commander);
		
		
		model.addAttribute("assignedUnits", globalFun.groupUnits(assignedUnit));
		model.addAttribute("unassignedUnits", globalFun.groupUnits(unassignedUnit));
		model.addAttribute("numberAssignedUnits", unitService.findUnitsAssignedToCommander(commander).size());
		
		return "commander";
	}
	
	
	@GetMapping(value = "/commander/{id}/assigned")
	public String showCommanderAssigned(Model model, @PathVariable(value = "id") int id) {
		model.addAttribute("assigned", true);
		return showCommander(model, id);
	}
	@GetMapping(value = "/commander/{id}/formation")
	public String showCommanderFormation(Model model, @PathVariable(value = "id") int id) {
		model.addAttribute("formation", true);
		return showCommander(model, id);
	}	
	
	
	@GetMapping(value = "/addToCommander/{idCommander}/unit/{idUnit}")
	public String addUnitToCommander(Model model, @PathVariable(value = "idCommander") int idCommander, @PathVariable(value = "idUnit") int idUnit) {

		Unit commander = unitService.getUnit(idCommander);
		Unit unit = unitService.getUnit(idUnit);
		
		unitService.addUnitToCommander(commander, unit);				
		
		return "redirect:/commander/" + idCommander;
	}
	
	
	@GetMapping(value = "/removeFromCommander/{idCommander}/unit/{idUnit}")
	public String removeUnitFromCommander(Model model, @PathVariable(value = "idCommander") int idCommander, @PathVariable(value = "idUnit") int idUnit) {

		Unit commander = unitService.getUnit(idCommander);
		Unit unit = unitService.getUnit(idUnit);
		
		unit.setCommander(null);
		unitService.newUnit(unit);
		return "redirect:/commander/" + idCommander;
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
		unitService.trainUnit(currentKingdom, unitName);

		return "redirect:/barracks";
	}	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
