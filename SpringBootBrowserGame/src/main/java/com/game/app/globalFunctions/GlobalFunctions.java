package com.game.app.globalFunctions;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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
import com.game.app.entity.buildings.storage.FoodWharehouse;
import com.game.app.entity.buildings.storage.RockWharehouse;
import com.game.app.entity.buildings.storage.SteelWharehouse;
import com.game.app.entity.buildings.storage.WoodWharehouse;
import com.game.app.entity.buildings.troops.Barracks;
import com.game.app.entity.buildings.troops.MageTower;
import com.game.app.entity.buildings.troops.Stable;
import com.game.app.entity.troops.Legionary;
import com.game.app.service.interfaces.IBuildingService;
import com.game.app.service.interfaces.IRequirementsService;
import com.game.app.service.interfaces.IUnitService;
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

	@Autowired
	private IUnitService unitService;

	@EventListener(ApplicationReadyEvent.class)
	public void mockNewUser() {
		User user = new User("admin");
		userDao.save(user);
		Kingdom newKingdom = new Kingdom(user.getUsername());
		newKingdom.setGameProfile(user.getGameProfile());
		newKingdom.setWood(5000);
		newKingdom.setRock(5000);
		newKingdom.setSteel(5000);
		kingdomDao.save(newKingdom);

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

		// RequirementsSingleton.getInstance().populate();
		// RequirementsSingleton.getInstance().addToArray(new Requirements("Farm", 0,
		// 50, 10, 0, 0));
		// RequirementsSingleton.getInstance().addToArray(new Requirements("Farm", 1,
		// 100, 200, 10, 0));

		/*
		 * Building newBuilding = null; newBuilding = new Farm();
		 * newBuilding.setKingdom(newKingdom); buildingDao.save(newBuilding);
		 */
		// user.
//		user.getGameProfile().getKingdomList().add(new Kingdom("ey"));
	}

	public List<Unit> getUnitListOfKingdom(Kingdom kingdom) {

		return unitService.getAllUnitsOfKingdom(kingdom);

	}
	public List<Unit> getCommanderList(List<Unit> splittedUnits) {
		List<Unit> commanderList = new LinkedList<Unit>();
		for (Unit unit : splittedUnits) {
			if (unit.getName().equals("Commander")) {
				commanderList.add(unit);
			}
		}
		return commanderList;
	}
	public List<List<Unit>> groupUnits(List<Unit> splittedUnits) {
		List<List<Unit>> groupedUnits = new LinkedList<List<Unit>>();

		// Places every unit on a separate List
		for (Unit unit : splittedUnits) {
			if (!unit.getName().equals("Commander")) {
				List<Unit> singleUnit = new LinkedList<Unit>();
				singleUnit.add(unit);
				groupedUnits.add(singleUnit);
			}
		}

		// Group individual units that are equal in the same list
		for (int i = 0; i != groupedUnits.size(); i++) {
			try {
				System.out.println("-----------------------------------");
				System.out.println(groupedUnits.get(i).get(0).getName());
				System.out.println(groupedUnits.get(i).get(0).getLevel());

				Unit actualUnit = groupedUnits.get(i).get(0);
				List<Unit> actualList = groupedUnits.get(i);

				if (i != groupedUnits.size())
					for (int a = i + 1; a != groupedUnits.size(); a++) {

						Unit insideForUnit = groupedUnits.get(a).get(0);
						List<Unit> insideForList = groupedUnits.get(a);

						if (actualUnit.equals(insideForUnit)) {
							actualList.add(insideForUnit);
							insideForList.clear();
						}
					}

			} catch (Exception e) {

			}
		}

		return groupedUnits;
	}

	public void addDefaultBuildings(User user) {

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
