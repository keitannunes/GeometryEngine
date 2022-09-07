package com.mygdx.game;

public class Point {

    private double x; //x coordinate
    private double y; //y coordinate
    public static Point origin = new Point(0,0);

    //move POI to here...

    /**
     * Calculates and returns the POI of 2 lines
     * @param line1 Line 1
     * @param line2 Line 2
     * @return POI
     */
    public static Point intersect(Line line1, Line line2) {
        if (line1.isParallel(line2) && line1.getYIntercept().getYValue() == line2.getYIntercept().getYValue()) {
            throw new RuntimeException("Lines are collinear");
        } else if (line1.isParallel(line2)) {
            throw new RuntimeException("Lines are parallel");
        } else {
            double p1X = line1.getPoint().getXValue();
            double p1Y = line1.getPoint().getYValue();
            double p2X = line1.getPoint().getXValue() + 1;
            double p2Y = line1.getSlope() * (line1.getPoint().getXValue() + 1) + line1.getYIntercept().getYValue(); //y=mx+b

            double p3X = line2.getPoint().getXValue();
            double p3Y = line2.getPoint().getYValue();
            double p4X = line2.getPoint().getXValue() + 1;
            double p4Y = line2.getSlope() * (line2.getPoint().getXValue() + 1) + line2.getYIntercept().getYValue(); //y=mx+b

            //I found this equation on Google
            double v = (p1X - p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X - p4X); //intelliJ very cool
            return new Point(((p1X * p2Y - p1Y * p2X) * (p3X - p4X) - (p1X - p2X) * (p3X * p4Y - p3Y * p4X)) / v, ((p1X * p2Y - p1Y * p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X * p4Y - p3Y * p4X)) / v);

        }
    }

    /**
     * Calculates and returns the POI of a line seg and a line
     * @param line Line
     * @param lineSeg Line Segment
     * @return POI
     */
    public static Point intersect(Line line, LineSegment lineSeg) {
        if (line.isParallel(lineSeg) && line.getYIntercept().getYValue() == lineSeg.getYIntercept().getYValue()) {
            throw new RuntimeException("Lines are collinear");
        } else if (line.isParallel(lineSeg)) {
            throw new RuntimeException("Lines are parallel");
        } else {
            double p1X = line.getPoint().getXValue();
            double p1Y = line.getPoint().getYValue();
            double p2X = line.getPoint().getXValue() + 1;
            double p2Y = line.getSlope() * (line.getPoint().getXValue() + 1) + line.getYIntercept().getYValue(); //y=mx+b

            double p3X = lineSeg.getStart().getXValue();
            double p3Y = lineSeg.getStart().getYValue();
            double p4X = lineSeg.getEnd().getXValue();
            double p4Y = lineSeg.getEnd().getYValue();

            //I found this equation on Google
            double v = (p1X - p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X - p4X); //intelliJ very cool
            Point POI = new Point(((p1X * p2Y - p1Y * p2X) * (p3X - p4X) - (p1X - p2X) * (p3X * p4Y - p3Y * p4X)) / v, ((p1X * p2Y - p1Y * p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X * p4Y - p3Y * p4X)) / v);

            if (POI.liesOnLine(lineSeg)) {
                return POI;
            } else {
                throw new RuntimeException("Lines do not intersect");
            }

        }
    }

    /**
     * Calculates and returns the POI of two line segments
     * @param lineSeg1 Line Segment 1
     * @param lineSeg2 Line Segment 2
     * @return POI
     */
    public static Point intersect(LineSegment lineSeg1, LineSegment lineSeg2) {
        if (lineSeg1.isParallel(lineSeg2) && lineSeg1.getYIntercept().getYValue() == lineSeg2.getYIntercept().getYValue()) {
            throw new RuntimeException("Lines are collinear");
        } else if (lineSeg1.isParallel(lineSeg2)) {
            throw new RuntimeException("Lines are parallel");
        } else {
            double p1X = lineSeg1.getStart().getXValue();
            double p1Y = lineSeg1.getStart().getYValue();
            double p2X = lineSeg1.getEnd().getXValue();
            double p2Y = lineSeg1.getEnd().getYValue();

            double p3X = lineSeg2.getStart().getXValue();
            double p3Y = lineSeg2.getStart().getYValue();
            double p4X = lineSeg2.getEnd().getXValue();
            double p4Y = lineSeg2.getEnd().getYValue();

            //I found this equation on Google
            double v = (p1X - p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X - p4X); //intelliJ very cool
            Point POI = new Point(((p1X * p2Y - p1Y * p2X) * (p3X - p4X) - (p1X - p2X) * (p3X * p4Y - p3Y * p4X)) / v, ((p1X * p2Y - p1Y * p2X) * (p3Y - p4Y) - (p1Y - p2Y) * (p3X * p4Y - p3Y * p4X)) / v);

            if (POI.liesOnLine(lineSeg1) && POI.liesOnLine(lineSeg2)) {
                return POI;
            } else {
                throw new RuntimeException("Lines do not intersect");
            }
        }
    }


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
