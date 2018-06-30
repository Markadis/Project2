

import java.sql.Date;

import org.hibernate.Session;

import daos.GameDao;
import daos.PlayerDao;
import daos.PlayerTeamDao;
import daos.TeamDao;
import data.Game;
import data.Player;
import data.PlayerTeam;
import data.Team;
import util.HibernateUtil;

public class main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		PlayerDao playerDao = new PlayerDao();
		playerDao.createPlayer(session, "firstName", "lastName", "username", "password","details", new Date(1111111), "location", 0);
		GameDao gameDao = new GameDao();
		gameDao.createGame(session, "DOTA 2", "This is a description.");
		PlayerTeamDao playerTeamDao = new PlayerTeamDao();
		
				
		Player player = playerDao.getPlayerById(session, 1);
		Game game = gameDao.getGameById(session, 1);
		System.out.println(player.toString());
		System.out.println(game.toString());
		
		TeamDao teamDao = new TeamDao();
		teamDao.createTeam(session, "name", "details", game);
		
		Team team = teamDao.getTeamById(session, 1);
		
		playerTeamDao.createPlayerTeam(session, player, team, 1);
		PlayerTeam playerTeam = playerTeamDao.getPlayerTeamById(session, player, team);
		System.out.println("PlayerTeam position is: " + playerTeam.getPosition());
//		playerTeamDao.deletePlayerTeamById(session, player, team);
//		System.out.println(playerTeam.toString());
		playerTeamDao.updatePlayerTeamPosition(session, player, team, 3);
		System.out.println("PlayerTeam position after update is: " + playerTeam.getPosition());
		
		session.close();
		
		session = HibernateUtil.getSession();
		System.out.println("PlayerTeam of player " + player.getId() + " and team " + team.getId() + " is: " + playerTeamDao.checkPlayerTeamExistsByPlayerAndTeam(session, player, team));
		System.out.println("PlayerTeam of team " + team.getId() + " and position 1 is: " + playerTeamDao.checkPlayerTeamExistsByTeamAndPosition(session, team, 1));

		session.close();

	}

}
