package com.mars.entities;

import com.mars.primitives.*;

public class BasicRover implements Movable, Identifiable, Rover {

  private static final int FORWARD = 1;
  private static final int REVERSE = -1;
  private final Long id;
  private Coordinate coordinate;
  private Direction direction;

  public BasicRover(Direction direction, Coordinate coordinate) {
    this.direction = direction;
    this.coordinate = coordinate;
    id = System.nanoTime();
  }

  public BasicRover(BasicRover clone) {
    this(clone.direction, clone.getCoordinate());
  }

  @Override
  public void move(String instructions) {
    throw new UnsupportedOperationException("This rover won't support!");
  }

  @Override
  public BasicRover forecast(String instructions) {
    BasicRover r = new BasicRover(this);
    r.move(instructions);
    return r;
  }

  @Override
  public void moveForward() {
    Coordinate delta = move(FORWARD, this.direction);
    this.coordinate = this.coordinate.add(delta.x(), delta.y());
  }

  @Override
  public void moveBackward() {
    Coordinate delta = move(REVERSE, this.direction);
    this.coordinate = this.coordinate.add(delta.x(), delta.y());
  }

  @Override
  public void rotateRight() {
    direction = direction.rotate();
  }

  @Override
  public void rotateLeft() {
    direction = direction.rotateAntiClockwise();
  }

  public Direction getDirection() {
    return direction;
  }

  public Coordinate getCoordinate() {
    return this.coordinate;
  }

  @Override
  public String toString() {
    return "BasicRover{direction=" + direction + ", Coordinate=" + coordinate.toString() + '}';
  }

  @Override
  public Long id() {
    return id;
  }
}
