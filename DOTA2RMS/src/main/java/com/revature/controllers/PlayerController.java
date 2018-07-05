package com.revature.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.Player;
import com.revature.services.PlayerService;

@RestController
@RequestMapping("/player")
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
	
	@GetMapping(value="/username/{username}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Player findByUsername(@PathVariable("username") String username) {
		return playerService.findByUsername(username);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Player createPlayer(@RequestBody Player player) {
//		System.out.println("Player username is: " + player.getUsername());
		return playerService.createPlayer(player);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Player updatePlayer(@RequestBody Player player) {
		return playerService.updatePlayer(player);
	}

	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Player deletePlayer(@RequestBody Player player) {
		playerService.deletePlayer(player);
		return player;
	}

}
