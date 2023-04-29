package com.mars.entities;

import com.mars.tools.CommandParser;

import java.util.Map;

public class Rover implements Identifiable {

  private final Long id;
  private Map<Character, Runnable> validCommands;
  private Direction direction;
  private Coordinate coordinate;

  public Rover() {
    this(Direction.NORTH, Coordinate.ORIGIN);
  }

  public Rover(Direction direction, Coordinate coordinate) {
    this.direction = direction;
    this.coordinate = coordinate;
    id = System.nanoTime();
    initialize();
  }

  public Rover(Rover clone) {
    this(clone.direction, clone.getCoordinate());
  }

  private void initialize() {

    validCommands =
        Map.of(
            'B',
            this::moveBackward,
            'F',
            this::moveForward,
            'R',
            this::rotateRight,
            'L',
            this::rotateLeft);
  }

  public void move(String instructions) {
    if (instructions.isEmpty()) return;
    Character[] commands =
        CommandParser.INSTANCE.parseCommands(instructions, validCommands.keySet());

    // TODO: Do we need to optimize if two opposite commands comes together?
    // **We might need to deliberately burn fuel/when side-effect is required**

    for (Character command : commands) {
      Runnable action = validCommands.get(command);
      action.run();
    }
  }

  public Rover project(String instructions) {
    Rover r = new Rover(this);
    r.move(instructions);
    return r;
  }

  public void moveForward() {
    int dx = 0, dy = 0;
    dy += (direction == Direction.NORTH) ? 1 : 0;
    dy += (direction == Direction.SOUTH) ? -1 : 0;
    dx += (direction == Direction.EAST) ? 1 : 0;
    dx += (direction == Direction.WEST) ? -1 : 0;
    this.coordinate = this.coordinate.add(dx, dy);
  }

  public void moveBackward() {
    int dx = 0, dy = 0;
    dy += (direction == Direction.SOUTH) ? 1 : 0;
    dy += (direction == Direction.NORTH) ? -1 : 0;
    dx += (direction == Direction.WEST) ? 1 : 0;
    dx += (direction == Direction.EAST) ? -1 : 0;
    this.coordinate = this.coordinate.add(dx, dy);
  }

  public void rotateRight() {
    direction = direction.rotate();
  }

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
    return "Rover{direction=" + direction + ", Coordinate=" + coordinate.toString() + '}';
  }

  @Override
  public Long id() {
    return id;
  }
}
