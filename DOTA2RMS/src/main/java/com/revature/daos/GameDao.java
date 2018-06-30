package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.data.Game;
import com.revature.data.Player;
import com.revature.interfaces.GameInterface;

public class GameDao implements GameInterface {

	@Override
	public long createGame(Session session, String name, String details) {
		Transaction transaction = session.beginTransaction();
		Game newGame = new Game(name, details);
		session.save(newGame);
		transaction.commit();
		return newGame.getId();
	}

	@Override
	public Game getGameById(Session session, long id) {
		return (Game)session.get(Game.class, id);
	}

	@Override
	public Game getGameByName(Session session, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
