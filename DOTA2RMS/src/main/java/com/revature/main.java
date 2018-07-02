package com.revature;


import java.io.File;
import java.io.IOException;

import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.HeroService;
import com.revature.data.Hero;
import com.revature.util.HibernateUtil;

@SpringBootApplication
public class main{

	public static void main(String[] args)  {
		
		SpringApplication.run(main.class, args);
		
//		Session session = HibernateUtil.getSession();
//		PlayerDao playerDao = new PlayerDao();
//		playerDao.createPlayer(session, "firstName", "lastName", "username", "password","details", new Date(1111111), "location", 0);
//		GameDao gameDao = new GameDao();
//		gameDao.createGame(session, "DOTA 2", "This is a description.");
//		PlayerTeamDao playerTeamDao = new PlayerTeamDao();
//		
//				
//		Player player = playerDao.getPlayerById(session, 1);
//		Game game = gameDao.getGameById(session, 1);
//		System.out.println(player.toString());
//		System.out.println(game.toString());
//		
//		TeamDao teamDao = new TeamDao();
//		teamDao.createTeam(session, "name", "details", game);
//		
//		Team team = teamDao.getTeamById(session, 1);
//		
//		playerTeamDao.createPlayerTeam(session, player, team, 1);
//		PlayerTeam playerTeam = playerTeamDao.getPlayerTeamById(session, player, team);
//		System.out.println("PlayerTeam position is: " + playerTeam.getPosition());
////		playerTeamDao.deletePlayerTeamById(session, player, team);
////		System.out.println(playerTeam.toString());
//		playerTeamDao.updatePlayerTeamPosition(session, player, team, 3);
//		System.out.println("PlayerTeam position after update is: " + playerTeam.getPosition());
//		
//		session.close();
//		
//		session = HibernateUtil.getSession();
//		System.out.println("PlayerTeam of player " + player.getId() + " and team " + team.getId() + " is: " + playerTeamDao.checkPlayerTeamExistsByPlayerAndTeam(session, player, team));
//		System.out.println("PlayerTeam of team " + team.getId() + " and position 1 is: " + playerTeamDao.checkPlayerTeamExistsByTeamAndPosition(session, team, 1));
//
//		session.close();
		
//		Session session = HibernateUtil.getSession();
//		ObjectMapper objectMapper = new ObjectMapper();
//		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/revature/raw/heroes.json");
//		try {
//			Hero[] heroList = objectMapper.readValue(file, Hero[].class);
//			HeroDao heroDao = new HeroDao();
//			System.out.println(heroList.length);
//			for(Hero hero : heroList) {
//				heroDao.createHero(hero);
//				
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		session.close();

	}

}
