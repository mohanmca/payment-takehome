package com.mars.primitives;

import com.mars.primitives.Coordinate;
import com.mars.primitives.Direction;

/**
 * Mixin interface to implement moveForward and moveBackward
 */
public interface Movable {
  default Coordinate move(int scale, Direction direction) {
    int dx = 0, dy = 0;
    dy += (direction == Direction.NORTH) ? scale : 0;
    dy += (direction == Direction.SOUTH) ? -1 * scale : 0;
    dx += (direction == Direction.EAST) ? scale : 0;
    dx += (direction == Direction.WEST) ? -1 * scale : 0;
    return new Coordinate(dx, dy);
  }
}
