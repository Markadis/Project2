package com.revature.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Team;
import com.revature.interfaces.TeamInterface;
import com.revature.repositories.TeamRepository;

@Service
public class TeamService implements TeamInterface {
	
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Team createTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team getTeamById(long id) {
		return teamRepository.getOne(id);
	}

	@Override
	public Team getTeamByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

//	@Override
//	public long createTeam(Session session, String name, String details, Game game) {
//		Transaction transaction = session.beginTransaction();
//		Team newTeam = new Team(name.toLowerCase(), details, game);
//		session.save(newTeam);
//		transaction.commit();
//		return newTeam.getId();
//	}
//
//	@Override
//	public Team getTeamById(Session session, long id) {
//		return (Team) session.get(Team.class, id);
//	}
//
//	@Override
//	public Team getTeamByName(Session session, String name) {
//		String hql ="from " + Player.class.getName() +" where NAME = :nameVar";
//		Query query = session.createQuery(hql);
//		query.setString("nameVar", name);
//		List<Team> teamList = query.list();
//		if(!teamList.isEmpty()) {
//			return teamList.get(0);
//		} else return null;
//	}
//
//	@Override
//	public boolean checkTeamExistsByName(Session session, String name) {
//		if(getTeamByName(session, name) != null) {
//			return true;
//		} else return false;
//	}

}
