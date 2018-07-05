package com.revature.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.revature.data.Game;
import com.revature.data.Hero;

public interface GameInterface {
	Game createGame(Game game);
	Game findGameById(long id);
	Game findGameByName(String name);
	List<Game> findAllGames();
}
