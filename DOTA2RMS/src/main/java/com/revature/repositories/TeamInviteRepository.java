package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.data.TeamInvite;

@Repository
public interface TeamInviteRepository extends JpaRepository<TeamInvite, Long> {

}
