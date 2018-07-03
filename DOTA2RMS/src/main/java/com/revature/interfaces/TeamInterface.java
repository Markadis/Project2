package com.revature.interfaces;

import java.util.List;

import com.revature.data.Team;

public interface TeamInterface {
	Team createTeam(Team team);
	Team findTeamById(long id);
	Team getTeamByName(String name);
	Team updateTeam(Team team);
	Team deleteTeam(Team team);
//	boolean checkTeamExistsByName(String name);
	List<Team> findAllTeams();
}
