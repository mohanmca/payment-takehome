package com.mars.service;

import com.mars.entities.Plane;
import com.mars.primitives.Coordinate;
import com.mars.primitives.Rover;
import com.mars.utils.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RoverManager {


    final RoverFactory factory;
    final Plane plane;
    final Map<Long, Rover> roverMap = new TreeMap<>();

    public RoverManager(int numberOfRovers, RoverFactory factory, Plane plane) {
        this.factory = factory;
        List<Rover> rovers = factory.createNRovers(numberOfRovers, plane);
        this.plane = plane;
        rovers.forEach(this::addRover);
    }

    public RoverManager(Collection<Rover> rovers, Plane plane) {
        this.factory = null;
        this.plane = plane;
        rovers.forEach(this::addRover);
    }

    public boolean addRover(Rover rover) {
        // check if it is already registered
        if (roverMap.containsKey(rover.id())) return true;
        // if collision fail to add
        if (!plane.register(rover.getCoordinate(), rover)) {
            System.err.printf("Due to collision, this rover is ignored! - %s \n", rover);
            return false;
        }

        roverMap.put(rover.id(), rover);
        return true;
    }

    public Rover move(Long id, String instructions) {
        Rover rover = roverMap.get(id);
        Character[] commands = StringUtils.split(instructions);

        String simulationOutput = simulate(commands, rover);
        if (simulationOutput.length() == instructions.length()) {
            moveInsidePlane(rover, instructions);
        } else if (simulationOutput.length() > 0) {
            System.err.printf(
                    "Due to collision, partial movement made! - %s - instead of %s",
                    simulationOutput, instructions);
            moveInsidePlane(rover, simulationOutput);
        } else {
            System.err.printf("Due to collision, No movement made! - %s", rover);
        }

        return rover;
    }

    private String simulate(Character[] commands, Rover dummyRover) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands.length; i++) {
            dummyRover = dummyRover.forecast(commands[i] + "");
            if (plane.isOccupied(dummyRover.getCoordinate(), dummyRover)) {
                System.out.printf("***Collision detected*** - { 'RoverId' :  %d, 'Instruction#':  %d } ", dummyRover.id(), i);
                break;
            } else {
                sb.append(commands[i]);
                if (i != commands.length - 1) sb.append(",");
            }
        }
        return sb.toString();
    }

    private Coordinate moveInsidePlane(Rover rover, String partialInstructions) {
        Coordinate from = rover.getCoordinate();
        rover.move(partialInstructions);
        Coordinate to = rover.getCoordinate();
        plane.migrate(from, to);
        return to;
    }
}
