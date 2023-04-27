package com.mars.entities;

import com.mars.service.RandomRoverFactory;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mars {

  final int numberOfRovers;
  final RandomRoverFactory factory;

  final Map<Integer, Rover> roverMap = new TreeMap<>();

  public Mars(int numberOfRovers, RandomRoverFactory factory) {
    this.numberOfRovers = numberOfRovers;
    this.factory = factory;
  }

  private void init() {
    List<Rover> rovers = factory.createNRovers(numberOfRovers);

  }
}
