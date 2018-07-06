package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.Game;
import com.revature.data.Hero;
import com.revature.data.Player;
import com.revature.services.GameService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Game> findAllGames() {
		return gameService.findAllGames();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Game findGameById(@PathVariable("id") Integer id) {
		return gameService.findGameById(id);
	}
	
	@GetMapping(value="/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Game findGameByName(@PathVariable("name") String name) {
		return gameService.findGameByName(name);
	}

//	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public Game updateGame(@RequestBody Player player) {
//		return gameService.updateGame(player);
//	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Game createHero(@RequestBody Game game) {
		return gameService.createGame(game);
	}

//	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public Game deleteGame(@RequestBody Game game) {
//		gameService.deleteGame(game);
//		return game;
//	}

}
