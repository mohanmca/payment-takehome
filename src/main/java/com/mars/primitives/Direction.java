package com.mars.primitives;

public enum Direction {
  NORTH() {
    public Direction rotate() {
      return Direction.EAST;
    }

    public Direction rotateAntiClockwise() {
      return Direction.WEST;
    }
  },
  SOUTH() {
    public Direction rotate() {
      return Direction.WEST;
    }

    public Direction rotateAntiClockwise() {
      return Direction.EAST;
    }
  },
  EAST() {
    public Direction rotate() {
      return Direction.SOUTH;
    }

    public Direction rotateAntiClockwise() {
      return Direction.NORTH;
    }
  },
  WEST() {
    public Direction rotate() {
      return Direction.NORTH;
    }

    public Direction rotateAntiClockwise() {
      return Direction.SOUTH;
    }
  };

  public Direction rotate() {
    return Direction.NORTH;
  }

  public Direction rotateAntiClockwise() {
    return Direction.SOUTH;
  }

  public Direction directionFor(char c) {
    if (c == 'N' || c == 'n') return Direction.NORTH;
    if (c == 'S' || c == 's') return Direction.SOUTH;
    if (c == 'E' || c == 'e') return Direction.EAST;
    if (c == 'W' || c == 'w') return Direction.WEST;
    throw new IllegalArgumentException("There is no such direction");
  }
}
