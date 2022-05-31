package com.example.backend.controller;

import com.example.backend.model.Rider;
import com.example.backend.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * implements RiderController
 */
@CrossOrigin
@RestController
public class RiderControllerImpl implements RiderController {

  @Autowired
  RiderRepository riderRepository;

  /**
   * Get a list of Riders from the database. The mapping is /byFirstName/riders/{searchFirstName}
   *
   * @param searchFirstName
   * @return A list of rider have the same  FirstName
   * @author Jens
   */
  @Override
  public List<Rider> getRiderByFirstName(String searchFirstName) {
    return riderRepository.findRiderByRiderFirstName(searchFirstName);
  }

  /**
   * Get a list of Riders from the database. The mapping is /show/players
   *
   * @return A list of players
   * @author Jens
   */
  @Override
  public List<Rider> getAllRiders() {
    return riderRepository.findAll();
  }

  /**
   * Create a rider in the database. When done it returns a HTTP response 200 (OK) Mapping is
   * /create/rider
   *
   * @param rider - given player to create.
   * @return A HTTP response
   * @author Jens
   */
  @Override
  public ResponseEntity<Rider> createRider(Rider rider) {
    System.out.println(rider + "RiderController");
    Rider nu = riderRepository.save(rider);
    System.out.println(nu + "Nu NU RiderController");
    return new ResponseEntity<>(rider, HttpStatus.CREATED);
  }

  /**
   * Get a list of Riders from the database. The mapping is /findRiderById/rider/{searchById}
   *
   * @param searchById
   * @return int rider id;
   * @author Jens
   */
  @Override
  public List<Rider> getRiderBySearchId(int searchById) {
    return riderRepository.findRiderByRiderId(searchById);
  }

  /**
   * Update a player. by id
   *
   * @param searchById - Rider id
   * @param rider      - updated rider in JSON
   * @return A HTTP response
   * @author Jens
   */
  @Override
  public ResponseEntity<String> updateRider(int searchById, Rider rider) {
    rider.setRiderId(searchById);
    Optional<Rider> updateRider = riderRepository.findById(searchById);
    try {
      if (updateRider.isPresent()) {
        riderRepository.save(rider);
      } else {
        return new ResponseEntity<>("Rider not Updated", HttpStatus.NOT_ACCEPTABLE);
      }
    } catch (Exception e) {// TODO: fix exception to custom
      return new ResponseEntity<>("Rider not Updated\nError: " + e, HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>("Rider Updated", HttpStatus.OK);
  }

  /**
   * Delete an rider found by id, delete from database
   *
   * @param id - rider id
   * @return A HTTP response
   * @author Jens
   */
  @Override
  public ResponseEntity<String> deleteRider(int id) {
    try {
      riderRepository.deleteById(id);
      return new ResponseEntity<>("delete id = " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not id at all = " + id, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Get a list of rider from the Team id form database.  The mapping is /team/rider/{id}
   *
   * @return int id form Team
   * @author Jens
   */
  @Override
  public List<Rider> getRiderFromTeam(int id) {
    List<Rider> riderList = riderRepository.findAll();
    List<Rider> riderListResult = new ArrayList<>();
    if (!riderList.isEmpty()) {
      for (Rider rider : riderList) {
        if (rider.getTeam().getTeamId() == id) {
          riderListResult.add(rider);
        }
      }
    }
    return riderListResult;
  }
}