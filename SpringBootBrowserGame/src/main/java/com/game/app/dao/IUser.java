package com.game.app.dao;

import com.game.app.entity.User;

public interface IUser extends BaseRepository <User, Long> {


	User findById(int id);
}
