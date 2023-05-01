package com.mars.service;

import com.mars.primitives.Direction;
import com.mars.primitives.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NavigableRoverFactoryTest {
    @Test
    public void testMoveInstructions() {
        Rover rover = NavigableRoverFactory.getInstance().createRover('N', -2, -18);
        rover.move("R,R,F,L");
        Assertions.assertEquals(rover.getCoordinate().x(), -2);
        Assertions.assertEquals(rover.getCoordinate().y(), -19);
        Assertions.assertEquals(rover.getDirection(), Direction.EAST);
    }

    @Test
    public void testMoveInstructionsWithLeft() {
        Rover rover = NavigableRoverFactory.getInstance().createRover('N', 1, -19);
        rover.move("F,F,F,L");
        Assertions.assertEquals(rover.getCoordinate().x(), 1);
        Assertions.assertEquals(rover.getCoordinate().y(), -16);
        Assertions.assertEquals(rover.getDirection(), Direction.WEST);
    }
}
