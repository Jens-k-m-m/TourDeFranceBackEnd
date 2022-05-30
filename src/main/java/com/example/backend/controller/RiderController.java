package com.example.backend.controller;

import com.example.backend.model.Rider;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface RiderController {

  @GetMapping("/riders")
  public List<Rider> getAllRiders();
}


