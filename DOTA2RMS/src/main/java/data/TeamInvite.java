package data;

import javax.persistence.*;

//@Entity
@Table
public class TeamInvite {
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Team team;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Player user;
	
	@Column
	private int status;
	
	@Column
	private int type;
}
