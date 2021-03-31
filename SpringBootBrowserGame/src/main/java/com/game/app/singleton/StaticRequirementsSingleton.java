package com.game.app.singleton;

import java.util.ArrayList;
import java.util.List;

public class StaticRequirementsSingleton {

/*
	private static final List<StaticRequirements> requirementList {
		new StaticRequirements("Farm", 0, 50, 10, 0, 0)
		
	};
	*/

    private static StaticRequirementsSingleton mInstance;
    
	public  ArrayList<StaticRequirements> requirementList = new ArrayList<StaticRequirements>();

    public static StaticRequirementsSingleton getInstance() {
        if(mInstance == null)
            mInstance = new StaticRequirementsSingleton();

        return mInstance;
    }
    
    public void addToArray(StaticRequirements req) {
    	requirementList.add(req);
       }
    
	public  void populate() {

		//	Wood, Rock, Steel, Food
		requirementList.add(new StaticRequirements("Farm", 1, 100, 200, 10, 0));		
		requirementList.add(new StaticRequirements("Farm", 2, 200, 400, 10, 0));
		requirementList.add(new StaticRequirements("Farm", 3, 300, 500, 10, 0));
		requirementList.add(new StaticRequirements("Farm", 4, 400, 600, 10, 0));
		requirementList.add(new StaticRequirements("Farm", 5, 500, 700, 10, 0));
		requirementList.add(new StaticRequirements("Farm", 6, 600, 800, 10, 0));
		requirementList.add(new StaticRequirements("Farm", 7, 700, 900, 20, 0));
		requirementList.add(new StaticRequirements("Farm", 8, 800, 1000, 30, 0));
		requirementList.add(new StaticRequirements("Farm", 9, 900, 1100, 40, 0));
		requirementList.add(new StaticRequirements("Farm", 10, 1000, 1200, 50, 0));

		requirementList.add(new StaticRequirements("Quarry", 1, 100, 200, 10, 0));
		requirementList.add(new StaticRequirements("Quarry", 2, 200, 400, 10, 0));
		requirementList.add(new StaticRequirements("Quarry", 3, 300, 500, 10, 0));
		requirementList.add(new StaticRequirements("Quarry", 4, 400, 600, 10, 0));
		requirementList.add(new StaticRequirements("Quarry", 5, 500, 700, 10, 0));
		requirementList.add(new StaticRequirements("Quarry", 6, 600, 800, 10, 0));
		requirementList.add(new StaticRequirements("Quarry", 7, 700, 900, 20, 0));
		requirementList.add(new StaticRequirements("Quarry", 8, 800, 1000, 30, 0));
		requirementList.add(new StaticRequirements("Quarry", 9, 900, 1100, 40, 0));
		requirementList.add(new StaticRequirements("Quarry", 10, 1000, 1200, 50, 0));

		requirementList.add(new StaticRequirements("Sawmill", 1, 100, 200, 10, 0));
		requirementList.add(new StaticRequirements("Sawmill", 2, 200, 400, 10, 0));
		requirementList.add(new StaticRequirements("Sawmill", 3, 300, 500, 10, 0));
		requirementList.add(new StaticRequirements("Sawmill", 4, 400, 600, 10, 0));
		requirementList.add(new StaticRequirements("Sawmill", 5, 500, 700, 10, 0));
		requirementList.add(new StaticRequirements("Sawmill", 6, 600, 800, 10, 0));
		requirementList.add(new StaticRequirements("Sawmill", 7, 700, 900, 20, 0));
		requirementList.add(new StaticRequirements("Sawmill", 8, 800, 1000, 30, 0));
		requirementList.add(new StaticRequirements("Sawmill", 9, 900, 1100, 40, 0));
		requirementList.add(new StaticRequirements("Sawmill", 10, 1000, 1200, 50, 0));

		requirementList.add(new StaticRequirements("Forge", 1, 100, 200, 10, 0));
		requirementList.add(new StaticRequirements("Forge", 2, 200, 400, 10, 0));
		requirementList.add(new StaticRequirements("Forge", 3, 300, 500, 10, 0));
		requirementList.add(new StaticRequirements("Forge", 4, 400, 600, 10, 0));
		requirementList.add(new StaticRequirements("Forge", 5, 500, 700, 10, 0));
		requirementList.add(new StaticRequirements("Forge", 6, 600, 800, 10, 0));
		requirementList.add(new StaticRequirements("Forge", 7, 700, 900, 20, 0));
		requirementList.add(new StaticRequirements("Forge", 8, 800, 1000, 30, 0));
		requirementList.add(new StaticRequirements("Forge", 9, 900, 1100, 40, 0));
		requirementList.add(new StaticRequirements("Forge", 10, 1000, 1200, 50, 0));
		
///////////////////////////////////////////////////////////////////////////////////////
////////////////		Storage
		
		requirementList.add(new StaticRequirements("Food WhareHouse", 1, 1000, 200, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 2, 2000, 400, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 3, 3000, 500, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 4, 4000, 600, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 5, 5000, 700, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 6, 6000, 800, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 7, 7000, 900, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 8, 8000, 1000, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 9, 9000, 1100, 10, 0));
		requirementList.add(new StaticRequirements("Food WhareHouse", 10, 10000, 1200, 10, 0));
		

		requirementList.add(new StaticRequirements("Rock WhareHouse", 1, 1000, 200, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 2, 2000, 400, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 3, 3000, 500, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 4, 4000, 600, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 5, 5000, 700, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 6, 6000, 800, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 7, 7000, 900, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 8, 8000, 1000, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 9, 9000, 1100, 10, 0));
		requirementList.add(new StaticRequirements("Rock WhareHouse", 10, 10000, 1200, 10, 0));
		

		requirementList.add(new StaticRequirements("Steel WhareHouse", 1, 1000, 200, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 2, 2000, 400, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 3, 3000, 500, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 4, 4000, 600, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 5, 5000, 700, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 6, 6000, 800, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 7, 7000, 900, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 8, 8000, 1000, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 9, 9000, 1100, 10, 0));
		requirementList.add(new StaticRequirements("Steel WhareHouse", 10, 10000, 1200, 10, 0));
		

		requirementList.add(new StaticRequirements("Wood WhareHouse", 1, 1000, 200, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 2, 2000, 400, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 3, 3000, 500, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 4, 4000, 600, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 5, 5000, 700, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 6, 6000, 800, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 7, 7000, 900, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 8, 8000, 1000, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 9, 9000, 1100, 10, 0));
		requirementList.add(new StaticRequirements("Wood WhareHouse", 10, 10000, 1200, 10, 0));

///////////////////////////////////////////////////////////////////////////////////////
////////////////Troops

		requirementList.add(new StaticRequirements("Barracks", 1, 1000, 200, 10, 0));
		requirementList.add(new StaticRequirements("Barracks", 2, 2000, 400, 10, 0));
		requirementList.add(new StaticRequirements("Barracks", 3, 3000, 500, 10, 0));
		requirementList.add(new StaticRequirements("Barracks", 4, 4000, 600, 10, 0));
		requirementList.add(new StaticRequirements("Barracks", 5, 5000, 700, 10, 0));
		
		requirementList.add(new StaticRequirements("Mage tower", 1, 1000, 200, 10, 0));
		requirementList.add(new StaticRequirements("Mage tower", 2, 2000, 400, 10, 0));
		requirementList.add(new StaticRequirements("Mage tower", 3, 3000, 500, 10, 0));
		requirementList.add(new StaticRequirements("Mage tower", 4, 4000, 600, 10, 0));
		requirementList.add(new StaticRequirements("Mage tower", 5, 5000, 700, 10, 0));

		requirementList.add(new StaticRequirements("Stable", 1, 1000, 200, 10, 0));
		requirementList.add(new StaticRequirements("Stable", 2, 2000, 400, 10, 0));
		requirementList.add(new StaticRequirements("Stable", 3, 3000, 500, 10, 0));
		// requirementList.addAll(foo);
	}
	public   StaticRequirements getStaticRequirementsFromNameAndLevel(String name, int level) {
		StaticRequirements required = null;
		for(StaticRequirements staticRequirements : this.requirementList) {

			
			if(staticRequirements.getLevel() == level && staticRequirements.getName().equals(name)) {
				required = staticRequirements;
				return required;
			}
		}
		return required;
	}
	public void printAllStaticRequirements() {
		System.out.println("StaticRequirements : : : ");
		for(StaticRequirements StaticRequirements : this.requirementList) {
			System.out.println("Name: "+ StaticRequirements.getName() + "- Level: " + StaticRequirements.getLevel() + "- Wood: " +  StaticRequirements.getWood());
		}
	}	
}
