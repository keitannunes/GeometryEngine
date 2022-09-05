package com.mygdx.game;

public class Line {

    private Point point = new Point(); //start point
    private double slope; //slope
    private double length; //length
    private Point yIntercept = new Point(); //y intercept point

    /**
     * Constructor for 2 given points
     * @param p1 point 1
     * @param p2 point 2
     */
    public Line(Point p1, Point p2) {
        point = p1;
        double x1 = p1.getXValue();
        double x2 = p2.getXValue();
        double y1 = p1.getYValue();
        double y2 = p2.getYValue();
        slope = (y2-y1)/(x2-x1);
        yIntercept.setPosition(0, p1.getYValue() - slope * p1.getXValue());
    }

    /**
     * Constructor for a point and slope
     * @param p
     * @param slope
     */
    public Line(Point p, double slope){
        point = p;
        this.slope = slope;
        yIntercept.setPosition(0, p.getYValue() - slope * p.getXValue());
    }

    /**
     * Provides the slope of the line
     * @return slope
     */
    public double getSlope() {
        return slope;
    }

    /**
     * Check if a line segment is parallel to this line
     * @param lineSegment
     * @return true/false
     */
    public boolean isParallel(LineSegment lineSegment) {
        return this.slope == lineSegment.getSlope();
    }

    /**
     * Checks if a line is parralel to this line
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
     * @return yIntercept
     */
    public Point getYIntercept() {
        return yIntercept;
    }

/* Have to create 2nd point
    public Point pointOfIntersection(LineSegment otherLineSegment) {//MAKE SURE TO TRY/CATCH when using this method
        if ( this.isParallel(otherLineSegment) && this.getYIntercept().getYValue() == otherLineSegment.getYIntercept().getYValue()) {
            throw new RuntimeException("Both lines are the same");
        } else if (this.isParallel(otherLineSegment)) {
            throw new RuntimeException("Lines are parallel");
        } else {
            double startX = start.getXValue();
            double startY= start.getYValue();
            double endX = end.getXValue();
            double endY = end.getYValue();
            double otherStartX = otherLineSegment.start.getXValue();
            double otherStartY= otherLineSegment.start.getYValue();
            double otherEndX = otherLineSegment.end.getXValue();
            double otherEndY = otherLineSegment.end.getYValue();

            double v = (startX - endX) * (otherStartY - otherEndY) - (startY - endY) * (otherStartX - otherEndX);
            return new Point(((startX * endY - startY * endX) * (otherStartX - otherEndX) - (startX - endX) * (otherStartX * otherEndY - otherStartY * otherEndX)) / v, ((startX * endY - startY * endX) * (otherStartY - otherEndY) - (startY - endY) * (otherStartX * otherEndY - otherStartY * otherEndX)) / v);

        }
    }
*/


}
