package com.revature.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.revature.data.Game;
import com.revature.data.Hero;

public interface GameInterface {
	Game createGame(Game game);
	Game getGameById(long id);
	Game getGameByName(String name);
	List<Game> getAllGames();
}
