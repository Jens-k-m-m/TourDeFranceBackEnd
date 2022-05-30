package com.example.backend.repository;

import com.example.backend.model.Rider;
import com.example.backend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
