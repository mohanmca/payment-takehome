package com.mars.entities;

import java.util.TreeMap;

public class Plain {

  private final Coordinate topLeft, bottomRight;
  TreeMap<Coordinate, Coordinate> objects = new TreeMap<>();

  public Plain(Coordinate topLeft, Coordinate bottomRight) {
    this.topLeft = topLeft;
    this.bottomRight = bottomRight;
  }

  public void register(Coordinate coordinate) {
    if (isInside(coordinate) && !isOccupied(coordinate)) {
      objects.put(coordinate, coordinate);
    }
  }

  public boolean isOccupied(Coordinate coordinate) {
    if (coordinate.x() > this.bottomRight.x() || coordinate.x() < this.topLeft.x()) return true;
    if (coordinate.y() < this.bottomRight.y() || coordinate.y() > this.topLeft.y()) return true;
    return objects.containsKey(coordinate);
  }

  public void migrate(Coordinate from, Coordinate to) {
    objects.remove(from);
    objects.put(to, to);
  }

  private boolean isInside(Coordinate coordinate) {
    if (coordinate.x() < topLeft.x() || coordinate.x() > bottomRight.x()) return false;
    return (coordinate.y() <= topLeft.y() || coordinate.y() >= bottomRight.y());
  }

  public Coordinate getTopLeft() {
    return topLeft;
  }

  public Coordinate getBottomRight() {
    return bottomRight;
  }
}
