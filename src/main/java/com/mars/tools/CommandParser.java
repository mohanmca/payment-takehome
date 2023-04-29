package com.mars.tools;

import com.mars.utils.StringUtils;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/** Since this is singleton, we can encode pattern as perEJ-3. */
public enum CommandParser {
  INSTANCE;

  public Character[] parseCommands(String instructions, Set<Character> validInstructions) {
    Character[] commands = StringUtils.split(instructions);

    Optional<Character> invalidCommands =
        Arrays.stream(commands).filter(Predicate.not(validInstructions::contains)).findAny();
    if (invalidCommands.isPresent()) throw new IllegalArgumentException("Commands are not valid");
    return commands;
  }
}
