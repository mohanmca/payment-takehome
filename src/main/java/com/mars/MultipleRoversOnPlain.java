package com.mars;

import com.mars.constants.DefaultDummyConfigurations;
import com.mars.entities.Plain;
import com.mars.entities.TrafficController;
import com.mars.service.RandomRoverFactory;

import static com.mars.constants.DefaultDummyConfigurations.BOTTOM_RIGHT;
import static com.mars.constants.DefaultDummyConfigurations.TOP_LEFT;

public class MultipleRoversOnPlain {
  public static void main(String[] args) {

    TrafficController controller =
        new TrafficController(5, RandomRoverFactory.getInstance(), DefaultDummyConfigurations.DEFAULT_PLAIN);
    for (int i = 0; i < 1000; i++) {
      System.out.println(controller.move(i % 5, "F,R"));
    }
  }
}
