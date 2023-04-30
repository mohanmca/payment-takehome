package com.mars.primitives;

public interface Rover {
  void move(String instructions);

  Rover project(String instructions);

  void moveForward();

  void moveBackward();

  void rotateRight();

  void rotateLeft();

  Direction getDirection();

  Coordinate getCoordinate();

  Long id();
}
