package com.mars.constants;

import com.mars.entities.Coordinate;
import com.mars.entities.Plain;

/**
 * If any class refers this, that should be only for testing If they are still being used, it is for
 * shortcut and assumption
 */
public interface DefaultDummyConfigurations {
  int MINX = -100;
  int MAXX = 100;
  int MINY = MINX;
  int MAXY = MAXX;

  Coordinate BOTTOM_RIGHT = new Coordinate(MAXX , MINY);
  Coordinate TOP_LEFT = new Coordinate(MINX , MAXY);
  Plain DEFAULT_PLAIN = new Plain(TOP_LEFT, BOTTOM_RIGHT);
}