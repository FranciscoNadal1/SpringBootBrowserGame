package com.game.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.game.app.dao.IUser;
import com.game.app.entity.Unit;
import com.game.app.entity.User;
import com.game.app.entity.troops.Commander;
import com.game.app.service.interfaces.IUnitService;
import com.game.app.war.Coordinate;
import com.game.app.war.IFormation;

import net.minidev.json.JSONObject;

@RestController
public class RestControllerApp {
	
	
	@Autowired
	private IUnitService unitService;
	
	@Autowired
	private IUser userDao;
	
	@Autowired
	private IFormation formationDao;
	
	
	 @GetMapping(path = "/returnFormationRest/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	    public JSONObject getFormationRest(@PathVariable(value = "id") int id)
	    {
		 	JSONObject responseJson = new JSONObject();
		 	JSONObject commanderData = new JSONObject();
			User currentUser = userDao.findById(1);		 
			Unit commander = unitService.getUnit(id);
			

			commanderData.appendField("Owner", currentUser.getUsername());
			commanderData.appendField("Unit", commander.getName());
			
			
			commanderData.appendField("Commander name", ((Commander)commander).getCommanderName());
			

			responseJson.appendField("Commander", commanderData);
			
			Map<Coordinate, Unit> map = ((Commander)commander).getTroopFormation().getFormationPositions();

		 	JSONObject coordinates = new JSONObject();
		 	
			for (Map.Entry<Coordinate, Unit> entry : map.entrySet()) {
			    System.out.println(entry.getKey() + "/" + entry.getValue());			        

			 	JSONObject coordinate = new JSONObject();
			    //responseJson.appendField(entry.getKey().getX() +"-"+entry.getKey().getY(), ((Unit)entry).getName());	
			 	
			    coordinate.appendField("name", ((Unit)entry.getValue()).getName());
			    coordinate.appendField("level", ((Unit)entry.getValue()).getLevel());
			    coordinate.appendField("portrait", ((Unit)entry.getValue()).getPortrait());
			    
			    coordinates.appendField("x"+entry.getKey().getX() +"-y"+entry.getKey().getY(), coordinate);
			}
			commanderData.appendField("Coordinates", coordinates);

			return responseJson;
	    }
}
