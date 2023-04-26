package com.mars.service;

import com.mars.entities.Direction;
import com.mars.entities.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class RoverFactoryTest {
    RoverFactory factory =  RoverFactory.getInstance();

    @Test
    public void testCreation() {
        Rover rover = factory.createRover('N', 3, 4);
        assertEquals(rover.getDirection(), Direction.NORTH);
        assertEquals(rover.getX(), 3);
        rover.move("F");
        assertEquals(rover.getX(), 3);
        assertEquals(rover.getY(), 5);
        rover.move("F,B");
        assertEquals(rover.getX(), 3);
        assertEquals(rover.getY(), 5);
    }


}