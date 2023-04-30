package com.mars.service;

import com.mars.entities.Plane;
import com.mars.primitives.Coordinate;
import com.mars.primitives.Rover;
import com.mars.utils.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RoverManager {

    final int numberOfRovers;
    final RoverFactory factory;
    final Plane plane;
    final Map<Integer, Rover> roverMap = new TreeMap<>();

    public RoverManager(int numberOfRovers, RoverFactory factory, Plane plane) {
        this.plane = plane;
        this.numberOfRovers = numberOfRovers;
        this.factory = factory;
        init();
    }

    private void init() {
        List<Rover> rovers = factory.createNRovers(numberOfRovers, plane);
        for (int i = 0; i < rovers.size(); i++) {
            roverMap.put(i, rovers.get(i));
        }
        for (Rover r : rovers) {
            if (!plane.register(r.getCoordinate())) {
                System.err.printf("Due to collision, this rover is ignored! - %s \n", r);
            }
        }
    }

    public Rover move(int id, String instructions) {
        Rover rover = roverMap.get(id);
        Character[] commands = StringUtils.split(instructions);

        Rover dummy = rover.forecast("");
        String simulationOutput = simulate(commands, dummy);
        if (simulationOutput.length() == instructions.length()) {
            moveInsidePlane(rover, instructions);
        } else if (simulationOutput.length() > 0) {
            System.err.printf(
                    "Due to collision, partial movement made! - %s - instead of %s \n",
                    simulationOutput, instructions);
            moveInsidePlane(rover, simulationOutput);
        } else {
            System.err.println("Due to collision, No movement made!");
        }

        return rover;
    }

    private String simulate(Character[] commands, Rover dummyRover) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands.length; i++) {
            dummyRover = dummyRover.forecast(commands[i] + "");
            if (plane.isOccupied(dummyRover.getCoordinate())) {
                System.err.println("***Collision detected! -" + dummyRover.id());
                break;
            } else {
                sb.append(commands[i]);
                if (i != commands.length - 1) sb.append(",");
            }
        }
        return sb.toString();
    }

    private void moveInsidePlane(Rover rover, String partialInstructions) {
        Coordinate from = rover.getCoordinate();
        rover.move(partialInstructions);
        Coordinate to = rover.getCoordinate();
        plane.migrate(from, to);
    }
}
