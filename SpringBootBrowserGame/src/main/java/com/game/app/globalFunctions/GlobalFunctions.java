package com.game.app.globalFunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.game.app.dao.IKingdom;
import com.game.app.dao.IUser;
import com.game.app.entity.Building;
import com.game.app.entity.Kingdom;
import com.game.app.entity.User;
import com.game.app.entity.buildings.Farm;
import com.game.app.entity.buildings.Forge;
import com.game.app.entity.buildings.Quarry;
import com.game.app.entity.buildings.Sawmill;
import com.game.app.service.IBuildingService;

@Component
public class GlobalFunctions {


	@Autowired
	private IUser userDao;

	@Autowired
	private IKingdom kingdomDao;

	@Autowired
	private IBuildingService buildingService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void mockNewUser() {
		User user = new User("admin");		
		userDao.save(user);
		Kingdom newKingdom = new Kingdom(user.getUsername());
		newKingdom.setGameProfile(user.getGameProfile());
		kingdomDao.save(newKingdom);

//		addDefaultBuildings(user);

		Building newFarm = new Farm();
		Building newQuarry = new Quarry();
		Building newSawmill = new Sawmill();
		Building newForge = new Forge();

		newFarm.setKingdom(newKingdom);
		newQuarry.setKingdom(newKingdom);
		newSawmill.setKingdom(newKingdom);
		newForge.setKingdom(newKingdom);

		buildingService.save(newFarm);
		buildingService.save(newQuarry);
		buildingService.save(newSawmill);
		buildingService.save(newForge);
		
		
	/*	
		Building newBuilding = null;
		newBuilding = new Farm();
		newBuilding.setKingdom(newKingdom);
		buildingDao.save(newBuilding);
		*/
		//user.
//		user.getGameProfile().getKingdomList().add(new Kingdom("ey"));
	}
	
	
	public void addDefaultBuildings(User user){

		User currentUser = user;

		
		Kingdom currentKingdom = kingdomDao.findByGameProfile(currentUser.getGameProfile());
		

		
		Building newFarm = new Farm();
		Building newQuarry = new Quarry();
		Building newSawmill = new Sawmill();
		Building newForge = new Forge();

		newFarm.setKingdom(currentKingdom);
		newQuarry.setKingdom(currentKingdom);
		newSawmill.setKingdom(currentKingdom);
		newForge.setKingdom(currentKingdom);
		
		buildingService.save(newFarm);
		buildingService.save(newQuarry);
		buildingService.save(newSawmill);
		buildingService.save(newForge);

		
	}
	
}
