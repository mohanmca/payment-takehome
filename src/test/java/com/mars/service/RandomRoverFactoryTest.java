package com.mars.service;

import com.mars.entities.Direction;
import com.mars.entities.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomRoverFactoryTest {
    RoverFactory rrFactory = RandomRoverFactory.getInstance();

    @Test
    public void testCreation() {
        Rover rover = rrFactory.createRover();
        assertEquals(rover.getDirection(), Direction.NORTH);
    }

}