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

import com.revature.data.PlayerTeam;
import com.revature.data.PlayerTeamId;
import com.revature.services.PlayerTeamService;

@RestController
@RequestMapping("/player-team")
public class PlayerTeamController {
	
	@Autowired
	private PlayerTeamService playerTeamService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PlayerTeam> getAllPlayerTeams() {
		return playerTeamService.findAllPlayerTeams();
	}	

	//NEEDS WORK.
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public PlayerTeam findPlayerTeamById(@PathVariable("id") PlayerTeamId playerTeamId) {
		return playerTeamService.findPlayerTeamById(playerTeamId);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PlayerTeam createPlayerTeam(@RequestBody PlayerTeam playerTeam) {
		return playerTeamService.createPlayerTeam(playerTeam);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PlayerTeam updatePlayerTeam(@RequestBody PlayerTeam playerTeam) {
		return playerTeamService.updatePlayerTeam(playerTeam);
	}

	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PlayerTeam deletePlayerTeam(@RequestBody PlayerTeam playerTeam) {
		playerTeamService.deletePlayerTeam(playerTeam);
		return playerTeam;
	}

}
