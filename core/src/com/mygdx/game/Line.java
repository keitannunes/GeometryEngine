package com.mygdx.game;

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
        yIntercept.setPosition(0, p1.getYValue() - slope * p1.getXValue());
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
        yIntercept.setPosition(0, p.getYValue() - slope * p.getXValue());
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
     * @return true/false
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
     * Calculates and returns the POI of 2 lines
     *
     * @param otherLine Other line
     * @return Point of Intersection
     */
    public Point pointOfIntersection(Line otherLine) {//MAKE SURE TO TRY/CATCH when using this method
        if (this.isParallel(otherLine) && this.getYIntercept().getYValue() == otherLine.getYIntercept().getYValue()) {
            throw new RuntimeException("Lines are collinear");
        } else if (this.isParallel(otherLine)) {
            throw new RuntimeException("Lines are parallel");
        } else {
            double p1X = point.getXValue();
            double p1Y = point.getYValue();
            double p2X = point.getXValue() + 1;
            double p2Y = slope * (point.getXValue() + 1) + yIntercept.getYValue(); //y=mx+b

            double p3X = otherLine.getPoint().getXValue();
            double p3Y = otherLine.getPoint().getYValue();
            double p4X = otherLine.getPoint().getXValue() + 1;
            double p4Y = otherLine.getSlope() * (otherLine.getPoint().getXValue() + 1) + otherLine.yIntercept.getYValue(); //y=mx+b

            //I found this equation on Google
            double v = (p1X - p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X - p4X); //intelliJ very cool
            return new Point(((p1X * p2Y - p1Y * p2X) * (p3X - p4X) - (p1X - p2X) * (p3X * p4Y - p3Y * p4X)) / v, ((p1X * p2Y - p1Y * p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X * p4Y - p3Y * p4X)) / v);

        }
    }

    /**
     * Checks Calculates and returns the POI of a line & line segment
     * @param otherLine Line Segment
     * @return Point of Intersection
     */
    public Point pointOfIntersection(LineSegment otherLine) {
        if (this.isParallel(otherLine) && this.getYIntercept().getYValue() == otherLine.getYIntercept().getYValue()) {
            throw new RuntimeException("Lines are collinear");
        } else if (this.isParallel(otherLine)) {
            throw new RuntimeException("Lines are parallel");
        } else {
            double p1X = point.getXValue();
            double p1Y = point.getYValue();
            double p2X = point.getXValue() + 1;
            double p2Y = slope * (point.getXValue() + 1) + yIntercept.getYValue(); //y=mx+b

            double p3X = otherLine.getStart().getXValue();
            double p3Y = otherLine.getStart().getYValue();
            double p4X = otherLine.getEnd().getXValue();
            double p4Y = otherLine.getEnd().getYValue();

            //I found this equation on Google
            double v = (p1X - p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X - p4X); //intelliJ very cool
            Point POI = new Point(((p1X * p2Y - p1Y * p2X) * (p3X - p4X) - (p1X - p2X) * (p3X * p4Y - p3Y * p4X)) / v, ((p1X * p2Y - p1Y * p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X * p4Y - p3Y * p4X)) / v);

            if (POI.liesOnLine(otherLine)) {
                return POI;
            } else {
                throw new RuntimeException("Lines do not intersect");
            }
        }
    }


}

