package com.example.backend.controller;

import com.example.backend.model.Rider;
import com.example.backend.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class RiderControllerImpl implements RiderController {

  @Autowired
  RiderRepository riderRepository;
  @Override
  public List<Rider>getAllRiders() {
    return riderRepository.findAll();
  }
}
