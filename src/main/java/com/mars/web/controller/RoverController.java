package com.mars.web.controller;

import com.mars.entities.Plane;
import com.mars.primitives.Rover;
import com.mars.service.RoverFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class RoverController {
    private final RoverFactory factory;
    private final Plane plane;
    Map<Integer, Rover> registry = new TreeMap<Integer, Rover>();

    public RoverController(RoverFactory factory, Plane plane) {
        this.factory = factory;
        this.plane = plane;
    }

    @GetMapping("/rover/create")
    Rover newRover(Character direction, Integer x, Integer y) {
        Integer id = registry.size();
        Rover newRover = factory.createRover(direction, x, y);
        registry.put(registry.size(), newRover);
        return registry.get(id);
    }

    @GetMapping("/rover/size")
    Integer size() {
        return registry.size();
    }

    @GetMapping("/rover/navigate")
    Rover navigate(Integer id, String commands) {
        Rover r = registry.get(id);
        r.move(commands);
        return r;
    }

    @GetMapping("/rover/createN")
    List<Rover> createNRovers(int n) {
        List<Rover> rovers = factory.createNRovers(n, plane);
        for (Rover r : rovers) {
            Integer id = registry.size();
            registry.put(registry.size(), r);
        }
        return rovers;
    }

    @GetMapping("/rover/list")
    Collection<Rover> listAll() {
        return registry.values();
    }
}
