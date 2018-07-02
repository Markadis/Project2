package com.revature.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Player;
import com.revature.interfaces.PlayerInterface;
import com.revature.repositories.PlayerRepository;

@Service
public class PlayerService implements PlayerInterface {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Player createPlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player getPlayerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayerById(long id) {
		return playerRepository.getOne(id);
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
	
	
	
}
