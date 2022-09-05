package com.mygdx.game;

public class Triangle {

    private Point vertexA; //Vertex A of the triangle
    private Point vertexB; //Vertex B of the triangle
    private Point vertexC; //Vertex C of the triangle
    private double area; //Area of the triangle
    private double perimeter; //Perimeter of the triangle
    private LineSegment AB; //Line AB
    private LineSegment AC; //Line AC
    private LineSegment BC; //Line BC

    /**
     * Constructor to set the vertices and sides of this triangle
     *
     * @param A Point A
     * @param B Point B
     * @param C Point C
     */
    public Triangle(Point A, Point B, Point C) {
        vertexA = A;
        vertexB = B;
        vertexC = C;
        AB = new LineSegment(A, B);
        AC = new LineSegment(A, C);
        BC = new LineSegment(B, C);
    }

    /**
     * returns true if Triangle Inequality is true.
     *
     * @return true/false
     */
    public boolean isValidTriangle() {
        return !(AB.getLength() + AC.getLength() <= BC.getLength() || AB.getLength() + BC.getLength() <= AC.getLength() || AC.getLength() + BC.getLength() <= AB.getLength() || AB.getSlope() == AC.getSlope() || AB.getSlope() == BC.getSlope() || BC.getSlope() == AC.getSlope());
    }

    /**
     * returns the vertex point A
     *
     * @return vertex point A
     */
    public Point getA() {
        return vertexA;
    }

    /**
     * returns the vertex point B
     *
     * @return vertex point B
     */
    public Point getB() {
        return vertexB;
    }

    /**
     * returns the vertex point C
     *
     * @return vertex point C
     */
    public Point getC() {
        return vertexC;
    }

    /**
     * returns the side AB
     *
     * @return side AB
     */
    public LineSegment getAB() {
        return AB;
    }

    /**
     * returns the side AC
     *
     * @return side AC
     */
    public LineSegment getAC() {
        return AC;
    }

    /**
     * returns the side BC
     *
     * @return side BC
     */
    public LineSegment getBC() {
        return BC;
    }

    /**
     * Setter that sets vertexA
     *
     * @param vertexA
     */
    public void setVertexA(Point vertexA) {
        this.vertexA = vertexA;
        AB = new LineSegment(vertexA, AB.getEnd());
        AC = new LineSegment(vertexA, AC.getEnd());
    }

    /**
     * Setter that sets vertexB
     *
     * @param vertexB
     */
    public void setVertexB(Point vertexB) {
        this.vertexB = vertexB;
        AB = new LineSegment(AB.getStart(), vertexB);
        BC = new LineSegment(vertexB, BC.getEnd());

    }

    /**
     * Setter that sets vertexC
     *
     * @param vertexC
     */
    public void setVertexC(Point vertexC) {
        this.vertexC = vertexC;
        AC = new LineSegment(AC.getStart(), vertexC);
        BC = new LineSegment(BC.getStart(), vertexC);
    }

    /**
     * Setter that sets side AB
     *
     * @param AB
     */
    public void setAB(LineSegment AB) {
        this.AB = AB;
        vertexA = AB.getStart();
        vertexB = AB.getEnd();

    }

    /**
     * Setter that sets side AC
     *
     * @param AC
     */
    public void setAC(LineSegment AC) {
        this.AC = AC;
        vertexA = AC.getStart();
        vertexC = AC.getEnd();
    }

    /**
     * Setter that sets side BC
     *
     * @param BC
     */
    public void setBC(LineSegment BC) {
        this.BC = BC;
        vertexB = BC.getStart();
        vertexC = BC.getEnd();
    }

    /**
     * Provide a text representation of the triangle
     *
     * @return string of triangle
     */
    @Override
    public java.lang.String toString() {
        return "Vertex A: " + vertexA.toString() + ", Vertex B: " + vertexB.toString() + ", Vertex C: " + vertexC.toString() + ", Line AB: " + AB.toString() + ", Line AC: " + AC.toString() + ", Line BC: " + BC.toString();
    }

    /**
     * sets the perimeter of this triangle
     */
    private void setPerimeter() {
        perimeter = AB.getLength() + AC.getLength() + BC.getLength();
    }

    /**
     * sets the area of this triangle
     */
    private void setArea() {
        area = BC.getLength() * BC.shortestDistanceFromPoint(vertexA) / 2;
    }

    /**
     * returns the area of the triangle
     *
     * @return area
     */
    public double getArea() {
        setArea();
        return area;
    }

    /**
     * returns the perimeter of the triangle
     *
     * @return perimeter
     */
    public double getPerimeter() {
        setPerimeter();
        return perimeter;
    }

    /**
     * returns the location of the centroid of the triangle
     *
     * @return centroid point
     */
    public Point centroid() {
        Point centroid = new Point((vertexA.getXValue() + vertexB.getXValue() + vertexC.getXValue()) / 3, (vertexA.getYValue() + vertexB.getYValue() + vertexC.getYValue()) / 3);
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
            return o.vertexA == this.vertexA && o.vertexB == this.vertexB && o.vertexC == this.vertexC;
        }
        return false;
    }
}
