package com.example.backend.controller;

import com.example.backend.model.Rider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RiderController {
  /**
   * Get a list of Riders from the database. The mapping is /show/players
   *
   * @return A list of players
   * @author Jens
   */
  @GetMapping("/show/riders")
  public List<Rider> getAllRiders();

  /**
   * Create a rider in the database. When done it returns a HTTP response 200 (OK) Mapping is
   * /create/rider
   *
   * @param rider - given player to create.
   * @return A HTTP response
   * @author Jens
   */
  @PostMapping("/create/riders")
  public ResponseEntity<Rider> createRider(@RequestBody Rider rider);


  /**
   *
   * @param searchById
   * @return
   */
  @GetMapping("findRiderById/rider/{searchById}")
  public List<Rider> getRiderBySearchId(@PathVariable int searchById);

  /**
   * Update a player. by id
   * @param  searchById - Rider id
   * @param rider - updated rider in JSON
   * @return A HTTP response
   * @author Jens
   */
  @PutMapping("update/rider/{searchById}")
  public ResponseEntity<String> updateRider(@PathVariable int searchById, @RequestBody Rider rider);
}
