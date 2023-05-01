package com.mars.entities;

import com.mars.primitives.Coordinate;
import com.mars.primitives.Rover;

import java.util.TreeMap;

public class Plane {

    private final Coordinate topLeft, bottomRight;
    TreeMap<Coordinate, Rover> objects = new TreeMap<>();

    public Plane(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public boolean register(Coordinate coordinate, Rover object) {
        if (isInside(coordinate) && !isOccupied(coordinate, object)) {
            objects.put(coordinate, object);
            return true;
        }
        return false;
    }

    public boolean isAvailable(Coordinate coordinate) {
        return !objects.containsKey(coordinate);
    }

    public Object get(Coordinate coordinate) {
        return objects.get(coordinate);
    }

    public boolean isOccupied(Coordinate coordinate, Object object) {
        if (isOutside(coordinate)) return true;
        if (isAvailable(coordinate)) return false;
        return objects.containsKey(coordinate) && !objects.get(coordinate).equals(object);
    }

    public void migrate(Coordinate from, Coordinate to) {
        Rover old = objects.remove(from);
        objects.put(to, old);
    }

    private boolean isInside(Coordinate coordinate) {
        return !isOutside(coordinate);
    }

    private boolean isOutside(Coordinate coordinate) {
        if (coordinate.x() < topLeft.x() || coordinate.x() > bottomRight.x()) return false;
        return (coordinate.y() > topLeft.y() || coordinate.y() < bottomRight.y());
    }

    public Coordinate getTopLeft() {
        return topLeft;
    }

    public Coordinate getBottomRight() {
        return bottomRight;
    }
}
