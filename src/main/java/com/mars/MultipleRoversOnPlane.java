package com.mars;

import com.mars.constants.DefaultDummyConfigurations;
import com.mars.primitives.Rover;
import com.mars.service.RandomRoverFactory;
import com.mars.service.RoverManager;
import com.mars.tools.RandomValuePicker;

import java.util.List;

public class MultipleRoversOnPlane {
    static char[] instructions = new char[]{'F', 'R', 'L', 'B'};

    public static void main(String[] args) {

        int numberOfRovers = 5;
        List<Rover> rovers = RandomRoverFactory.getInstance().createNRovers(numberOfRovers, DefaultDummyConfigurations.DEFAULT_PLANE);

        RoverManager roverManager =
                new RoverManager(rovers, DefaultDummyConfigurations.DEFAULT_PLANE);

        for (int i = 0; i < 100; i++) {
            Rover rover = rovers.get(i % numberOfRovers);
            String randomInstructions = getRandomInstructions();
            System.out.printf("%d - %s: applied on to : %s --> ", i, randomInstructions, rover);
            System.out.println(roverManager.move(rover.id(), randomInstructions));
            if (i % 5 == 0) System.out.println("...");
        }
    }

    private static String getRandomInstructions() {
        StringBuilder sb = new StringBuilder();
        for (Integer j : RandomValuePicker.INSTANCE.generate(4, 0, 100)) {
            sb.append(instructions[j % instructions.length]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
