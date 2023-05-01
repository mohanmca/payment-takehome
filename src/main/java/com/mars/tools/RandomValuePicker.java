package com.mars.tools;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public enum RandomValuePicker {
    INSTANCE;

    private final Random random = new Random();

    public <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    /**
     * This generates n unique random numbers
     *
     * @param n
     * @param min - inclusive
     * @param max - exclusive
     * @return
     */
    public Set<Integer> generate(int n, int min, int max) {
        if (max - min <= 2 * n)
            throw new IllegalArgumentException("There should be buffer numbers to generate random");
        return new Random().ints(min, max).distinct().limit(n).boxed().collect(Collectors.toSet());
    }
}
