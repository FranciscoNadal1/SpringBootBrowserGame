package com.game.app.war;

import com.game.app.dao.BaseRepository;

public interface IFormation  extends BaseRepository <Formation, Long>{

	Formation save(Formation formation);

}
