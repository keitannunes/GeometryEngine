package shapes;

public abstract class Polygon extends Shape{
    protected Point[] vertices;
    protected LineSegment[] sides;
    protected double perimeter;
    protected double area;
/*
    public Polygon(Point[] points) {
        vertices = new Point[points.length];
        vertices[0] = points[0];
        for (Point point : points) {

        }
    }
*/
    /**
     * Returns the sides
     * @return Array of sides
     */
    public LineSegment[] getSides() {
        return sides;
    }

    @Override
    public PrimitiveLineSegment[] GetPrimitiveLineSegments() {
        PrimitiveLineSegment[] lineSegments = new PrimitiveLineSegment[sides.length];
        for (int i = 0; i < sides.length; i++) {
            lineSegments[i] = sides[i].GetPrimitiveLineSegments()[0];
        }
        return lineSegments;
    }


    /**
     * Returns the vertices
     * @return Array of vertices
     */
    public Point[] getVertices(){
        return vertices;
    }

    /**
     * returns the perimeter of the triangle
     *x
     * @return perimeter
     */
    public double getPerimeter() {
        if (perimeter == 0) { //hasn't been calculated yet
            for (LineSegment side: sides) {
                perimeter += side.getLength();
            }
        }
        return perimeter;
    }

    public abstract double getArea();


}
