package com.example.app0803.repository;


import com.example.app0803.pojo.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findTeamByTeamName(String name);
}
