package com.revature.interfaces;

import org.hibernate.Session;

import com.revature.data.Player;
import com.revature.data.PlayerTeam;
import com.revature.data.PlayerTeamId;
import com.revature.data.Team;

public interface PlayerTeamInterface {
	PlayerTeamId createPlayerTeam(Session session, Player player, Team team, int position);
	PlayerTeam getPlayerTeamById(Session session, Player player, Team team);
	PlayerTeam updatePlayerTeamPosition(Session session, Player player, Team team, int position);
	boolean checkPlayerTeamExistsByPlayerAndTeam(Session session, Player player, Team team);
	boolean checkPlayerTeamExistsByTeamAndPosition(Session session, Team team, int position);
	void deletePlayerTeamById(Session session, Player player, Team team);
}
