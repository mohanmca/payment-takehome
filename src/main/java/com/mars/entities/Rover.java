package com.mars.entities;

import com.mars.tools.CommandParser;

import java.util.Map;

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
            this::rotateRight,
            'L',
            this::rotateLeft);
  }

  public void move(String instructions) {
    Character[] commands =
        CommandParser.INSTANCE.parseCommands(instructions, validCommands.keySet());

    // TODO: Do we need to optimize if two opposite commands comes together?
    // **We might need to deliberately burn fuel/when side-effect is required**

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

  public void rotateRight() {
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
    return "Rover{direction=" + direction + ", x=" + x + ", y=" + y + '}';
  }
}
