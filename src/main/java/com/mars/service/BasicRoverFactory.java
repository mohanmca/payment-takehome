package com.mars.service;

import com.mars.entities.*;
import com.mars.primitives.Coordinate;
import com.mars.primitives.Direction;
import com.mars.primitives.Rover;

import java.util.List;

/** This is singleton, we can encode singleton as per EJ-3. */
public class BasicRoverFactory implements RoverFactory {

  private static final RoverFactory INSTANCE = new BasicRoverFactory();

  private BasicRoverFactory() {
    super();
  }

  public static RoverFactory getInstance() {
    return INSTANCE;
  }

  @Override
  public Rover createRover(Plane plane) {
    throw new UnsupportedOperationException("This factory won't create random rovers!");
  }

  @Override
  public Rover createRover(String position) {
    String[] coordinates = position.split(",");
    if (isValidCoordinate(coordinates)) {
      return createRover(
          coordinates[2].charAt(0),
          Integer.parseInt(coordinates[0]),
          Integer.parseInt(coordinates[1]));
    }
    throw new IllegalArgumentException("Co-ordinates are not valid");
  }

  @Override
  public Rover createRover(char c, int x, int y) {
    Direction d = Direction.EAST.directionFor(c);
    Coordinate coord = new Coordinate(x, y);
    return new BasicRover(d, coord);
  }

  @Override
  public List<Rover> createNRovers(int n, Plane p) {
    throw new UnsupportedOperationException();
  }

  private boolean isValidCoordinate(String[] coordinates) {
    return (coordinates.length == 3)
        && isNumber(coordinates[0])
        && isNumber(coordinates[1])
        && (coordinates[2].length() == 1)
        && Character.isLetter(coordinates[2].charAt(0));
  }

  private boolean isNumber(String number) {
    number = number.trim();
    try {
      Integer.parseInt(number);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
