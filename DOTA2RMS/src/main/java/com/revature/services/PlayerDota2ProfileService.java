package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.Player;
import com.revature.data.PlayerDota2Profile;
import com.revature.data.PlayerGameId;
import com.revature.interfaces.PlayerDota2ProfileInterface;
import com.revature.repositories.PlayerDota2ProfileRepository;

@Service
@Transactional
public class PlayerDota2ProfileService implements PlayerDota2ProfileInterface {

	@Autowired
	private PlayerDota2ProfileRepository playerDota2ProfileRepository;

	@Override
	public PlayerDota2Profile createPlayerDota2Profile(PlayerDota2Profile playerDota2Profile) {
		return playerDota2ProfileRepository.save(playerDota2Profile);
	}

	@Override
	public PlayerDota2Profile findPlayerDota2ProfileById(PlayerGameId playerGameId) {
		return playerDota2ProfileRepository.getOne(playerGameId);
	}

	@Override
	public PlayerDota2Profile updatePlayerDota2Profile(PlayerDota2Profile playerDota2Profile) {
		return playerDota2ProfileRepository.save(playerDota2Profile);
	}

	@Override
	public PlayerDota2Profile deletePlayerDota2Profile(PlayerDota2Profile playerDota2Profile) {
		playerDota2ProfileRepository.delete(playerDota2Profile);
		return playerDota2Profile;
	}

	@Override
	public List<PlayerDota2Profile> findAllPlayerDota2Profiles() {
		return playerDota2ProfileRepository.findAll();
	}
	
	
	
}
