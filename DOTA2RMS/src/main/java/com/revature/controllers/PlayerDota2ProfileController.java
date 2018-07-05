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

import com.revature.data.PlayerDota2Profile;
import com.revature.data.PlayerGameId;
import com.revature.services.PlayerDota2ProfileService;

@RestController
@RequestMapping("/player-dota2")
public class PlayerDota2ProfileController {
	
	@Autowired
	private PlayerDota2ProfileService playerDota2ProfileService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PlayerDota2Profile> getAllPlayerDota2Profiles() {
		return playerDota2ProfileService.findAllPlayerDota2Profiles();
	}	

	//NEEDS WORK.
	@GetMapping(value="/{player.id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public PlayerDota2Profile findPlayerTeamById(@PathVariable("player.id") PlayerGameId playerGameId) {
		return playerDota2ProfileService.findPlayerDota2ProfileById(playerGameId);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PlayerDota2Profile createPlayerTeam(@RequestBody PlayerDota2Profile playerDota2Profile) {
		return playerDota2ProfileService.createPlayerDota2Profile(playerDota2Profile);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PlayerDota2Profile updatePlayerTeam(@RequestBody PlayerDota2Profile playerDota2Profile) {
		return playerDota2ProfileService.updatePlayerDota2Profile(playerDota2Profile);
	}

	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PlayerDota2Profile deletePlayerTeam(@RequestBody PlayerDota2Profile playerDota2Profile) {
		playerDota2ProfileService.deletePlayerDota2Profile(playerDota2Profile);
		return playerDota2Profile;
	}

}
