package com.example.backend.repository;

import com.example.backend.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Rider, Integer> {
}
