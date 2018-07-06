package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.Team;
import com.revature.services.GameService;
import com.revature.services.TeamService;

@RestController
@RequestMapping("/team")
@Transactional
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private GameService gameService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Team> getAllTeams() {
		return teamService.findAllTeams();
	}	

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Team findTeamById(@PathVariable("id") long id) {
		return teamService.findTeamById(id);
	}

	@GetMapping(value="/name/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Team findTeamByName(@PathVariable("name") String name) {
		return teamService.findTeamByName(name);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Team createTeam(@RequestBody Team team) {
		Team updateTeam = team;
		updateTeam.setGame(gameService.findGameById(updateTeam.getGame().getId()));
		return teamService.createTeam(updateTeam);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Team updateTeam(@RequestBody Team team) {
		Team updateTeam = team;
		updateTeam.setGame(gameService.findGameById(updateTeam.getGame().getId()));
		return teamService.updateTeam(updateTeam);
	}

	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Team deleteTeam(@RequestBody Team team) {
		teamService.deleteTeam(team);
		return team;
	}

}
