package com.revature.data;

import javax.persistence.*;

//@Entity
@Table
public class PlayerDota2Profile {
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Game game;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Player player;
	
	@Column(columnDefinition = "varchar2(500 char)")
	private String details;
	
	@Column
	private long playtime;
	
	@Column
	private long kills;
	
	@Column
	private long deaths;
	
	@Column
	private long assists;
	
	@Column
	private int position;
	
	@OneToOne
	private Hero hero1;
	
	@OneToOne
	private Hero hero2;
	
	@OneToOne
	private Hero hero3;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public long getPlaytime() {
		return playtime;
	}

	public void setPlaytime(long playtime) {
		this.playtime = playtime;
	}

	public long getKills() {
		return kills;
	}

	public void setKills(long kills) {
		this.kills = kills;
	}

	public long getDeaths() {
		return deaths;
	}

	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}

	public long getAssists() {
		return assists;
	}

	public void setAssists(long assists) {
		this.assists = assists;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Hero getHero1() {
		return hero1;
	}

	public void setHero1(Hero hero1) {
		this.hero1 = hero1;
	}

	public Hero getHero2() {
		return hero2;
	}

	public void setHero2(Hero hero2) {
		this.hero2 = hero2;
	}

	public Hero getHero3() {
		return hero3;
	}

	public void setHero3(Hero hero3) {
		this.hero3 = hero3;
	}
	
	
}
