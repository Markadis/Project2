package com.revature.daos;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.data.Player;
import com.revature.data.PlayerTeam;
import com.revature.interfaces.PlayerInterface;

public class PlayerDao implements PlayerInterface {

	@Override
	public long createPlayer(Session session, String firstName, String lastName, String username, String password,
			String details, Date birthday, String location, long steamId) {
		Transaction transaction = session.beginTransaction();
		Player newPlayer = new Player(firstName, lastName, username.toLowerCase(), password, details, birthday, location, steamId);
		session.save(newPlayer);
		transaction.commit();
		return newPlayer.getId();
	}

	@Override
	public Player getPlayerByUsername(Session session, String username) {
		String hql ="from " + Player.class.getName() +" where USERNAME = :usernameVar";
		Query query = session.createQuery(hql);
		query.setString("usernameVar", username);
		List<Player> playerList = query.list();
		if(!playerList.isEmpty()) {
			return playerList.get(0);
		} else return null;
	}

	@Override
	public Player getPlayerById(Session session, long id) {
		return (Player) session.get(Player.class, id);
	}

	@Override
	public boolean checkPlayerExistsByUsername(Session session, String username) {
		if(getPlayerByUsername(session, username) != null) {
			return true;
		} else return false;
	}
	
}
