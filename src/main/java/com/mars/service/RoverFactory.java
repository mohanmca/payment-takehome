package com.mars.service;

import com.mars.entities.Plane;
import com.mars.primitives.Rover;

import java.util.List;

public interface RoverFactory {

  Rover createRover(Plane plane);

  Rover createRover(String position);

  Rover createRover(char c, int x, int y);

  List<Rover> createNRovers(int n, Plane plane);
}
