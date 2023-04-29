package com.mars.service;

import com.mars.entities.Plain;
import com.mars.entities.Rover;

import java.util.List;

public interface RoverFactory {

  Rover createRover(Plain plain);

  Rover createRover(String position);

  Rover createRover(char c, int x, int y);

  List<Rover> createNRovers(int n, Plain plain);
}
