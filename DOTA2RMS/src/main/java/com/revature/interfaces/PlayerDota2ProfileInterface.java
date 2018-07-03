package com.revature.interfaces;

import java.util.List;

import com.revature.data.PlayerDota2Profile;
import com.revature.data.PlayerGameId;

public interface PlayerDota2ProfileInterface {
	PlayerDota2Profile createPlayerDota2Profile(PlayerDota2Profile playerDota2Profile);
	PlayerDota2Profile findPlayerDota2ProfileById(PlayerGameId playerGameId);
	PlayerDota2Profile updatePlayerDota2Profile(PlayerDota2Profile playerDota2Profile);
	PlayerDota2Profile deletePlayerDota2Profile(PlayerDota2Profile playerDota2Profile);
//	boolean checkPlayerExistsById(Session session, long id);
//	boolean checkPlayerExistsByUsername(Session session, String name);
	List<PlayerDota2Profile> findAllPlayerDota2Profiles();
}
