package com.mars.service;

import com.mars.constants.DefaultDummyConfigurations;
import com.mars.primitives.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomBasicRoverFactoryTest {
  RoverFactory rrFactory = RandomRoverFactory.getInstance();

  @Test
  public void testCreation() {
    Rover rover = rrFactory.createRover(DefaultDummyConfigurations.DEFAULT_PLANE);
    assertTrue(rover.getCoordinate().x() != rover.getCoordinate().y());
  }
}
