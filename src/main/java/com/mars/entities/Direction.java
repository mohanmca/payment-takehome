package com.mars.entities;

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
}
