package com.revature.interfaces;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.revature.data.Game;
import com.revature.data.Player;

public interface PlayerInterface {
	Player createPlayer(Player player);
	Player findByUsername(String username);
	Player findPlayerById(long id);
	Player updatePlayer(Player player);
	Player deletePlayer(Player player);
//	boolean checkPlayerExistsById(Session session, long id);
//	boolean checkPlayerExistsByUsername(Session session, String name);
	List<Player> findAllPlayers();
}
