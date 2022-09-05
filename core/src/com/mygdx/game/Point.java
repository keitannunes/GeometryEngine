package com.mygdx.game;

public class Point {

    private double x; //x coordinate
    private double y; //y coordinate

    /**
     * Constructor if there are 2 arguments upon instantiation.
     *
     * @param x x point 
     * @param y y point 
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor if the objects contains no arguments upon instantiation, sets the point to (0.0,0.0)
     */
    public Point() {
        x = 0;
        y = 0;
    }
    /**
     * Changes the position of the point to the users desired position
     * @param x coordinate
     * @param y coordinate
     */
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Returns the y value of the point
     * @return x 
     */
    public double getXValue() {
        return this.x;
    }
    /**
     * getter for Y value
     * @return y 
     */
    public double getYValue() {
        return this.y;
    }
    /**
     * Calculates and returns the distance from the origin that the point is
     * @return distance 
     */
    public double distanceFromOrigin() {
        return  Math.sqrt(Math.pow(0 - x, 2) + Math.pow(0 - y, 2));
    }
    /**
     * Calculates and returns the distance that the point is from another point
     * @param p point object
     * @return distance 
     */
    public double distanceFrom(Point p) {
        return  Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
    /**
     * overridden .toString method that returns both coordinates
     * @return (x,y) (string)
     */
    @Override
    public java.lang.String toString() {
        return "(" + Math.round(x * 100)/100 + "," + Math.round(y * 100)/100 + ")";
    }

    /**
     * Returns true if 2 points are equal, false if otherwise
     * @param o Point Object
     * @return True if 2 points are equal, false if otherwise
     */
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (this == null) {
            return false;
        }

        if (o instanceof Point) {
            Point p = (Point) o;
            return this.x == p.x || this.y == p.y;
        }
        return false;
    }

}
