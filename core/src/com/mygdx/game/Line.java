package com.mygdx.game;

/**
 * Line class
 */
public class Line {

    private Point point = new Point(); //start point
    private double slope; //slope
    private Point yIntercept = new Point(); //y intercept point

    /**
     * Constructor for 2 given points
     *
     * @param p1 point 1
     * @param p2 point 2
     */
    public Line(Point p1, Point p2) {
        point = p1;
        double x1 = p1.getXValue();
        double x2 = p2.getXValue();
        double y1 = p1.getYValue();
        double y2 = p2.getYValue();
        slope = (y2 - y1) / (x2 - x1);
        yIntercept = new Point(0, p1.getYValue() - slope * p1.getXValue());
    }

    /**
     * Constructor for a point and slope
     *
     * @param p     Point
     * @param slope Slope
     */
    public Line(Point p, double slope) {
        point = p;
        this.slope = slope;
        yIntercept = new Point(0, p.getYValue() - slope * p.getXValue());
    }

    public Line(LineSegment lineSeg) {
        point = lineSeg.getStart();
        double x1 = lineSeg.getStart().getXValue();
        double x2 = lineSeg.getEnd().getXValue();
        double y1 = lineSeg.getStart().getYValue();
        double y2 = lineSeg.getEnd().getYValue();
        slope = (y2 - y1) / (x2 - x1);
        yIntercept = new Point(0, point.getYValue() - slope * point.getXValue());
    }

    /**
     * Provides the slope of the line
     *
     * @return slope
     */
    public double getSlope() {
        return slope;
    }

    /**
     * Check if a line segment is parallel to this line
     *
     * @param lineSegment
     * @return boolean
     */
    public boolean isParallel(LineSegment lineSegment) {
        return this.slope == lineSegment.getSlope();
    }

    /**
     * Checks if a line is parallel to this line
     *
     * @param line
     * @return
     */
    public boolean isParallel(Line line) {
        return this.slope == line.getSlope();
    }

    public Point getPoint() {
        return point;
    }

    /**
     * returns the y-intercept of the real line collinear to this line segment
     *
     * @return yIntercept
     */
    public Point getYIntercept() {
        return yIntercept;
    }

    /**
     * Calculates and returns the shortest line between the line and a point
     * @param point Point
     * @return Shortest line
     */
    public LineSegment shortestLineFromPoint(Point point) {
        if (this.includes(point)) {
            System.out.println("Point lies on line");
            return null;
        }
        Point p1 = Point.intersect(new Line(point, -1 / slope), this); //point where perpendicular line meets this line
        return new LineSegment(p1,point);
    }

    /**
     * Checks if point is on this line
     * @param point Point
     * @return Boolean
     */
    public boolean includes(Point point) {
        //check if parameter point is equal to the point on the line
        Point pointAtX = new Point(point.getXValue(), point.getXValue()*this.getSlope()+this.getYIntercept().getYValue());
        return pointAtX.equals(point);
    }

}

