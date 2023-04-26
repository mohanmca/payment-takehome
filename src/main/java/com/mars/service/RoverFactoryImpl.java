package com.mars.service;

import com.mars.entities.Direction;
import com.mars.entities.Rover;

/** This is singleton, we can encode singleton as per EJ-3. */
public class RoverFactoryImpl implements RoverFactory {

  private static final RoverFactory INSTANCE = new RoverFactoryImpl();

  private RoverFactoryImpl() {
    super();
  }

  public static RoverFactory getInstance() {
    return INSTANCE;
  }

  @Override
  public Rover createRover() {
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
    return new Rover(d, x, y);
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
