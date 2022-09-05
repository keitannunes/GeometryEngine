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
     * Checks if point lies on a line segment
     * @param line Line Segment
     * @return If point lies on the line segment
     */
    public boolean liesOnLine(LineSegment line) {
        //check if: S---P-----E using distance between points
        LineSegment SP = new LineSegment(line.getStart(), this);
        LineSegment PE = new LineSegment(this, line.getEnd());

        //check if SE = SP + P (floating point comparison)
        return Math.abs(SP.getLength() + PE.getLength() - line.getLength()) <= 0.000001;
    }

    /**
     * Checks if point lies on a line
     * @param line Line
     * @return If point lies on the line
     */
    public boolean liesOnLine(Line line) {
        Point pointAtX = new Point(this.getXValue(), this.getXValue()*line.getSlope()+line.getYIntercept().getYValue());
        return pointAtX.equals(this);
    }
    /**
     * overridden .toString method that returns both coordinates
     * @return (x,y) as a string
     */
    @Override
    public java.lang.String toString() {
        return "(" + Math.round(x * 100)/100 + "," + Math.round(y * 100)/100 + ")";
    }

    /**
     * Returns if 2 points are equal
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
            double xDiff = this.x - p.x;
            double yDiff = this.y - p.y;
            return Math.abs(xDiff) <= 0.000001 && Math.abs(yDiff) <= 0.000001;
        }
        return false;
    }

}
