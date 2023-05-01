package com.mars.service;

import com.mars.primitives.Direction;
import com.mars.primitives.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicRoverFactoryTest {
  RoverFactory factory = BasicRoverFactory.getInstance();

  @Test
  public void testCreation() {
    Rover rover = factory.createRover('N', 3, 4);
    assertEquals(rover.getDirection(), Direction.NORTH);
    assertEquals(rover.getCoordinate().x(), 3);
    rover.moveForward();
    assertEquals(rover.getCoordinate().x(), 3);
    assertEquals(rover.getCoordinate().y(), 5);
    rover.moveForward();
    rover.moveBackward();
    assertEquals(rover.getCoordinate().x(), 3);
    assertEquals(rover.getCoordinate().y(), 5);
  }

  @Test
  public void testDirection() {
    Rover rover = factory.createRover('N', 3, 4);
    rover.rotateLeft();
    assertEquals(rover.getCoordinate().x(), 3);
    assertEquals(rover.getCoordinate().y(), 4);
    assertEquals(rover.getDirection(), Direction.WEST);
  }

  @Test
  public void testRotation() {
    Rover rover = factory.createRover('N', 3, 4);
    for (int i = 0; i < 4; i++) {
      rover.moveForward();
      rover.moveBackward();
    }
    assertEquals(rover.getCoordinate().x(), 3);
    assertEquals(rover.getCoordinate().y(), 4);
    assertEquals(rover.getDirection(), Direction.NORTH);

    rover.rotateLeft();
    rover.rotateLeft();
    for (int i = 0; i < 4; i++) {
      rover.moveForward();
      rover.rotateRight();
    }

    assertEquals(rover.getCoordinate().x(), 3);
    assertEquals(rover.getCoordinate().y(), 4);
    assertEquals(rover.getDirection(), Direction.SOUTH);
  }

  @Test
  public void testUnsupported() {
    Rover rover = factory.createRover('N', 3, 4);
    Exception exception =
        assertThrows(
            UnsupportedOperationException.class,
            () -> {
              rover.move("F,R");
            });

    String expectedMessage = "This rover won't support!";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
