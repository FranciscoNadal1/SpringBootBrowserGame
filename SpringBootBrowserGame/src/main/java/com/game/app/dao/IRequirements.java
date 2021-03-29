package com.game.app.dao;

import com.game.app.entity.Requirements;

public interface IRequirements  extends BaseRepository <Requirements, Long>{

	public Requirements findByNameAndLevel(String name, int level);
}
