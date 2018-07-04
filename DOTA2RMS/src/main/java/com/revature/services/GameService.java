package com.revature.services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Game;
import com.revature.interfaces.GameInterface;
import com.revature.repositories.GameRepository;

@Service
public class GameService implements GameInterface {
	
	@Autowired
	private GameRepository gameRepository;

	@Override
	public Game createGame(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public Game findGameById(long id) {
		return gameRepository.getOne(id);
	}

	@Override
	public Game getGameByName(String name) {
		return gameRepository.findByName(name);
	}

	@Override
	public List<Game> findAllGames() {
		return gameRepository.findAll();
	}


}
