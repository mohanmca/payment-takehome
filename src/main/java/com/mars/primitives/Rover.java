package com.mars.primitives;

public interface Rover {

  Rover clone();

  void move(String instructions);

  Rover forecast(String instructions);

  void moveForward();

  void moveBackward();

  void rotateRight();

  void rotateLeft();

  Direction getDirection();

  Coordinate getCoordinate();

  Long id();
}
