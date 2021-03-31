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
import com.game.app.entity.buildings.production.Farm;
import com.game.app.entity.buildings.production.Forge;
import com.game.app.entity.buildings.production.Quarry;
import com.game.app.entity.buildings.production.Sawmill;
import com.game.app.entity.buildings.storage.FoodWharehouse;
import com.game.app.entity.buildings.storage.RockWharehouse;
import com.game.app.entity.buildings.storage.SteelWharehouse;
import com.game.app.entity.buildings.storage.WoodWharehouse;
import com.game.app.entity.buildings.troops.Barracks;
import com.game.app.entity.buildings.troops.MageTower;
import com.game.app.entity.buildings.troops.Stable;
import com.game.app.service.IBuildingService;
import com.game.app.service.IRequirementsService;
import com.game.app.singleton.StaticRequirementsSingleton;

@Component
public class GlobalFunctions {


	@Autowired
	private IUser userDao;

	@Autowired
	private IKingdom kingdomDao;

	@Autowired
	private IBuildingService buildingService;
	
	@Autowired
	private IRequirementsService requirementsService;
	
	@Autowired
	private static IRequirementsService staticRequirements;
	
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

		Building newFoodStorage = new FoodWharehouse();
		Building newWoodStorage = new WoodWharehouse();
		Building newRockStorage = new RockWharehouse();
		Building newSteeltorage = new SteelWharehouse();
		
		Building barracks = new Barracks();
		Building mageTower = new MageTower();
		Building stable = new Stable();


		newFarm.setKingdom(newKingdom);
		newQuarry.setKingdom(newKingdom);
		newSawmill.setKingdom(newKingdom);
		newForge.setKingdom(newKingdom);		

		newFoodStorage.setKingdom(newKingdom);
		newWoodStorage.setKingdom(newKingdom);
		newRockStorage.setKingdom(newKingdom);
		newSteeltorage.setKingdom(newKingdom);

		barracks.setKingdom(newKingdom);
		mageTower.setKingdom(newKingdom);
		stable.setKingdom(newKingdom);


		buildingService.save(newFarm);
		buildingService.save(newQuarry);
		buildingService.save(newSawmill);
		buildingService.save(newForge);
		
		buildingService.save(newFoodStorage);		
		buildingService.save(newWoodStorage);
		buildingService.save(newRockStorage);
		buildingService.save(newSteeltorage);

		buildingService.save(barracks);
		buildingService.save(mageTower);
		buildingService.save(stable);
		
		requirementsService.baseRequirements();
		StaticRequirementsSingleton.getInstance().populate();
		
		//RequirementsSingleton.getInstance().populate();
	//	RequirementsSingleton.getInstance().addToArray(new Requirements("Farm", 0, 50, 10, 0, 0)); 
	//	RequirementsSingleton.getInstance().addToArray(new Requirements("Farm", 1, 100, 200, 10, 0)); 
		
		
		
		
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
