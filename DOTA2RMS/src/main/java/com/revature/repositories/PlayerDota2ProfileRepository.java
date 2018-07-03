package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.data.PlayerDota2Profile;
import com.revature.data.PlayerGameId;

@Repository
public interface PlayerDota2ProfileRepository extends JpaRepository<PlayerDota2Profile, PlayerGameId> {

}
