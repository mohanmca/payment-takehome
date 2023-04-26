package com.mars.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandParserTest {
  CommandParser parser = CommandParser.INSTANCE;

  @Test
  public void testCreation() {
    Character[] commands = parser.parseCommands("F,B", Set.of('F', 'B'));
    Assertions.assertEquals(commands.length, 2);
  }

  @Test
  public void testInvalidCommand() {

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> parser.parseCommands("F,B,E", Set.of('F', 'B')),
            "Invalid argument thrown for invalid command");
    assertTrue(thrown.getMessage().contentEquals("Commands are not valid"));
  }
}
