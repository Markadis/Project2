package data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="USERTABLE")
public class Player {
	@Id
	@Column(name="player_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="playerIdSequence")
	@SequenceGenerator(allocationSize=1, name="playerIdSequence", sequenceName="SQ_PLAYERID_PK")
	private long id;
	
	@Column(unique=true)
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
	
	@Column(unique = true)
	private long steamId;
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(name="PLAYER_TEAM",
//			joinColumns = {@JoinColumn (name="USER_ID")},
//			inverseJoinColumns = {@JoinColumn(name="TEAM_ID")})
//	private Set<Team> teamList;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "primaryKey.player", cascade = {CascadeType.REMOVE})
//	@OneToMany(mappedBy="primaryKey.player", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<PlayerTeam> playerTeamList = new ArrayList();
	
	@Column
	private String location;
	
	public Player(String firstName, String lastName, String username, String password, String details, Date birthday, String location, long steamId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.details = details;
		this.birthday = birthday;
		this.location = location;
		this.steamId = steamId;
	}
	
	public Player() {
		
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

	public long getSteamId() {
		return steamId;
	}

	public void setSteamId(long steamId) {
		this.steamId = steamId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
