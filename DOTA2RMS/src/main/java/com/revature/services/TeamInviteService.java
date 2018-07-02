package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.TeamInvite;
import com.revature.interfaces.TeamInviteInterface;
import com.revature.repositories.TeamInviteRepository;

@Service
public class TeamInviteService implements TeamInviteInterface {
	
	@Autowired
	private TeamInviteRepository teamInviteRepository;

	@Override
	public TeamInvite createTeam(TeamInvite teamInvite) {
		return teamInviteRepository.save(teamInvite);
	}

	@Override
	public TeamInvite getTeamById(long id) {
		return teamInviteRepository.getOne(id);
	}

	@Override
	public TeamInvite updateTeamInvite(TeamInvite teamInvite) {
		return teamInviteRepository.save(teamInvite);
	}

	@Override
	public List<TeamInvite> getAllTeamInvites() {
		return teamInviteRepository.findAll();
	}
	
	

}
