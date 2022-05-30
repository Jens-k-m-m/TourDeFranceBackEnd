package com.example.backend.controller;

import com.example.backend.model.Rider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RiderController {
  /**
   * Get a list of Riders from the database. The mapping is /show/players
   * @return A list of players
   *  @author Jens
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
}


