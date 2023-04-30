package com.mars.constants;

import com.mars.primitives.Coordinate;
import com.mars.entities.Plane;

/**
 * If any class refers this interface, that implementation should be only for testing.
 * This is for shortcut, testing and with assumptions only
 **/
public interface DefaultDummyConfigurations {
  int MINX = -100;
  int MAXX = 100;
  int MINY = MINX;
  Coordinate BOTTOM_RIGHT = new Coordinate(MAXX, MINY);
  int MAXY = MAXX;
  Coordinate TOP_LEFT = new Coordinate(MINX, MAXY);
  Plane DEFAULT_PLANE = new Plane(TOP_LEFT, BOTTOM_RIGHT);
}
