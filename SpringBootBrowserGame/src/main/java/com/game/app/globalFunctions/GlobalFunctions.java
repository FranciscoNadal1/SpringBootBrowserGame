package com.game.app.globalFunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.game.app.dao.IKingdom;
import com.game.app.dao.IUser;
import com.game.app.entity.Kingdom;
import com.game.app.entity.User;

@Component
public class GlobalFunctions {


	@Autowired
	private IUser userDao;

	@Autowired
	private IKingdom kingdomDao;
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void mockNewUser() {
		User user = new User("admin");		
		userDao.save(user);
		Kingdom newKingdom = new Kingdom(user.getUsername());
		newKingdom.setGameProfile(user.getGameProfile());
		kingdomDao.save(newKingdom);
		
		//user.
//		user.getGameProfile().getKingdomList().add(new Kingdom("ey"));
	}
}
