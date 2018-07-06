package com.revature.data;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Entity
//@Table
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TeamChallenge {

	@Id
	@Column(name="TEAM_CHALLENGE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="teamChallengeIdSequence")
	@SequenceGenerator(allocationSize=1, name="teamChallengeIdSequence", sequenceName="SQ_TEAM_CHALLENGE_ID_PK")
	private long id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="id")
	private Team team1;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="id")
	private Team team2;
	
	//0 for pending, 1 for denied (hide it), 2 for approved (display until time has passed
	@Column
	private int status;
	
	@Column
	private Date date;
	
	public TeamChallenge() {
		
	}
	
	public TeamChallenge(Team team1, Team team2, int status, Date date) {
		this.team1 = team1;
		this.team2 = team2;
		this.status = status;
		this.date = date;
	}

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

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
