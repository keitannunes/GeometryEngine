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
     * @return true/false
     */
    public boolean isParallel(LineSegment lineSegment) {
        return this.slope == lineSegment.getSlope();
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
     * returns the point of intersection between of the real line collinear with this line with another line.
     * @param otherLineSegment
     * @return point of intersection
     */
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

    /**
     * returns shortest distance between any point and the real line collinear with this line segment
     * @param p
     * @return shortest distance from point
     */
    public double shortestDistanceFromPoint(Point p) { //I DONT THINK THIS WORKS PLEASE CONFIRM FUTURE ME PLS (IT WORKS)
        return Math.abs((start.getYValue() - end.getYValue()) * p.getXValue() + (end.getXValue() - start.getXValue()) * p.getYValue() + (start.getXValue() - end.getXValue()) * start.getYValue() + (end.getYValue() - start.getYValue()) * start.getXValue()) / Math.sqrt(Math.pow((start.getYValue() - end.getYValue()), 2) + Math.pow((end.getXValue() - start.getXValue()), 2));
    }


}
