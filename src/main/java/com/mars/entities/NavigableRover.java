package com.mars.entities;

import com.mars.primitives.Coordinate;
import com.mars.primitives.Direction;
import com.mars.primitives.Identifiable;
import com.mars.primitives.Rover;
import com.mars.tools.CommandParser;

import java.util.Map;

public class NavigableRover implements Rover, Identifiable {
  private final Rover rover;
  private final Long id;
  private Map<Character, Runnable> validCommands;

  public NavigableRover(Rover r) {
    id = System.nanoTime();
    this.rover = r;
    initialize();
  }

  private void initialize() {

    validCommands =
        Map.of(
            'B',
            this.rover::moveBackward,
            'F',
            this.rover::moveForward,
            'R',
            this.rover::rotateRight,
            'L',
            this.rover::rotateLeft);
  }

  @Override
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

  @Override
  public NavigableRover project(String instructions) {
    NavigableRover r = new NavigableRover(this);
    r.move(instructions);
    return r;
  }

  @Override
  public void moveForward() {
    this.rover.moveForward();
  }

  @Override
  public void moveBackward() {
    this.rover.moveBackward();
  }

  @Override
  public void rotateRight() {
    this.rover.rotateRight();
  }

  @Override
  public void rotateLeft() {
    this.rover.rotateLeft();
  }

  @Override
  public Direction getDirection() {
    return this.rover.getDirection();
  }

  @Override
  public Coordinate getCoordinate() {
    return this.rover.getCoordinate();
  }

  @Override
  public String toString() {
    return "NavigableRover{ id="
        + id
        + ", direction="
        + this.rover.getDirection()
        + ", Coordinate="
        + this.rover
        + '}';
  }

  @Override
  public Long id() {
    return id;
  }
}
