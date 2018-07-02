package com.revature.daos;

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
	public Game getGameById(long id) {
		return gameRepository.getOne(id);
	}

	@Override
	public Game getGameByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}


}
