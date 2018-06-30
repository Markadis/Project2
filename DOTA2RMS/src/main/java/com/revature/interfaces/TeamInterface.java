package com.revature.interfaces;

import org.hibernate.Session;

import com.revature.data.Game;
import com.revature.data.Team;

public interface TeamInterface {
	long createTeam(Session session, String name, String details, Game game);
	Team getTeamById(Session session, long id);
	Team getTeamByName(Session session, String name);
	boolean checkTeamExistsByName(Session session, String name);
}
