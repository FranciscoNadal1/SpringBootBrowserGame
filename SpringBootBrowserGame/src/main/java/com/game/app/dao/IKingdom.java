package com.game.app.dao;

import com.game.app.entity.GameProfile;
import com.game.app.entity.Kingdom;

public interface IKingdom  extends BaseRepository <Kingdom, Long>{

	Kingdom findByGameProfile(GameProfile gameProfile);
}
