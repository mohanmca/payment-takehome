package com.mars.entities;

import com.mars.service.RoverFactory;
import com.mars.utils.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TrafficController {

  final int numberOfRovers;
  final RoverFactory factory;
  final Plane plane;
  final Map<Integer, Rover> roverMap = new TreeMap<>();

  public TrafficController(int numberOfRovers, RoverFactory factory, Plane plane) {
    this.plane = plane;
    this.numberOfRovers = numberOfRovers;
    this.factory = factory;
    init();
  }

  private void init() {
    List<Rover> rovers = factory.createNRovers(numberOfRovers, plane);
    for (int i = 0; i < rovers.size(); i++) {
      roverMap.put(i, rovers.get(i));
    }
    for (Rover r : rovers) plane.register(r.getCoordinate());
  }

  public Rover move(int id, String instructions) {
    Rover rover = roverMap.get(id);
    Character[] commands = StringUtils.split(instructions);

    Rover r = rover.project("");
    StringBuilder sb = new StringBuilder();
    for (Character c : commands) {
      r = r.project(c + "");
      if (plane.isOccupied(r.getCoordinate())) {
        System.err.println("***Collision detected! -" + r.id());
        break;
      } else {
        sb.append(c);
      }
    }
    Coordinate from = rover.getCoordinate();
    rover.move(sb.toString());
    Coordinate to = rover.getCoordinate();
    plane.migrate(from, to);
    return rover;
  }
}
