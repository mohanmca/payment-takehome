package com.mars.entities;

public class Rover {
  private Direction direction;
  private int x;
  private int y;

  public Rover() {
    this(Direction.NORTH, 0, 0);
  }

  public Rover(Direction direction, int x, int y) {
    this.direction = direction;
    this.x = x;
    this.y = y;
  }

  public void moveForward() {
    y += (direction == Direction.NORTH) ? 1 : 0;
    y += (direction == Direction.SOUTH) ? -1 : 0;
    x += (direction == Direction.EAST) ? 1 : 0;
    x += (direction == Direction.WEST) ? -1 : 0;
  }

  public void moveBackward() {
    y += (direction == Direction.SOUTH) ? 1 : 0;
    y += (direction == Direction.NORTH) ? -1 : 0;
    x += (direction == Direction.WEST) ? 1 : 0;
    x += (direction == Direction.EAST) ? -1 : 0;
  }

  public void rotate() {
    direction = direction.rotate();
  }

  public void rotateLeft() {
    direction = direction.rotateAntiClockwise();
  }
}
