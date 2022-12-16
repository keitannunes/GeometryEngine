package shapes;

public class Circle extends Shape {
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
        center = new Point(0, 0);
    }

    /**
     * Constructor which sets the radius and center
     * @param center Center
     * @param radius Radius
     */
    public Circle(Point center, double radius) {
        this.center = new Point(center.getXValue(), center.getYValue());
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
     * Provides the area of the circle
     * @return area
     */
    public double getArea() {
        if (area == 0 ) {
            area =  Math.PI *  Math.pow(radius, 2);
        }
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
        if (circumference == 0) {
            circumference = 2 *  Math.PI * radius;
        }
        return circumference;
    }
    /**
     * Tests if the given point is inside the circle, returns true if it is and false if it isn't
     * @param p Point
     * @return true/false
     */
    public boolean includes(Point p) {
        LineSegment l = new LineSegment(center, p);
        return l.getLength() <= radius;
    }

    @Override
    public PrimitiveCircle[] GetPrimitiveCircles() {
        return new PrimitiveCircle[] {new PrimitiveCircle(center.getXValue(),center.getYValue(),radius)};
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
