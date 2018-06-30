package interfaces;

import org.hibernate.Session;

import data.Game;

public interface GameInterface {
	long createGame(Session session, String name, String details);
	Game getGameById(Session session, long id);
	Game getGameByName(Session session, String name);
}
