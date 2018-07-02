package com.revature.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.PlayerTeam;
import com.revature.data.PlayerTeamId;
import com.revature.interfaces.PlayerTeamInterface;
import com.revature.repositories.PlayerTeamRepository;

@Service
public class PlayerTeamService implements PlayerTeamInterface {

	@Autowired
	private PlayerTeamRepository playerTeamRepository;
	
	@Override
	public PlayerTeam createPlayerTeam(PlayerTeam playerTeam) {
		return playerTeamRepository.save(playerTeam);
	}

	@Override
	public PlayerTeam getPlayerTeamById(PlayerTeamId playerTeamId) {
		return playerTeamRepository.getOne(playerTeamId);
	}

	@Override
	public PlayerTeam updatePlayerTeam(PlayerTeam playerTeam) {
		return playerTeamRepository.save(playerTeam);
	}

	@Override
	public PlayerTeam deletePlayerTeam(PlayerTeam playerTeam) {
		playerTeamRepository.delete(playerTeam);
		return playerTeam;
	}

	@Override
	public List<PlayerTeam> getAllPlayerTeam() {
		return playerTeamRepository.findAll();
	}

//	@Override
//	public PlayerTeamId createPlayerTeam(Session session, Player player, Team team, int position) {
//		Transaction transaction = session.beginTransaction();
//		PlayerTeam newPlayerTeam = new PlayerTeam(player, team, position);
//		session.save(newPlayerTeam);
//		transaction.commit();
//		return newPlayerTeam.getPrimaryKey();
//	}
//
//	@Override
//	public PlayerTeam getPlayerTeamById(Session session, Player player, Team team) {
//		String hql ="from " + PlayerTeam.class.getName() +" where TEAM_ID = :teamVar and PLAYER_ID = :playerVar";
//		Query q = session.createQuery(hql);
//		q.setLong("teamVar", team.getId());
//		q.setLong("playerVar", player.getId());
//		List<PlayerTeam> playerTeamList = q.list();
//		
//		if(!playerTeamList.isEmpty()) {
//			return playerTeamList.get(0);
//		} else return null;
//	}
//
//	@Override
//	public void deletePlayerTeamById(Session session, Player player, Team team) {
//		Transaction transaction = session.beginTransaction();
//		PlayerTeam playerTeam = getPlayerTeamById(session, player, team);
//		session.delete(playerTeam);
//		transaction.commit();
//	}
//
//	@Override
//	public PlayerTeam updatePlayerTeamPosition(Session session, Player player, Team team, int newPosition) {
//		Transaction transaction = session.beginTransaction();
//		PlayerTeam playerTeam = getPlayerTeamById(session, player, team);
//		playerTeam.setPosition(newPosition);
//		session.update(playerTeam);
//		transaction.commit();
//		return playerTeam;
//	}
//
//	@Override
//	public boolean checkPlayerTeamExistsByPlayerAndTeam(Session session, Player player, Team team) {
//		PlayerTeam playerTeam = getPlayerTeamById(session, player, team);
//		if(playerTeam != null) {
//			return true;
//		} else return false;
//	}
//
//	@Override
//	public boolean checkPlayerTeamExistsByTeamAndPosition(Session session, Team team, int position) {
//		String hql ="from " + PlayerTeam.class.getName() +" where TEAM_ID = :teamVar and POSITION = :posVar";
//		Query q = session.createQuery(hql);
//		q.setLong("teamVar", team.getId());
//		q.setLong("posVar", position);
//		List<PlayerTeam> playerTeamList = q.list();
//		
//		if(!playerTeamList.isEmpty()) {
//			return true;
//		} else return false;
//	}
	
	
	
	
	
}
