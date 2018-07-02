package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.data.Player;
import com.revature.data.PlayerTeam;
import com.revature.data.PlayerTeamId;

@Repository
public interface PlayerTeamRepository extends JpaRepository<PlayerTeam, PlayerTeamId> {

}
