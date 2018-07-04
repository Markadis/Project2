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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.Team;
import com.revature.services.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Team> getAllTeams() {
		return teamService.findAllTeams();
	}	

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Team findTeamById(@PathVariable("id") long id) {
		return teamService.findTeamById(id);
	}

	@PostMapping(value="/create", produces=MediaType.APPLICATION_JSON_VALUE)
	public Team createTeam(@RequestParam("name") String name, @RequestParam("details") String details) {
		Team team = new Team(name, details);
		return teamService.createTeam(team);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Team updateTeam(@RequestBody Team team) {
		return teamService.updateTeam(team);
	}

	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Team deleteTeam(@RequestBody Team team) {
		teamService.deleteTeam(team);
		return team;
	}

}
