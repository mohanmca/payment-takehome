package com.mars.web.controller;

import com.mars.entities.Rover;
import com.mars.service.RoverFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class RoverController {
  private final RoverFactory factory;
  Map<Integer, Rover> registry = new TreeMap<Integer, Rover>();

  public RoverController(RoverFactory factory) {
    this.factory = factory;
  }

  @GetMapping("/rover/create")
  Rover newRover(Character direction, Integer x, Integer y) {
    Integer id = registry.size();
    registry.put(registry.size(), factory.createRover(direction, x, y));
    return registry.get(id);
  }

  @GetMapping("/rover/navigate")
  Rover navigate(Integer id, String commands) {
    Rover r = registry.get(id);
    r.move(commands);
    return r;
  }

  @GetMapping("/rover/createN")
  List<Rover> createNRovers(int n) {
    List<Rover> rovers = factory.createNRovers(n);
    for (Rover r : rovers) {
      Integer id = registry.size();
      registry.put(registry.size(), r);
    }
    return rovers;
  }
}
