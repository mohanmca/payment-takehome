package com.mars.constants;

import com.mars.primitives.Coordinate;
import com.mars.entities.Plane;

/**
 * If any class refers this interface, that implementation should be only for testing.
 * This is for shortcut, testing and with assumptions only
 **/
public interface DefaultDummyConfigurations {
  int MINX = -20;
  int MAXX = 20;
  int MINY = MINX;
  int MAXY = MAXX;
  Coordinate BOTTOM_RIGHT = new Coordinate(MAXX, MINY);
  Coordinate TOP_LEFT = new Coordinate(MINX, MAXY);
  Coordinate ORIGIN = new Coordinate(0, 0);
  Plane DEFAULT_PLANE = new Plane(TOP_LEFT, BOTTOM_RIGHT);
}
