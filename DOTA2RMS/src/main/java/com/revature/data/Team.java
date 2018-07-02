package com.revature.data;



import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table
//@DynamicInsert
public class Team {
	
	@Id
	@Column(name="TEAM_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="teamIdSequence")
	@SequenceGenerator(allocationSize=1, name="teamIdSequence", sequenceName="SQ_TEAMID_PK")
	private long id;
	
	@Column(unique = true)
	private String name;
	
	@Column(columnDefinition = "varchar2(500 char)")
	private String details;
	
	@Column
	@ColumnDefault("0")
	private long wins;
	
	@Column
	@ColumnDefault("0")
	private long losses;
	
	@Column
	@ColumnDefault("null")
	private long captainId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Game game;
	
	@Column
//	@Column(columnDefinition = "DATE DEFAULT CURRENT_TIMESTAMP")
	private Date dateCreated;
	
//	@ManyToMany(fetch = FetchType.EAGER, mappedBy="teamList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	private Set<User> userList;

//	@OneToMany(mappedBy="primaryKey.team", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@OneToMany(fetch = FetchType.EAGER, mappedBy="primaryKey.team", cascade = {CascadeType.REMOVE})
	private List<PlayerTeam> playerTeamList = new ArrayList();
	
	public Team() {
		this.dateCreated = new Date(System.currentTimeMillis());
	}
	
	public Team(String name, String details, Game game) {
		this.name = name;
		this.details = details;
		this.game = game;
		this.dateCreated = new Date(System.currentTimeMillis());
	}
	
	public List<PlayerTeam> getPlayerTeamList() {
		return playerTeamList;
	}

	public void setPlayerTeamList(List<PlayerTeam> playerTeamList) {
		this.playerTeamList = playerTeamList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public long getWins() {
		return wins;
	}

	public void setWins(long wins) {
		this.wins = wins;
	}

	public long getLosses() {
		return losses;
	}

	public void setLosses(long losses) {
		this.losses = losses;
	}

	public long getCaptainId() {
		return captainId;
	}

	public void setCaptainId(long captainId) {
		this.captainId = captainId;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	

//	public Set<User> getUserList() {
//		return userList;
//	}
//
//	public void setUserList(Set<User> userList) {
//		this.userList = userList;
//	}
	
	
	
}
