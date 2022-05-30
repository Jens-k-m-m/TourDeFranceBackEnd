package com.example.backend.config;

import com.example.backend.repository.RiderRepository;
import com.example.backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitData implements CommandLineRunner {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TeamRepository teamRepository;

  @Override
  public void run(String... args) throws Exception {

  }
}
