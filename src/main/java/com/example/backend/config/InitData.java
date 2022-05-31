package com.example.backend.config;

import com.example.backend.model.Rider;
import com.example.backend.model.Team;
import com.example.backend.repository.RiderRepository;
import com.example.backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TeamRepository teamRepository;

  @Override
  public void run(String... args) throws Exception {

    Team cofidis = new Team();
    cofidis.setTeamId(1);
    cofidis.setTeamName("Cofidis");
    cofidis.setTeamCountry("France");
    teamRepository.save(cofidis);

    Team adidas = new Team();
    adidas.setTeamId(2);
    adidas.setTeamName("adidas");
    adidas.setTeamCountry("Iceland");
    teamRepository.save(adidas);


    //Arrange
    Rider rider = new Rider();
    rider.setRiderFirstName("Simon");
    rider.setRiderLastName("Geschke");
    rider.setRiderAge(36);
    rider.setRiderTime(480);
    rider.setRiderPoint(160);
    rider.setRiderMountainPoints(30);
    rider.setRiderCountry("Germany");
    // "team": {
    Team team = new Team();
    team.setTeamId(1);
    rider.setTeam(team);
    riderRepository.save(rider);


    //Arrange
    Rider rider1 = new Rider();
    rider1.setRiderFirstName("Monteiro");
    rider1.setRiderLastName("Lounde");
    rider1.setRiderAge(24);
    rider1.setRiderTime(328);
    rider1.setRiderPoint(160);
    rider1.setRiderMountainPoints(30);
    rider1.setRiderCountry("Iceland");
    // "team": {
    Team team1 = new Team();
    team1.setTeamId(1);
    rider.setTeam(team1);
    riderRepository.save(rider1);
  }
}
