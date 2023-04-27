package com.mars.web.controller;

import com.mars.entities.Rover;
import com.mars.service.RoverFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoverController {
  private final RoverFactory factory;

  public RoverController(RoverFactory factory) {
    this.factory = factory;
  }

  @GetMapping("/rover/create")
  Rover newRover(Character direction, Integer x, Integer y) {
    return factory.createRover(direction, x, y);
  }
}
