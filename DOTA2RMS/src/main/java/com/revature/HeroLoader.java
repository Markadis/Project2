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
import com.revature.data.Player;
import com.revature.data.PlayerDota2Profile;
import com.revature.data.PlayerTeam;
import com.revature.data.Team;
import com.revature.services.GameService;
import com.revature.services.HeroService;
import com.revature.services.PlayerDota2ProfileService;
import com.revature.services.PlayerService;
import com.revature.services.PlayerTeamService;
import com.revature.services.TeamService;

@Component
@Transactional
public class HeroLoader implements CommandLineRunner {
	
	private HeroService heroDao;
	private GameService gameService;
	private TeamService teamService;
	private PlayerDota2ProfileService playerDota2ProfileService;
	private PlayerService playerService;
	private PlayerTeamService playerTeamService;
	
	@Autowired
	private HibernateJpaSessionFactory sessionFactory;
	
	public HeroLoader(HeroService heroDao, GameService gameService, TeamService teamService, PlayerService playerService, PlayerDota2ProfileService playerDota2ProfileService, PlayerTeamService playerTeamService) {
		this.heroDao = heroDao;
		this.gameService = gameService;
		this.teamService = teamService;
		this.playerService = playerService;
		this.playerDota2ProfileService = playerDota2ProfileService;
		this.playerTeamService = playerTeamService;
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
		
		Game game = new Game("Dota 2", "Defense of the Ancients");
		
		if(gameService.findAllGames().size()<1) {
			gameService.createGame(game);
		}
		game = gameService.findGameById(1);
		Team team = new Team("Example Team Name", "Details of the team go here.", game);
		
		
//		System.out.println("Game is persistent: " + sessionFactory.getHibernateFactory().getCurrentSession().contains(gameService.findGameById(1)));
		
		if(teamService.findTeamById(1) != null && teamService.findAllTeams().size() < 1) {
			System.out.println("Updating team");
			teamService.updateTeam(team);
		}
		team = teamService.findAllTeams().get(0);
		Player player = playerService.findAllPlayers().get(0);
		if(playerDota2ProfileService.findAllPlayerDota2Profiles() == null || playerDota2ProfileService.findAllPlayerDota2Profiles().isEmpty()) {
			
			PlayerDota2Profile playerDota2Profile = new PlayerDota2Profile(player, game, "Player details on this game");
			playerDota2ProfileService.createPlayerDota2Profile(playerDota2Profile);
		}
		PlayerTeam playerTeam;
		if(playerTeamService.findAllPlayerTeams().isEmpty()) {
			playerTeam = new PlayerTeam(player, team, 1);
			playerTeamService.createPlayerTeam(playerTeam);
		}
	}

}
