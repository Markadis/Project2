package com.revature.data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.player",
        joinColumns = @JoinColumn(name = "PLAYER_ID")),
    @AssociationOverride(name = "primaryKey.game",
        joinColumns = @JoinColumn(name = "GAME_ID")) })
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "player", "game"})
public class PlayerDota2Profile {

	@EmbeddedId
	private PlayerGameId primaryKey = new PlayerGameId();
	
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
	
	@OneToOne (cascade = CascadeType.ALL)
	private Hero hero1;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Hero hero2;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Hero hero3;
	
	public PlayerDota2Profile() {
		
	}

	public PlayerDota2Profile(Player player, Game game, String details) {
		primaryKey.setPlayer(player);
		primaryKey.setGame(game);
		this.details = details;
	}

	public PlayerGameId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(PlayerGameId primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Transient
	public Player getPlayer() {
		return getPrimaryKey().getPlayer();
	}
	@Transient
	public void setPlayer(Player player) {
		getPrimaryKey().setPlayer(player);
	}
	@Transient
	public Game getGame() {
		return getPrimaryKey().getGame();
	}
	@Transient
	public void setGame(Game game) {
		getPrimaryKey().setGame(game);
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
