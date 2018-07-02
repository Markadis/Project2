package com.revature.interfaces;

import java.util.List;

import com.revature.data.PlayerTeam;
import com.revature.data.PlayerTeamId;

public interface PlayerTeamInterface {
	PlayerTeam createPlayerTeam(PlayerTeam playerTeam);
	PlayerTeam getPlayerTeamById(PlayerTeamId playerTeamId);
	PlayerTeam updatePlayerTeam(PlayerTeam playerTeam);
//	boolean checkPlayerTeamExistsByPlayerAndTeam(Session session, Player player, Team team);
//	boolean checkPlayerTeamExistsByTeamAndPosition(Session session, Team team, int position);
	PlayerTeam deletePlayerTeam(PlayerTeam playerTeam);
	List<PlayerTeam> getAllPlayerTeam();
}
