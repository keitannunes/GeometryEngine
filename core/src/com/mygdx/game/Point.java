package com.mygdx.game;

import java.util.ArrayList;

public class Point {

    private double x; //x coordinate
    private double y; //y coordinate
    public static Point origin = new Point(0, 0);

    //move POI to here...

    /**
     * Calculates and returns the POI of 2 lines
     *
     * @param line1 Line 1
     * @param line2 Line 2
     * @return POI
     */
    public static Point intersect(Line line1, Line line2) {
        if (line1.isParallel(line2) && line1.getYIntercept().getYValue() == line2.getYIntercept().getYValue()) {
            System.out.println("Lines are collinear");
            return null;
        } else if (line1.isParallel(line2)) {
            System.out.println("Lines are parallel");
            return null;
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
     *
     * @param line    Line
     * @param lineSeg Line Segment
     * @return POI
     */
    public static Point intersect(Line line, LineSegment lineSeg) {
        //create line w/ LineSeg
        Line line2 = new Line(lineSeg);
        //find POI of the 2 lines
        Point POI = Point.intersect(line, line2);

        //check if POI is on lineSeg
        if (lineSeg.includes(POI)) {
            return POI;
        } else {
            return null;
        }
    }

    /**
     * Calculates and returns the POI of two line segments
     *
     * @param lineSeg1 Line Segment 1
     * @param lineSeg2 Line Segment 2
     * @return POI
     */
    public static Point intersect(LineSegment lineSeg1, LineSegment lineSeg2) {
        //create line w/ LineSegs
        Line line1 = new Line(lineSeg1);
        Line line2 = new Line(lineSeg2);
        //find POI of the 2 lines
        Point POI = Point.intersect(line1, line2);

        if (lineSeg1.includes(POI) && lineSeg2.includes(POI)) {
            return POI;
        } else {
            System.out.println("Lines do not intersect");
            return null;
        }
    }


    /**
     * Calculates and returns the POI(s) of a polygon and a line
     *
     * @param polygon Polygon
     * @param line    Line
     */
    public static ArrayList<Point> intersect(Polygon polygon, Line line) {
        ArrayList<Point> intersections = new ArrayList<>();
        for (LineSegment side : polygon.getSides()) {
            if (Point.intersect(line, side) != null) {
                intersections.add(Point.intersect(line, side));
            }
        }
        return intersections;
    }

    /**
     * Calculates and returns the POI(s) of a polygon and a line
     *
     * @param polygon Polygon
     * @param lineSeg Line Segment
     * @return POI(s)
     */
    public static ArrayList<Point> intersect(Polygon polygon, LineSegment lineSeg) {
        ArrayList<Point> intersections = new ArrayList<>();
        for (LineSegment side : polygon.getSides()) {
            if (Point.intersect(lineSeg, side) != null) {
                intersections.add(intersect(lineSeg, side));
            }
        }
        return intersections;
    }

    /**
     * Calculates and returns the POI(s) of 2 polygons
     *
     * @param polygon1 Polygon 1
     * @param polygon2 Polygon 2
     * @return POI(s)
     */
    public static ArrayList<Point> intersect(Polygon polygon1, Polygon polygon2) {
        ArrayList<Point> intersections = new ArrayList<>();
        for (LineSegment side1 : polygon1.getSides()) {
            for (LineSegment side2 : polygon2.getSides()) {
                if (Point.intersect(side1, side2) != null) {
                    intersections.add(intersect(side1, side2));
                }
            }
        }
        return intersections;
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
     * Returns the y value of the point
     *
     * @return x
     */
    public double getXValue() {
        return this.x;
    }

    /**
     * getter for Y value
     *
     * @return y
     */
    public double getYValue() {
        return this.y;
    }

    /**
     * Calculates and returns the distance that the point is from another point
     *
     * @param p point object
     * @return distance
     */
    public double distanceFrom(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }


    /**
     * overridden .toString method that returns both coordinates
     *
     * @return (x, y) as a string
     */
    @Override
    public java.lang.String toString() {
        return "(" + Math.round(x * 100) / 100 + "," + Math.round(y * 100) / 100 + ")";
    }


    /**
     * Returns if 2 points are equal
     *
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
