package com.mars.utils;

import java.util.Arrays;

public class StringUtils {
    public static Character[] split(String instructions) {
        return Arrays.stream(instructions.toUpperCase().split(","))
                .map(s -> s.charAt(0))
                .toArray(Character[]::new);
    }
}
