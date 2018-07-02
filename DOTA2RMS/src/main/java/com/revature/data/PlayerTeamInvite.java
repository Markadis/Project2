package com.revature.data;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class PlayerTeamInvite {
	@Id
	@Column(name="INVITE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inviteIdSequence")
	@SequenceGenerator(allocationSize=1, name="inviteIdSequence", sequenceName="SQ_INVITEID_PK")
	private long id;
	
	@Column
	private int status;
	
	@Column
	private int type;	
	
	@OneToOne
	private Player player;
	
	@OneToOne
	private Team team;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
