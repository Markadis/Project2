package data;

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
	
	@Column
	private Hero hero1;
	
	@Column
	private Hero hero2;
	
	@Column
	private Hero hero3;
}
