package com.mars.entities;

import com.mars.service.RoverFactory;

import java.util.Map;
import java.util.TreeMap;

public class RoverPlanet {

  final int numberOfRovers;
  final RoverFactory factory;

  final Map<Integer, Rover> roverMap = new TreeMap<>();

  public RoverPlanet(int numberOfRovers, RoverFactory factory) {
    this.numberOfRovers = numberOfRovers;
    this.factory = factory;
  }

//  private void init() {
//    for(int i=0;i<numberOfRovers; i++) {
//      roverMap.put(i, factory.)
//    }
//  }

}
