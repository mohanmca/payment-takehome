package com.mars.service;

import com.mars.entities.Direction;
import com.mars.entities.Rover;
import com.mars.tools.RandomValuePicker;

import java.util.ArrayList;
import java.util.List;

public class RandomRoverFactory implements RoverFactory {

  private static final RandomRoverFactory INSTANCE =
      new RandomRoverFactory(RoverFactoryImpl.getInstance());

  private final RoverFactory factory;

  private RandomRoverFactory(RoverFactory factory) {
    super();
    this.factory = factory;
  }

  public static RoverFactory getInstance() {
    return INSTANCE;
  }

  public Rover createRover() {
    return createNRovers(1).get(0);
  }

  public List<Rover> createNRovers(int n) {
    if (n > 1000) throw new IllegalArgumentException();
    RandomValuePicker r = RandomValuePicker.INSTANCE;
    List<Integer> points = new ArrayList<>(r.generate(n * 2, n * n * -2, n * n * 2));

    List<Rover> results = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Direction d = r.randomEnum(Direction.class);
      Rover rover = createRover(d.name().charAt(0), points.remove(0), points.remove(0));
      results.add(rover);
    }

    return results;
  }

  @Override
  public Rover createRover(String position) {
    return factory.createRover(position);
  }

  @Override
  public Rover createRover(char c, int x, int y) {
    return factory.createRover(c, x, y);
  }
}
