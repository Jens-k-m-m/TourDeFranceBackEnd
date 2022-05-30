package com.example.backend.controller;

import com.example.backend.model.Rider;
import com.example.backend.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RiderControllerImpl implements RiderController {


  @Autowired
  RiderRepository riderRepository;

  @Override
  public List<Rider> getRiderByFirstName(String searchFirstName) {
    return riderRepository.findRiderByRiderFirstName(searchFirstName);
  }

  @Override
  public List<Rider> getAllRiders() {
    return riderRepository.findAll();
  }


  @Override
  public ResponseEntity<Rider> createRider(Rider rider) {
    riderRepository.save(rider);
    return new ResponseEntity<>(rider, HttpStatus.CREATED);
  }

  @Override
  public List<Rider> getRiderBySearchId(int searchById) {
    return riderRepository.findRiderByRiderId(searchById);
  }

  @Override
  public ResponseEntity<String> updateRider(int searchById, Rider rider) {
    rider.setRiderId(searchById);
    Optional<Rider> updateRider = riderRepository.findById(searchById);
    try {
      if (updateRider.isPresent()) {
        riderRepository.save(rider);
      }else {
        return new ResponseEntity<>("Rider not Updated", HttpStatus.NOT_ACCEPTABLE);
      }
    }catch (Exception e) {// TODO: fix exception to custom
      return new ResponseEntity<>("Rider not Updated\nError: " + e, HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>("Rider Updated", HttpStatus.OK);
  }
}
