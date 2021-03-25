package com.game.app.dao;

import com.game.app.entity.Building;

public interface IBuilding extends BaseRepository <Building, Long> {

	Building findByName(String string);

}
