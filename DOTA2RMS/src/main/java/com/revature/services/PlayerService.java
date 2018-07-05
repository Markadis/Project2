package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.Player;
import com.revature.interfaces.PlayerInterface;
import com.revature.repositories.PlayerRepository;

@Service
@Transactional
public class PlayerService implements PlayerInterface {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Player createPlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player findByUsername(String username) {
		return playerRepository.findByUsername(username);
	}

	@Override
	public Player updatePlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player findPlayerById(long id) {
		return playerRepository.getOne(id);
	}

	@Override
	public List<Player> findAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Player deletePlayer(Player player) {
		playerRepository.delete(player);
		return player;
	}
	
	public Player getPlayerByUsernameAndPassword(String username, String password) {
		return playerRepository.findByUsernameAndPassword(username, password);
	}
	
	
}
