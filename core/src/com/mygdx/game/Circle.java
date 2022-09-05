package com.mygdx.game;

public class Circle {
    //field variables
    private double area; //area
    private double circumference; //circumference
    private double radius; //radius
    private Point location = new Point(); //location/center of circle

    /**
     * Constructor which sets the radius and sets the location to (0.0,0.0)
     * @param r radius
     */
    public Circle(double r) {
        radius = r;
        location.setPosition(0, 0);
    }

    /**
     * Modifies the radius of the circle
     * @param r radius
     */
    public void setRadius(double r) {
        radius = r;
    }

    /**
     * Provides the radius of the circle
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets location of the Circle to a new point
     * @param p Point
     */
    public void setLocation(Point p) {
        location.setPosition(p.getXValue(), p.getYValue());
    }

    /**
     * Provides the area of the circle
     * @return area
     */
    public double getArea() {
        setArea();
        return area;
    }

    /**
     * Provides the circumference of the circle
     * @return circumference
     */
    public double getCircumference() {
        setCircumference();
        return circumference;
    }

    /**
     * Calculates and sets the area of the circle
     */
    private void setArea() {
        area =  Math.PI *  Math.pow(radius, 2);

    }
    /**
     * Calculates and sets the circumference of the circle
     */
    private void setCircumference() {
        circumference = 2 *  Math.PI * radius;
    }
    /**
     * Tests if the a given point is inside of the circle, returns true if it is and false if it isn't
     * @param p Point
     * @return true/false
     */
    public boolean isPointInside(Point p) {
        LineSegment l = new LineSegment(location, p);
        return l.getLength() <= radius;
    }

    /**
     * Provide a text representation of a Circle.
     * @return text representation of a circle
     */
    @Override
    public String toString() {
        return "Area: " + area + ", Circumference " + circumference + ", Radius: " + radius + ", Center/Location: " + location.toString();
    }
}
