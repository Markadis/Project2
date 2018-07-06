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
import com.revature.data.TeamChallenge;
import com.revature.data.TeamInvite;
import com.revature.services.TeamChallengeService;
import com.revature.services.TeamInviteService;

//@RestController
//@RequestMapping("/team-challenge")
public class TeamChallengeController {
	
//	@Autowired
//	private TeamChallengeService teamChallengeService;
//	
//	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<TeamChallenge> getAllTeamInvites() {
//		return teamChallengeService.findAllTeamChallenges();
//	}	
//
//	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
//	public TeamChallenge findPlayerById(@PathVariable("id") long id) {
//		return teamChallengeService.findTeamChallengeById(id);
//	}
//
//	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public TeamChallenge createTeamInvite(@RequestBody TeamChallenge teamChallenge) {
//		return teamChallengeService.createTeamChallenge(teamChallenge);
//	}
//
//	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public TeamChallenge updateTeamInvite(@RequestBody TeamChallenge teamChallenge) {
//		return teamChallengeService.updateTeamChallenge(teamChallenge);
//	}
//
//	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public TeamChallenge deleteTeamInvite(@RequestBody TeamChallenge teamChallenge) {
//		teamChallengeService.deleteTeamChallenge(teamChallenge);
//		return teamChallenge;
//	}

}
