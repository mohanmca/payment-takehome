package com.mars.service;

import com.mars.entities.Direction;
import com.mars.entities.Plain;
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

  public Rover createRover(Plain plain) {
    return createNRovers(1, plain).get(0);
  }

  public List<Rover> createNRovers(int n, Plain plain) {
    if (n > 1000) throw new IllegalArgumentException();
    RandomValuePicker r = RandomValuePicker.INSTANCE;
    List<Integer> points =
        new ArrayList<>(r.generate(n * 2, plain.getTopLeft().x(), plain.getBottomRight().x()));

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
