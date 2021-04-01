package com.game.app.service.interfaces;

import java.util.List;

import com.game.app.entity.Requirements;

public interface IRequirementsService {

	public void newRequirement(Requirements building);
	public void baseRequirements();
	public List<Requirements> getAllRequirements();
	public Requirements getRequirementByNameAndLevel(String name, int level);
}
