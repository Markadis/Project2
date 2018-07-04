package com.revature.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.Player;
import com.revature.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Player> getAllPlayers() {
		return playerService.findAllPlayers();
	}	

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Player findPlayerById(@PathVariable("id") long id) {
		return playerService.findPlayerById(id);
	}

	@PostMapping(value="/create", produces=MediaType.APPLICATION_JSON_VALUE)
	public Player createPlayer(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("username") String username, @RequestParam("password") String password) {
		Player player = new Player(firstName, lastName, username, password);
		return playerService.createPlayer(player);
	}

	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	public Player updatePlayer(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("details") String details, @RequestParam("birthday") Date birthday, @RequestParam("location")String location, @RequestParam("steamId") long steamId, @RequestParam("ismanager")int isManager) {
		Player player = new Player(firstName, lastName, username, password, details, birthday, location, steamId, isManager); 
		return playerService.updatePlayer(player);
	}

	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Player deletePlayer(@RequestBody Player player) {
		playerService.deletePlayer(player);
		return player;
	}
	
	@GetMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE)
	public Player loginPlayer(@RequestParam("username") String username, @RequestParam("password") String password) {
		return playerService.getPlayerByUsernameAndPassword(username, password);

	}
	
}
	
	


