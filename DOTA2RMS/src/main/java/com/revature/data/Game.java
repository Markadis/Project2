package com.revature.data;

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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","playerGameList"})
public class Game {
	
	@Id
	@Column(name="GAME_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gameIdSequence")
	@SequenceGenerator(allocationSize=1, name="gameIdSequence", sequenceName="SQ_GAMEID_PK")
	private long id;
	
	@Column(unique = true)
	private String name;
	
	@Column(columnDefinition = "varchar2(500 char)")
	private String details;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="primaryKey.game", cascade = {CascadeType.ALL})
	private List<PlayerGame> playerGameList = new ArrayList();
	
	public Game() {
		
	}

	public Game(String name, String details) {
		this.name = name;
		this.details = details;
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

	@Override
	public String toString() {
		return "[id: " + id + " name: " + name + " details: " + details + "]";
	}
	
	
	
}
