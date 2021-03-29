package com.game.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.app.dao.IRequirements;
import com.game.app.entity.Requirements;

@Service
public class RequirementsServiceImpl implements IRequirementsService {

	@Autowired
	private IRequirements requirementDao;
	

	public void newRequirement(Requirements requirement) {		
		requirementDao.save(requirement);				
	}
	
	public void baseRequirements() {
		Requirements foo[] = { 
				new Requirements("Farm", 0, 50, 10, 0,0),
					new Requirements("Farm", 1, 100, 200, 10,0),
					new Requirements("Farm", 2, 200, 400, 10,0),
					new Requirements("Farm", 3, 300, 500, 10,0),
					new Requirements("Farm", 4, 400, 600, 10,0),
					new Requirements("Farm", 5, 500, 700, 10,0),
					new Requirements("Farm", 6, 600, 800, 10,0),
					new Requirements("Farm", 7, 700, 900, 20,0),
					new Requirements("Farm", 8, 800, 1000, 30,0),
					new Requirements("Farm", 9, 900, 1100, 40,0),
					new Requirements("Farm", 10, 1000, 1200, 50,0),

					new Requirements("Quarry", 0, 100, 200, 10,0),
					new Requirements("Quarry", 1, 100, 200, 10,0),
					new Requirements("Quarry", 2, 200, 400, 10,0),
					new Requirements("Quarry", 3, 300, 500, 10,0),
					new Requirements("Quarry", 4, 400, 600, 10,0),
					new Requirements("Quarry", 5, 500, 700, 10,0),
					new Requirements("Quarry", 6, 600, 800, 10,0),
					new Requirements("Quarry", 7, 700, 900, 20,0),
					new Requirements("Quarry", 8, 800, 1000, 30,0),
					new Requirements("Quarry", 9, 900, 1100, 40,0),
					new Requirements("Quarry", 10, 1000, 1200, 50,0),

					new Requirements("Sawmill", 0, 100, 200, 10,0),
					new Requirements("Sawmill", 1, 100, 200, 10,0),
					new Requirements("Sawmill", 2, 200, 400, 10,0),
					new Requirements("Sawmill", 3, 300, 500, 10,0),
					new Requirements("Sawmill", 4, 400, 600, 10,0),
					new Requirements("Sawmill", 5, 500, 700, 10,0),
					new Requirements("Sawmill", 6, 600, 800, 10,0),
					new Requirements("Sawmill", 7, 700, 900, 20,0),
					new Requirements("Sawmill", 8, 800, 1000, 30,0),
					new Requirements("Sawmill", 9, 900, 1100, 40,0),
					new Requirements("Sawmill", 10, 1000, 1200, 50,0),

					new Requirements("Forge", 0, 100, 200, 10,0),
					new Requirements("Forge", 1, 100, 200, 10,0),
					new Requirements("Forge", 2, 200, 400, 10,0),
					new Requirements("Forge", 3, 300, 500, 10,0),
					new Requirements("Forge", 4, 400, 600, 10,0),
					new Requirements("Forge", 5, 500, 700, 10,0),
					new Requirements("Forge", 6, 600, 800, 10,0),
					new Requirements("Forge", 7, 700, 900, 20,0),
					new Requirements("Forge", 8, 800, 1000, 30,0),
					new Requirements("Forge", 9, 900, 1100, 40,0),
					new Requirements("Forge", 10, 1000, 1200, 50,0),
					
					
		};
		Iterable<Requirements> iterable = Arrays.asList(foo);
		
		requirementDao.saveAll(iterable);
	}

	@Override
	public List<Requirements> getAllRequirements() {
		return (List<Requirements>) requirementDao.findAll();
	}

	@Override
	public Requirements getRequirementByNameAndLevel(String name, int level) {
		return requirementDao.findByNameAndLevel(name, level);
	}
}
