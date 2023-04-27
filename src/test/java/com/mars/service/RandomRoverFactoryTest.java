package com.mars.service;

import com.mars.entities.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomRoverFactoryTest {
  RoverFactory rrFactory = RandomRoverFactory.getInstance();

  @Test
  public void testCreation() {
    Rover rover = rrFactory.createRover();
    assertTrue(rover.getX() != rover.getY());
  }
}
