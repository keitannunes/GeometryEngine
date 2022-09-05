package com.mygdx.game;

public class Circle {
    //field variables
    private double area; //area
    private double circumference; //circumference
    private double radius; //radius
    private Point center = new Point(); //location/center of circle

    /**
     * Constructor which sets the radius and sets the center to origin
     * @param radius Radius
     */
    public Circle(double radius) {
        this.radius = radius;
        center.setPosition(0, 0);
    }

    /**
     * Constructor which sets the radius and center
     * @param point Centre
     * @param radius Radius
     */
    public Circle(Point point, double radius) {
        center.setPosition(point.getXValue(), point.getYValue());
        this.radius = radius;
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
     * Sets center of the Circle to a new point
     * @param point Point
     */
    public void setCenter(Point point) {
        center = point;
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
     * Returns center point
     * @return center point
     */
    public Point getCenter() {
        return center;
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
     * Tests if the given point is inside the circle, returns true if it is and false if it isn't
     * @param p Point
     * @return true/false
     */
    public boolean isPointInside(Point p) {
        LineSegment l = new LineSegment(center, p);
        return l.getLength() <= radius;
    }

    /**
     * Provide a text representation of a Circle.
     * @return text representation of a circle
     */
    @Override
    public String toString() {
        return "Area: " + area + ", Circumference " + circumference + ", Radius: " + radius + ", Center/Location: " + center.toString();
    }
}
