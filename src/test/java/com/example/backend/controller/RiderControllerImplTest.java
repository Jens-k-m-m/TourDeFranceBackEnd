package com.example.backend.controller;


import com.example.backend.model.Rider;
import com.example.backend.model.Team;
import com.example.backend.repository.RiderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class RiderControllerImplTest {

  @Autowired
  private RiderRepository riderRepository;
  @Autowired
  private RiderControllerImpl riderControllerImpl;

  @BeforeTestMethod
  public void beforeTest() {
    riderRepository.deleteAll();
  }

//  {
//    "riderId": 2,
//      "riderFirstName": "Jens",
//      "riderLastName": "Madsen",
//      "riderAge": 36,
//      "riderTime": 480,
//      "riderPoint": 5,
//      "riderMountainPoints": 20,
//      "riderCountry": "Danmark",
//      "team": {
//    "teamId": 1
//  }
//  }

  @Test
  void createRider() {

    //Arrange
    Rider rider = new Rider();
                                                      // "riderId": 2,
    rider.setRiderFirstName("Test-FirstName");       // "riderFirstName": "Jens",
    rider.setRiderLastName("Test-LastName");       // "riderLastName": "Madsen",
    rider.setRiderAge(36);                       // "riderAge": 36,
    rider.setRiderTime(480);                    // "riderTime": 480,
    rider.setRiderPoint(5);                    // "riderPoint": 5,
    rider.setRiderMountainPoints(20);         // "riderMountainPoints": 20,
    rider.setRiderCountry("Test-Danmark");        // "riderCountry": "Danmark",
                                           // "team": {
    Team team = new Team();
    team.setTeamName("Jens");
    team.setTeamCountry("danmark");
                                     // "teamId": 1
    rider.setTeam(team);

    //Act
    riderControllerImpl.createRider(rider);
    Optional<Rider> optionalRider = riderRepository.findById(rider.getRiderId());
    //Assert
    assertThat(optionalRider.isPresent()).isTrue();
    assertEquals("Test-FirstName",optionalRider.get().getRiderFirstName());
    assertEquals("Test-LastName",optionalRider.get().getRiderLastName());
    assertEquals("Test-Danmark",optionalRider.get().getRiderCountry());
  }

  @Test
  void deleteRider() {
//Arrange
    Rider rider = new Rider();
    // "riderId": 2,
    rider.setRiderFirstName("Test-FirstName");       // "riderFirstName": "Jens",
    rider.setRiderLastName("Test-LastName");       // "riderLastName": "Madsen",
    rider.setRiderAge(36);                       // "riderAge": 36,
    rider.setRiderTime(480);                    // "riderTime": 480,
    rider.setRiderPoint(5);                    // "riderPoint": 5,
    rider.setRiderMountainPoints(20);         // "riderMountainPoints": 20,
    rider.setRiderCountry("Test-Danmark");        // "riderCountry": "Danmark",
    // "team": {
    Team team = new Team();
    team.setTeamName("Jens");
    team.setTeamCountry("danmark");
    // "teamId": 1
    rider.setTeam(team);

    riderControllerImpl.deleteRider(rider.getRiderId());

    Optional<Rider> optionalRider = riderRepository.findById(rider.getRiderId());

   assertThat(optionalRider.isPresent()).isFalse();
  }
}