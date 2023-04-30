package com.mars;

import com.mars.constants.DefaultDummyConfigurations;
import com.mars.service.RoverManager;
import com.mars.service.RandomRoverFactory;

public class MultipleRoversOnPlane {
  public static void main(String[] args) {

    RoverManager roverManager =
        new RoverManager(
            10, RandomRoverFactory.getInstance(), DefaultDummyConfigurations.DEFAULT_PLANE);
    for (int i = 0; i < 1000; i++) {
      System.out.println(roverManager.move(i % 5, "F,R"));
    }
  }
}
