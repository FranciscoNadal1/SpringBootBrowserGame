package com.game.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootBrowserGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBrowserGameApplication.class, args);
	}

}
