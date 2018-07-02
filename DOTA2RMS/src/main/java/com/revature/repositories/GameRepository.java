package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.data.Game;
import com.revature.data.Hero;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
