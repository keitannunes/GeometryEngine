package com.mygdx.game;

public class Triangle extends Polygon {

    private Point circumCenter;
    private Point centroid;


    /**
     * Constructor to set the vertices and sides of this triangle
     *
     * @param A Point A
     * @param B Point B
     * @param C Point C
     */
    public Triangle(Point A, Point B, Point C) {
        vertices = new Point[]{A, B, C};
        //0: AB, 1: AC, 2: BC
        sides = new LineSegment[]{new LineSegment(A, B),new LineSegment(A, C),new LineSegment(B, C)};
    }

    /**
     * returns true if Triangle Inequality is true.
     *
     * @return true/false
     */
    public boolean isValidTriangle() {
        double ABLen = sides[0].getLength();
        double ACLen = sides[1].getLength();
        double BCLen = sides[2].getLength();
        double ABSlope = sides[0].getSlope();
        double ACSlope = sides[1].getSlope();
        double BCSlope = sides[2].getSlope();

        return !(ABLen + ACLen <= BCLen || ABLen + BCLen <= ACLen || ACLen + BCLen <= ABLen || ABSlope == ACSlope || ABSlope == BCSlope || BCSlope == ACSlope);
    }


    /**
     * Provide a text representation of the triangle
     *
     * @return string of triangle
     */
    @Override
    public java.lang.String toString() {
        return "Vertex A: " + vertices[0].toString() + ", Vertex B: " + vertices[1].toString() + ", Vertex C: " + vertices[2].toString() + ", Line AB: " + sides[0].toString() + ", Line AC: " + sides[1].toString() + ", Line BC: " + sides[2].toString();
    }

    /**
     * returns the area of the triangle
     *
     * @return area
     */
    public double getArea() {
        if (area == 0) {
            area = sides[2].getLength() * sides[2].shortestDistanceFromPoint(vertices[0]) / 2;
        }
        return area;
    }


    /**
     * Returns the centroid of the triangle
     * @return Centroid point
     */
    public Point getCentroid() {
        if (centroid == null) {
            centroid = new Point((vertices[0].getXValue() + vertices[1].getXValue() + vertices[2].getXValue()) / 3, (vertices[0].getYValue() + vertices[1].getYValue() + vertices[2].getYValue()) / 3);
        }
        return centroid;
    }

    /**
     *compares the area of two triangles to determine which is bigger
     * @param other triangle
     * @return 1/0/-1 for greater/same/smaller
     */
    public int compareTo(Object other) {
        Triangle o = (Triangle) other;
        if (o.getArea() > this.getArea()) {
            return 1;
        } else if (o.getArea() == this.getArea()) {
            return 0;
        }
        return -1;
    }
    /**
     * returns true if this object is the same as other.
     * @param other object
     * @return true/false
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (this == null) {
            return false;
        }

        if (other instanceof Triangle) {
            Triangle o = (Triangle) other;
            return o.getVertices()[0] == this.vertices[0] && o.getVertices()[1] == this.vertices[1] && o.getVertices()[2] == this.getVertices()[2];
        }
        return false;
    }

    /*
    public Point getCircumCenter() {
        if (circumCenter == null) {
            // code to get the circumCenter;
        }

        return circumCenter;
    }
    */
}
