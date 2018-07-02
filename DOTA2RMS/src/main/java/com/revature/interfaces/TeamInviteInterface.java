package com.revature.interfaces;

import java.util.List;

import com.revature.data.TeamInvite;

public interface TeamInviteInterface {
	TeamInvite createTeam(TeamInvite teamInvite);
	TeamInvite getTeamById(long id);
	TeamInvite updateTeamInvite(TeamInvite teamInvite);
	List<TeamInvite> getAllTeamInvites();
}
