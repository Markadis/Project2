package com.revature.interfaces;

import java.sql.Date;

import org.hibernate.Session;

import com.revature.data.Player;

public interface PlayerInterface {
	long createPlayer(Session session, String firstName, String lastName, String username, String password, String details, Date birthday, String location, long steamId);
	Player getPlayerByUsername(Session session, String username);
	Player getPlayerById(Session session, long id);
//	boolean checkPlayerExistsById(Session session, long id);
	boolean checkPlayerExistsByUsername(Session session, String name);
}
