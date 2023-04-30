package com.mars.service;

import com.mars.entities.NavigableRover;
import com.mars.entities.Plane;
import com.mars.primitives.Rover;

import java.util.List;

public class NavigableRoverFactory implements RoverFactory {

  private static final RoverFactory INSTANCE = new NavigableRoverFactory();
  private final RoverFactory factory;

  private NavigableRoverFactory() {
    super();
    this.factory = BasicRoverFactory.getInstance();
  }

  public static RoverFactory getInstance() {
    return INSTANCE;
  }

  @Override
  public Rover createRover(Plane plane) {
    return new NavigableRover(this.factory.createRover(plane));
  }

  @Override
  public Rover createRover(String position) {
    return new NavigableRover(this.factory.createRover(position));
  }

  @Override
  public Rover createRover(char c, int x, int y) {
    return new NavigableRover(this.factory.createRover(c, x, y));
  }

  @Override
  public List<Rover> createNRovers(int n, Plane plane) {
    throw new UnsupportedOperationException();
  }
}
