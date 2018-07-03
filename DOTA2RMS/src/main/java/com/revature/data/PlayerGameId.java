package com.revature.data;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class PlayerGameId implements Serializable {
	@ManyToOne(cascade=CascadeType.ALL)
	private Game game;

	@ManyToOne(cascade=CascadeType.ALL)
	private Player player;
	
	public PlayerGameId() {
		
	}

	public PlayerGameId(Player player, Game game) {
		this.player = player;
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game team) {
		this.game = team;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
