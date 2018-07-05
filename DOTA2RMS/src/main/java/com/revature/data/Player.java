package com.revature.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@Table(uniqueConstraints= {
//		@UniqueConstraint(columnNames="username")
//})
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Player {
	@Id
	@Column(name="player_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="playerIdSequence")
	@SequenceGenerator(allocationSize=1, name="playerIdSequence", sequenceName="SQ_PLAYERID_PK")
	private long id;
	
	@Column(unique = true)
	private String username;
	
	@Column
	private String password;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private UserProfile userProfile;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column(columnDefinition="varchar2(500 char)")
	private String details;
	
	@Column
	private Date birthday;
	
//	@Column(unique = true)
	@Column
	private String steamId;
	
	@Column
	private int isManager;
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(name="PLAYER_TEAM",
//			joinColumns = {@JoinColumn (name="USER_ID")},
//			inverseJoinColumns = {@JoinColumn(name="TEAM_ID")})
//	private Set<Team> teamList;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "primaryKey.player", cascade = {CascadeType.REMOVE})
//	@OneToMany(mappedBy="primaryKey.player", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<PlayerTeam> playerTeamList = new ArrayList();
	
	@OneToMany(mappedBy = "primaryKey.player", cascade = {CascadeType.REMOVE})
	@Fetch(value = FetchMode.SUBSELECT)
//	@OneToMany(mappedBy="primaryKey.player", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<PlayerGame> playerGameList = new ArrayList();
	
	@Column
	private String location;
	
	public Player(String firstName, String lastName, String username, String password, String details, Date birthday, String location, String steamId, int isManager) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.details = details;
		this.birthday = birthday;
		this.location = location;
		this.steamId = steamId;
		this.isManager = isManager;
	}
	
	public Player() {
		
	}
	
	public List<PlayerTeam> getPlayerTeamList() {
		return playerTeamList;
	}

	public void setPlayerTeamList(List<PlayerTeam> playerTeamList) {
		this.playerTeamList = playerTeamList;
	}
	
	public List<PlayerGame> getPlayerGameList() {
		return playerGameList;
	}

	public void setPlayerGameList(List<PlayerGame> playerGameList) {
		this.playerGameList = playerGameList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSteamId() {
		return steamId;
	}

	public void setSteamId(String steamId) {
		this.steamId = steamId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "[id: " + id + " username: " + username + " password: " + password + " firstName: " + firstName + " lastName: " + lastName + " details: " + details + " birthday: " + birthday + " location: " + location + " steamId: " + steamId + " playerTeamList: " + playerTeamList.toString() + "]";
	}
	
	
	

//	public Set<Team> getTeamList() {
//		return teamList;
//	}
//
//	public void setTeamList(Set<Team> teamList) {
//		this.teamList = teamList;
//	}
	
	
	
}
