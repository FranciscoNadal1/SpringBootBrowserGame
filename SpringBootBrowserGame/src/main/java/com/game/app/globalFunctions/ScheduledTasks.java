package com.game.app.globalFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.game.app.entity.User;
import com.game.app.service.IUserService;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private IUserService userService;
	
	@Scheduled(fixedRate = 10000)
	public void updateResources() {
	//	System.out.println("Updating");
		
		List<User> listUsers = userService.listAllUsers();
		
		if(!listUsers.isEmpty())
			for(User user : listUsers) {
				user.getGameProfile().resourcesGrow();
				userService.saveOrEditUser(user);
			}
		log.info("Resource update finished at :  {}", dateFormat.format(new Date()));
	}

}