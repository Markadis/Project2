package com.revature.interfaces;

import java.util.List;

import com.revature.data.TeamInvite;

public interface TeamInviteInterface {
	TeamInvite createTeamInvite(TeamInvite teamInvite);
	TeamInvite findTeamInviteById(long id);
	TeamInvite updateTeamInvite(TeamInvite teamInvite);
	TeamInvite deleteTeamInvite(TeamInvite teamInvite);
	List<TeamInvite> findAllTeamInvites();
}
