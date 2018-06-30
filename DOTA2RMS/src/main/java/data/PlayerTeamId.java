package data;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class PlayerTeamId implements Serializable {
	@ManyToOne(cascade=CascadeType.ALL)
	private Team team;

	@ManyToOne(cascade=CascadeType.ALL)
	private Player player;
	
	public PlayerTeamId() {
		
	}

	public PlayerTeamId(Player player, Team team) {
		this.player = player;
		this.team = team;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
