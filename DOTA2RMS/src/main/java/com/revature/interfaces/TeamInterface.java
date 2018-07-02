package com.revature.interfaces;

import java.util.List;

import com.revature.data.Team;

public interface TeamInterface {
	Team createTeam(Team team);
	Team getTeamById(long id);
	Team getTeamByName(String name);
//	boolean checkTeamExistsByName(String name);
	List<Team> getAllTeams();
}
