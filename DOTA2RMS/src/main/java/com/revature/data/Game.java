package com.revature.data;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
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
	
	public Game() {
		
	}

	public Game(String name, String details) {
		this.name = name;
		this.details = details;
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
