package com.mars.entities;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class Rover {

  private Map<Character, Runnable> validCommands;

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
    initialize();
  }

  private void initialize() {
    validCommands =
        Map.of(
            'B',
            this::moveBackward,
            'F',
            this::moveForward,
            'R',
            this::rotate,
            'L',
            this::rotateLeft);
  }

  public void move(String instructions) {
    Character[] commands =
        Arrays.stream(instructions.toUpperCase().split(","))
            .map(s -> s.charAt(0))
            .toArray(Character[]::new);

    Optional<Character> invalidCommands =
        Arrays.stream(commands).filter(Predicate.not(validCommands.keySet()::contains)).findAny();
    if (invalidCommands.isPresent()) throw new IllegalArgumentException("Commands are not valid");

    // TODO: Do we need to optimize if two opposite commands comes together?
    // At-least one-case where we should not optimize if we need to deliberately burn fuel

    for (Character command : commands) {
      Runnable action = validCommands.get(command);
      action.run();
    }
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

  public Direction getDirection() {
    return direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return "Rover{" + ", direction=" + direction + ", x=" + x + ", y=" + y + '}';
  }
}
