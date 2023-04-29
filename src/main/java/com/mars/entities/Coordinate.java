package com.mars.entities;

public record Coordinate(int x, int y)  implements Comparable<Coordinate> {
    public static final  Coordinate ORIGIN = new Coordinate(0,0);
    public Coordinate add(int deltaX, int deltaY) {
        return new Coordinate(this.x+deltaX, this.y+deltaY);
    }

    @Override
    public int compareTo(Coordinate o) {
        int dx = this.x - o.x;
        int dy = this.y - o.y;
        if(dx!=0) return  dx;
        return dy;
    }
}
