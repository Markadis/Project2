package com.revature;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.Game;
import com.revature.data.Hero;
import com.revature.data.HibernateJpaSessionFactory;
import com.revature.data.Team;
import com.revature.services.GameService;
import com.revature.services.HeroService;
import com.revature.services.TeamService;

@Component
@Transactional
public class HeroLoader implements CommandLineRunner {
	
	private HeroService heroDao;
	private GameService gameService;
	private TeamService teamService;
	
	@Autowired
	private HibernateJpaSessionFactory sessionFactory;
	
	public HeroLoader(HeroService heroDao, GameService gameService, TeamService teamService) {
		this.heroDao = heroDao;
		this.gameService = gameService;
		this.teamService = teamService;
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
			gameService.createGame(new Game("Dota 2", "Defense of the Ancients"));
		}
		Team team = new Team("Example Team Name", "Details of the team go here.", gameService.findGameById(1));
		
//		System.out.println("Game is persistent: " + sessionFactory.getHibernateFactory().getCurrentSession().contains(gameService.findGameById(1)));
		
		if(teamService.findTeamById(1) != null && teamService.findAllTeams().size() < 1) {
			System.out.println("Updating team");
			teamService.updateTeam(team);
		}
	}

}
