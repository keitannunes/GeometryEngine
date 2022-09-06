package com.mygdx.game;

public class LineSegment {

    private Point start = new Point(); //start point
    private Point end = new Point(); //end point
    private double slope; //slope
    private double length; //length
    private Point yIntercept = new Point(); //y intercept point

    /**
     * Constructor to set the start and end position of the line
     * @param p1 point 1
     * @param p2 point 2
     */
    public LineSegment(Point p1, Point p2) {
        start = p1;
        end = p2;
        setLength();
        setSlope();
        setYIntercept();
    }
    /**
     * Provides the length of the line
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * Provides the mid-point of a line
     * @return midpoint
     */
    public Point getMidPoint() {
        Point midpoint = new Point((start.getXValue() + end.getXValue()) / 2, (start.getYValue() + end.getYValue()) / 2);
        return midpoint;
    }

    /**
     * Provides the slope of the line
     * @return slope
     */
    public double getSlope() {
        return slope;
    }

    /**
     * Check if a line is parallel to another line
     * @param lineSegment
     * @return boolean
     */
    public boolean isParallel(LineSegment lineSegment) {
        return this.slope == lineSegment.getSlope();
    }

    /**
     * Checks if a line is parralel to another line
     * @param otherLine Other Line
     * @return boolean
     */
    public boolean isParallel(Line otherLine) {
        return this.slope == otherLine.getSlope();
    }

    /**
     * Calculates the length of the line
     */
    private void setLength() {
        length = Math.sqrt(Math.pow(end.getXValue() - start.getXValue(), 2) + Math.pow(end.getYValue() - start.getYValue(), 2));
    }
    /**
     * Calculates the slope of the line
     */
    private void setSlope() {
        slope = (end.getYValue() - start.getYValue()) / (end.getXValue() - start.getXValue());
    }
    /**
     * sets the y-intercept of the line collinear with this line segment
     */
    private void setYIntercept() {
        yIntercept.setPosition(0, start.getYValue() - slope * start.getXValue());
    }
    /**
     * Provide a text representation of a Line
     * @return text representation of a line
     */
    @Override
    public java.lang.String toString() {
        return "Line " + start.toString() + " to " + end.toString() + " length: " + Math.round(length * 10)/10 + " slope: " + Math.round(slope * 10)/10;
    }
    /**
     * returns the starting point of the line segment
     * @return starting point
     */
    public Point getStart() {
        return start;
    }
    /**
     * returns the ending point of the line segment
     * @return ending point
     */
    public Point getEnd() {
        return end;
    }

    /**
     * returns the y-intercept of the real line collinear to this line segment
     * @return yIntercept
     */
    public Point getYIntercept() {
        return yIntercept;
    }
    /**
     * returns the point of intersection between this line segment and another line
     * @param otherLine Other Line
     * @return point of intersection
     */
    public Point pointOfIntersection(Line otherLine) {
        if (this.isParallel(otherLine) && this.getYIntercept().getYValue() == otherLine.getYIntercept().getYValue()) {
            throw new RuntimeException("Lines are collinear");
        } else if (this.isParallel(otherLine)) {
            throw new RuntimeException("Lines are parallel");
        } else {
            double p1X = start.getXValue();
            double p1Y = start.getYValue();
            double p2X = end.getXValue();
            double p2Y = end.getYValue();

            double p3X = otherLine.getPoint().getXValue();
            double p3Y = otherLine.getPoint().getYValue();
            double p4X = otherLine.getPoint().getXValue() + 1;
            double p4Y = otherLine.getSlope() * (otherLine.getPoint().getXValue() + 1) + otherLine.getYIntercept().getYValue(); //y=mx+b

            //I found this equation on Google
            double v = (p1X - p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X - p4X); //intelliJ very cool
            Point POI = new Point(((p1X * p2Y - p1Y * p2X) * (p3X - p4X) - (p1X - p2X) * (p3X * p4Y - p3Y * p4X)) / v, ((p1X * p2Y - p1Y * p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X * p4Y - p3Y * p4X)) / v);

            if (POI.liesOnLine(this)) {
                return POI;
            } else {
                throw new RuntimeException("Lines do not intersect");
            }
        }
    }

    /**
     * returns the point of intersection between this line segment and another line segment
     * @param otherLine Other lines
     * @return point of intersection
     */
    public Point pointOfIntersection(LineSegment otherLine) {
        if (this.isParallel(otherLine) && this.getYIntercept().getYValue() == otherLine.getYIntercept().getYValue()) {
            throw new RuntimeException("Lines are collinear");
        } else if (this.isParallel(otherLine)) {
            throw new RuntimeException("Lines are parallel");
        } else {
            double p1X = start.getXValue();
            double p1Y = start.getYValue();
            double p2X = end.getXValue();
            double p2Y = end.getYValue();

            double p3X = otherLine.getStart().getXValue();
            double p3Y = otherLine.getStart().getYValue();
            double p4X = otherLine.getEnd().getXValue();
            double p4Y = otherLine.getEnd().getYValue();

            //I found this equation on Google
            double v = (p1X - p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X - p4X); //intelliJ very cool
            Point POI = new Point(((p1X * p2Y - p1Y * p2X) * (p3X - p4X) - (p1X - p2X) * (p3X * p4Y - p3Y * p4X)) / v, ((p1X * p2Y - p1Y * p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X * p4Y - p3Y * p4X)) / v);

            if (POI.liesOnLine(this) && POI.liesOnLine(otherLine)) {
                return POI;
            } else {
                throw new RuntimeException("Lines do not intersect");
            }
        }
    }

    /**
     * returns the shortest distance between any point and the real line collinear with this line segment
     * @param p
     * @return shortest distance from point
     */
    public double shortestDistanceFromPoint(Point p) {
        return Math.abs((start.getYValue() - end.getYValue()) * p.getXValue() + (end.getXValue() - start.getXValue()) * p.getYValue() + (start.getXValue() - end.getXValue()) * start.getYValue() + (end.getYValue() - start.getYValue()) * start.getXValue()) / Math.sqrt(Math.pow((start.getYValue() - end.getYValue()), 2) + Math.pow((end.getXValue() - start.getXValue()), 2));
    }

    /**
     * Calculates and returns the shortest line between the line and a point
     * @param p Point
     * @return Shortest line
     */
    public LineSegment shortestLineFromPoint(Point p) { //TRY/CATCH
        Point p1;
        if (p.liesOnLine(this)) {
            throw new RuntimeException("Point lies on line");
        }
        try {
             p1 = new Line(p, -1 / slope).pointOfIntersection(this); //point where perpendicular line meets this line
        } catch(RuntimeException err) {
            if (p.distanceFrom(start) < p.distanceFrom(end)) {
                p1 = start;
            } else {
                p1 = end;
            }
        }
        return new LineSegment(p1,p);
    }


}
