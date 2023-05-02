package com.mars;

import com.mars.primitives.Rover;
import com.mars.service.NavigableRoverFactory;
import com.mars.service.RoverFactory;

public class Main {
  public static void main(String[] args) {
    RoverFactory factory = NavigableRoverFactory.getInstance();
    Rover r = factory.createRover("3,4,N");
    r.move("F,F,R,F,F");
    System.out.println(r.toString());
  }
}
