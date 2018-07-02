package com.revature.data;

import javax.persistence.*;

@Entity
@Table
public class TeamInvite {

	@Id
	@Column(name="TEAM_INVITE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="teamInviteIdSequence")
	@SequenceGenerator(allocationSize=1, name="teamInviteIdSequence", sequenceName="SQ_TEAM_INVITE_ID_PK")
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Team team;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Player player;
	
	@Column
	private int status;
	
	@Column
	private int type;
	
	public TeamInvite() {
		
	}
	
	public TeamInvite(Team team, Player player, int status, int type) {
		this.team = team;
		this.player = player;
		this.status = status;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
