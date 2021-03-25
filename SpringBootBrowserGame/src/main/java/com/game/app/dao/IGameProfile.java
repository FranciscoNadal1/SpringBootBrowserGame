package com.game.app.dao;

import com.game.app.entity.GameProfile;

public interface IGameProfile extends BaseRepository <GameProfile, Long> {
	GameProfile findById(int id);
}
