package com.revature.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.data.Game;
import com.revature.data.Player;
import com.revature.data.Team;
import com.revature.interfaces.TeamInterface;

public class TeamDao implements TeamInterface {

	@Override
	public long createTeam(Session session, String name, String details, Game game) {
		Transaction transaction = session.beginTransaction();
		Team newTeam = new Team(name.toLowerCase(), details, game);
		session.save(newTeam);
		transaction.commit();
		return newTeam.getId();
	}

	@Override
	public Team getTeamById(Session session, long id) {
		return (Team) session.get(Team.class, id);
	}

	@Override
	public Team getTeamByName(Session session, String name) {
		String hql ="from " + Player.class.getName() +" where NAME = :nameVar";
		Query query = session.createQuery(hql);
		query.setString("nameVar", name);
		List<Team> teamList = query.list();
		if(!teamList.isEmpty()) {
			return teamList.get(0);
		} else return null;
	}

	@Override
	public boolean checkTeamExistsByName(Session session, String name) {
		if(getTeamByName(session, name) != null) {
			return true;
		} else return false;
	}

}
