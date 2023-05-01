package com.mars.service;

import com.mars.constants.DefaultDummyConfigurations;
import com.mars.entities.Plane;
import com.mars.primitives.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoverManagerTest {
    @Test
    public void testCreation() {
        Plane testPlane = DefaultDummyConfigurations.DEFAULT_PLANE;
        RoverManager roverManager =
                new RoverManager(
                        0, RandomRoverFactory.getInstance(), DefaultDummyConfigurations.DEFAULT_PLANE);

        testPlane.isOccupied(DefaultDummyConfigurations.ORIGIN, testPlane);

        Rover rover = RandomRoverFactory.getInstance().createRover('N', 0, 0);
        roverManager.addRover(rover);

        rover = RandomRoverFactory.getInstance().createRover('N', 0, -1);
        rover.moveForward();

        Assertions.assertFalse(roverManager.addRover(rover), "There should be collision detection!");


    }
}