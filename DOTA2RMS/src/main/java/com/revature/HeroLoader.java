package com.revature;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.Game;
import com.revature.data.Hero;
import com.revature.services.GameService;
import com.revature.services.HeroService;

@Component
public class HeroLoader implements CommandLineRunner {
	
	private HeroService heroDao;
	private GameService gameService;
	
	public HeroLoader(HeroService heroDao, GameService gameService) {
		this.heroDao = heroDao;
		this.gameService = gameService;
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/revature/raw/heroes.json");
		try {
			Hero[] heroList = objectMapper.readValue(file, Hero[].class);
			if(heroList.length != heroDao.findAllHeroes().size()) {
				for(Hero hero : heroList) {
					heroDao.createHero(hero);
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(gameService.findAllGames().size()<1) {
			gameService.createGame(new Game("Doto 2", "Defense of the Orientals"));
		}
		
	}

}
