package shapes;

public class LineSegment extends Shape{

    private final Point start; //start point
    private final Point end; //end point
    private final double slope; //slope
    private final double length; //length
    private final Point yIntercept; //y intercept point

    /**
     * Returns the closest line between a point and a line segment
     * @param lineSeg Line Segment
     * @param point Point
     * @return Line Segment
     */
    public static LineSegment shortest(LineSegment lineSeg, Point point) {
        Point p1;
        if (lineSeg.includes(point)) {
            throw new RuntimeException("Point lies on line");
        }

        p1 = Point.intersect(new Line(point, -1 / lineSeg.getSlope()), lineSeg); //point where perpendicular line meets this line
        if (p1 == null) {
            if (point.distanceFrom(lineSeg.getStart()) < point.distanceFrom(lineSeg.getEnd())) {
                p1 = lineSeg.getStart();
            } else {
                p1 = lineSeg.getEnd();
            }
        }
        return new LineSegment(p1,point);
    }


    /**
     * Constructor to set the start and end position of the line
     * @param p1 point 1
     * @param p2 point 2
     */
    public LineSegment(Point p1, Point p2) {
        start = p1;
        end = p2;
        length = Math.sqrt(Math.pow(end.getXValue() - start.getXValue(), 2) + Math.pow(end.getYValue() - start.getYValue(), 2));
        slope = (end.getYValue() - start.getYValue()) / (end.getXValue() - start.getXValue());
        yIntercept = new Point(0, start.getYValue() - slope * start.getXValue());

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
        return new Point((start.getXValue() + end.getXValue()) / 2, (start.getYValue() + end.getYValue()) / 2);
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
     * @param lineSegment Line Segment
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
     * returns the shortest distance between any point and the real line collinear with this line segment
     * @param p
     * @return shortest distance from point
     */
    public double shortestDistanceFromPoint(Point p) {
        return Math.abs((start.getYValue() - end.getYValue()) * p.getXValue() + (end.getXValue() - start.getXValue()) * p.getYValue() + (start.getXValue() - end.getXValue()) * start.getYValue() + (end.getYValue() - start.getYValue()) * start.getXValue()) / Math.sqrt(Math.pow((start.getYValue() - end.getYValue()), 2) + Math.pow((end.getXValue() - start.getXValue()), 2));
    }

    /**
     * Checks if a point is on this line segment
     * @param point Point
     * @return Point
     */
    public boolean includes(Point point) {
        //check if: S---P-----E using distance between points
        LineSegment SP = new LineSegment(this.getStart(), point);
        LineSegment PE = new LineSegment(point, this.getEnd());

        //check if SE = SP + PE (floating point comparison)
        return Math.abs(SP.getLength() + PE.getLength() - this.getLength()) <= 0.000001;
    }
}
