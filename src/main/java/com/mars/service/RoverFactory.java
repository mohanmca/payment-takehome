package com.mars.service;

import com.mars.entities.Rover;

public interface RoverFactory {

  Rover createRover();

  Rover createRover(String position);

  Rover createRover(char c, int x, int y);
}
