package com.revature.data;

import javax.persistence.*;

@Entity
@Table(name="PLAYER_GAME")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.player",
        joinColumns = @JoinColumn(name = "PLAYER_ID")),
    @AssociationOverride(name = "primaryKey.game",
        joinColumns = @JoinColumn(name = "GAME_ID")) })
public class PlayerGame {
	@EmbeddedId
	private PlayerGameId primaryKey = new PlayerGameId();
	
	public PlayerGame() {
		
	}
	
	public PlayerGame(Player player, Game game) {
		primaryKey.setPlayer(player);
		primaryKey.setGame(game);
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

	public void setPlayer(Player player) {
		getPrimaryKey().setPlayer(player);
	}
	@Transient
	public Game getGame() {
		return getPrimaryKey().getGame();
	}

	public void setGame(Game game) {
		getPrimaryKey().setGame(game);
	}
	
	
}
