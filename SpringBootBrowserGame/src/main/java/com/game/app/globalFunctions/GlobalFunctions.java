package com.game.app.globalFunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.game.app.dao.IUser;
import com.game.app.entity.User;

@Component
public class GlobalFunctions {


	@Autowired
	private IUser userDao;
	
	@EventListener(ApplicationReadyEvent.class)
	public void mockNewUser() {
		User user = new User("admin");		
		userDao.save(user);
	}
}
