package com.mars.entities;

import com.mars.primitives.Coordinate;

import java.util.TreeMap;

public class Plane {

    private final Coordinate topLeft, bottomRight;
    TreeMap<Coordinate, Object> objects = new TreeMap<>();

    public Plane(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public boolean register(Coordinate coordinate, Object object) {
        if (isInside(coordinate) && !isOccupied(coordinate, object)) {
            objects.put(coordinate, object);
            return true;
        }
        return false;
    }

    public boolean isAvailable(Coordinate coordinate) {
        return !objects.containsKey(coordinate);
    }

    public boolean isOccupied(Coordinate coordinate, Object object) {
        if (isOutside(coordinate)) return true;
        if (isAvailable(coordinate)) return false;
        return objects.containsKey(coordinate) && !objects.get(coordinate).equals(object);
    }

    public void migrate(Coordinate from, Coordinate to) {
        objects.remove(from);
        objects.put(to, to);
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
