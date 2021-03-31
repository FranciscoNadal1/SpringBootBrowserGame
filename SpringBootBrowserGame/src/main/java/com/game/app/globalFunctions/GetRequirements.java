package com.game.app.globalFunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.game.app.entity.Requirements;
import com.game.app.service.IRequirementsService;

@Configuration
public class GetRequirements {
	
	@Autowired
	private IRequirementsService requirementsServiceDao;
	
	public GetRequirements() {
		
	}
	
	public Requirements getRequirement(String name, int level) {
		Requirements requir = requirementsServiceDao.getRequirementByNameAndLevel(name, level);
		return requir;
	}
}
