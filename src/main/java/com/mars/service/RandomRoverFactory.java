package com.mars.service;

import com.mars.primitives.Direction;
import com.mars.entities.Plane;
import com.mars.primitives.Rover;
import com.mars.tools.RandomValuePicker;

import java.util.ArrayList;
import java.util.List;

public class RandomRoverFactory implements RoverFactory {

  private static final RandomRoverFactory INSTANCE =
      new RandomRoverFactory(NavigableRoverFactory.getInstance());

  private final RoverFactory factory;

  private RandomRoverFactory(RoverFactory factory) {
    super();
    this.factory = factory;
  }

  public static RoverFactory getInstance() {
    return INSTANCE;
  }

  public Rover createRover(Plane plane) {
    return createNRovers(1, plane).get(0);
  }

  public List<Rover> createNRovers(int n, Plane plane) {
    if (n > 1000) throw new IllegalArgumentException();
    RandomValuePicker r = RandomValuePicker.INSTANCE;
    List<Integer> points =
        new ArrayList<>(r.generate(n * 2, plane.getTopLeft().x(), plane.getBottomRight().x()));

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
