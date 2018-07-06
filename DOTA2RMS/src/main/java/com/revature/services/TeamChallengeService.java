package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.TeamChallenge;
import com.revature.data.TeamInvite;
import com.revature.interfaces.TeamChallengeInterface;
import com.revature.interfaces.TeamInviteInterface;
import com.revature.repositories.TeamInviteRepository;

//@Service
//@Transactional
public class TeamChallengeService implements TeamChallengeInterface {
//	
//	@Autowired
//	private TeamChallengeRepository teamChallengeRepository;
//
//	@Override
//	public TeamChallenge createTeamChallenge(TeamChallenge teamChallenge) {
//		return teamChallengeRepository.save(teamChallenge);
//	}
//
//	@Override
//	public TeamChallenge findTeamChallengeById(long id) {
//		return teamChallengeRepository.getOne(id);
//	}
//
//	@Override
//	public TeamChallenge updateTeamChallenge(TeamChallenge teamChallenge) {
//		return teamChallengeRepository.save(teamChallenge);
//	}
//
//	@Override
//	public List<TeamChallenge> findAllTeamChallenges() {
//		return teamChallengeRepository.findAll();
//	}
//
//	@Override
//	public TeamChallenge deleteTeamChallenge(TeamChallenge teamChallenge) {
//		teamChallengeRepository.delete(teamChallenge);
//		return teamChallenge;
//	}
	
	

}
