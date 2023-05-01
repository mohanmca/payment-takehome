package com.mars.entities;

import com.mars.constants.DefaultDummyConfigurations;
import com.mars.primitives.Direction;
import com.mars.primitives.Rover;
import com.mars.service.RoverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class PlaneTest {

    Plane simplePlane = DefaultDummyConfigurations.DEFAULT_PLANE;

    @Test
    void isOccupied() {
        Rover r = new NavigableRover(new BasicRover(Direction.NORTH, DefaultDummyConfigurations.ORIGIN));
        RoverManager manager = new RoverManager(Collections.singletonList(r), simplePlane);
        Assertions.assertFalse(simplePlane.isOccupied(DefaultDummyConfigurations.ORIGIN, r), "Object can't be in collision with itself!");
        manager.move(r.id(), "F,B,F,B");
    }
}