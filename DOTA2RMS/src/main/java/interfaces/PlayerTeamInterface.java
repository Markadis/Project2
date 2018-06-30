package interfaces;

import org.hibernate.Session;

import data.Player;
import data.PlayerTeam;
import data.PlayerTeamId;
import data.Team;

public interface PlayerTeamInterface {
	PlayerTeamId createPlayerTeam(Session session, Player player, Team team, int position);
	PlayerTeam getPlayerTeamById(Session session, Player player, Team team);
	PlayerTeam updatePlayerTeamPosition(Session session, Player player, Team team, int position);
	boolean checkPlayerTeamExistsByPlayerAndTeam(Session session, Player player, Team team);
	boolean checkPlayerTeamExistsByTeamAndPosition(Session session, Team team, int position);
	void deletePlayerTeamById(Session session, Player player, Team team);
}
