package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.data.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	Player findByUsername(String username);

	Player findByUsernameAndPassword(String username, String password);
	
}
