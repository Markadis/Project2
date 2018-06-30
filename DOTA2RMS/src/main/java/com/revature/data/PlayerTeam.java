package com.revature.data;

import javax.persistence.*;

@Entity
@Table(name="PLAYER_TEAM")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.player",
        joinColumns = @JoinColumn(name = "PLAYER_ID")),
    @AssociationOverride(name = "primaryKey.team",
        joinColumns = @JoinColumn(name = "TEAM_ID")) })
public class PlayerTeam {
	@EmbeddedId
	private PlayerTeamId primaryKey = new PlayerTeamId();
	
	@Column
	private int position;
	
	public PlayerTeam() {
		
	}
	
	public PlayerTeam(Player player, Team team, int position) {
		primaryKey.setPlayer(player);
		primaryKey.setTeam(team);
		this.position = position;
	}

	public PlayerTeamId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(PlayerTeamId primaryKey) {
		this.primaryKey = primaryKey;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	@Transient
	public Player getPlayer() {
		return getPrimaryKey().getPlayer();
	}

	public void setPlayer(Player player) {
		getPrimaryKey().setPlayer(player);
	}
	@Transient
	public Team getTeam() {
		return getPrimaryKey().getTeam();
	}

	public void setTeam(Team team) {
		getPrimaryKey().setTeam(team);
	}
	
	
}
