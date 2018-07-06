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

import com.revature.data.Player;
import com.revature.data.TeamInvite;
import com.revature.services.TeamInviteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/team-invite")
public class TeamInviteController {
	
	@Autowired
	private TeamInviteService teamInviteService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TeamInvite> getAllTeamInvites() {
		return teamInviteService.findAllTeamInvites();
	}	

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public TeamInvite findPlayerById(@PathVariable("id") long id) {
		return teamInviteService.findTeamInviteById(id);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public TeamInvite createTeamInvite(@RequestBody TeamInvite teamInvite) {
		return teamInviteService.createTeamInvite(teamInvite);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public TeamInvite updateTeamInvite(@RequestBody TeamInvite teamInvite) {
		return teamInviteService.updateTeamInvite(teamInvite);
	}

	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public TeamInvite deleteTeamInvite(@RequestBody TeamInvite teamInvite) {
		teamInviteService.deleteTeamInvite(teamInvite);
		return teamInvite;
	}

}
