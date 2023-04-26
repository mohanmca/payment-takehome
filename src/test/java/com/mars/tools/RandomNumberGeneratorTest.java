package com.mars.tools;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberGeneratorTest {
  RandomValuePicker r = RandomValuePicker.INSTANCE;

  @Test
  public void randomEnumChoice() {
    Class<RandomValuePicker> clazz = RandomValuePicker.class;
    RandomValuePicker randomEnum = r.randomEnum(clazz);
    assertEquals(r, randomEnum);

    Class<Thread.State> threadStateEnum = Thread.State.class;
    Thread.State randomState = r.randomEnum(threadStateEnum);
    List<Thread.State> threadStates = Arrays.asList(Thread.State.values());
    assertTrue(threadStates.contains(randomState), "Random picking of one of the threadState");
  }

  @Test
  public void randomUniqueNumberPicker() {
    Set<Integer> numbers = r.generate(2, -100, 100);
    assertEquals(numbers.size(), 2, "Picking unique numbers");
  }
}
