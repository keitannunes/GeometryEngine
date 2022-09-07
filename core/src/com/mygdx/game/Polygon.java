package com.mygdx.game;

public abstract class Polygon {
    protected Point[] vertices;
    protected LineSegment[] sides;
    protected double perimeter;
    protected double area;

    /**
     * Returns the sides
     * @return Array of sides
     */
    public LineSegment[] getSides() {
        return sides;
    }

    /**
     * Returns the vertices
     * @return Array of vertices
     */
    public Point[] getVertices(){
        return vertices;
    }

    /**
     * returns the perimeter of the triangle
     *
     * @return perimeter
     */
    public double getPerimeter() {
        if (perimeter == 0) { //hasn't been calculated yet
            for (LineSegment side: sides) {
                perimeter += side.getLength();
            }
        }
        return perimeter;
    }

    public abstract double getArea();


}
