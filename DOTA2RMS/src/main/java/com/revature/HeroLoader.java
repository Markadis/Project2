package com.revature;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

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
import com.revature.data.TeamChallenge;
import com.revature.data.TeamInvite;
import com.revature.services.GameService;
import com.revature.services.HeroService;
import com.revature.services.PlayerDota2ProfileService;
import com.revature.services.PlayerService;
import com.revature.services.PlayerTeamService;
import com.revature.services.TeamChallengeService;
import com.revature.services.TeamInviteService;
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
	private TeamInviteService teamInviteService;
//	private TeamChallengeService teamChallengeService;
	
	@Autowired
	private HibernateJpaSessionFactory sessionFactory;
	
	public HeroLoader(HeroService heroDao, GameService gameService, TeamService teamService,
			PlayerService playerService, PlayerDota2ProfileService playerDota2ProfileService,
			PlayerTeamService playerTeamService, TeamInviteService teamInviteService) {
		this.heroDao = heroDao;
		this.gameService = gameService;
		this.teamService = teamService;
		this.playerService = playerService;
		this.playerDota2ProfileService = playerDota2ProfileService;
		this.playerTeamService = playerTeamService;
		this.teamInviteService = teamInviteService;
//		this.teamChallengeService = teamChallengeService;
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
		Team team2 = new Team("Another Example Team Name", "Details of the team go here.", game);
		
		if(teamService.findTeamById(1) != null && teamService.findAllTeams().size() < 1) {
			System.out.println("Updating team");
			teamService.createTeam(team);
			teamService.createTeam(team2);
		}
		team = teamService.findAllTeams().get(0);
		team2 = teamService.findAllTeams().get(1);
		Player player;
		Player player2;
		player = new Player("asdf", "asdf", "asdf", "password", "details go here", null, null, null, 1);
		player2 = new Player("asdf", "asdf", "asdfasdf", "password", "details go here", null, null, null, 1);
		
		if(playerService.findAllPlayers().isEmpty()) {
			playerService.createPlayer(player);
			playerService.createPlayer(player2);
		}
		
		player = playerService.findAllPlayers().get(0);
		player2 = playerService.findAllPlayers().get(1);
		if(playerDota2ProfileService.findAllPlayerDota2Profiles() == null || playerDota2ProfileService.findAllPlayerDota2Profiles().isEmpty()) {
			
			PlayerDota2Profile playerDota2Profile = new PlayerDota2Profile(player, game, "Player details on this game");
			playerDota2ProfileService.createPlayerDota2Profile(playerDota2Profile);
		}
		PlayerTeam playerTeam;
		if(playerTeamService.findAllPlayerTeams().isEmpty()) {
			playerTeam = new PlayerTeam(player, team, 1);
			playerTeamService.createPlayerTeam(playerTeam);
		}
		TeamInvite teamInvite;
		if(teamInviteService.findAllTeamInvites().isEmpty()) {
			teamInvite = new TeamInvite(team, player, 0, 0);
			teamInviteService.createTeamInvite(teamInvite);
			teamInvite = new TeamInvite(team2, player, 0, 1);
			teamInviteService.createTeamInvite(teamInvite);
		}
//		TeamChallenge teamChallenge;
//		if(teamChallengeService.findAllTeamChallenges().isEmpty()) {
//			teamChallenge = new TeamChallenge(team, team2, 0, new Date(System.currentTimeMillis()));
//			teamChallengeService.createTeamChallenge(teamChallenge);
//		}
		
	}

}
