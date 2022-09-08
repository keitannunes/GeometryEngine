package com.mygdx.game;

public class Quadrilateral extends Polygon{

    private LineSegment[] diagonal;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        vertices = new Point[]{a,b,c,d};
        // [AB, BC, CD, DA]
        sides = new LineSegment[]{new LineSegment(a,b), new LineSegment(b,c), new LineSegment(c,d), new LineSegment(d,a)};
        // [AC, BD]
        diagonal = new LineSegment[]{new LineSegment(a,c), new LineSegment(b,d)};
    }

    public double getArea() {
        if (area == 0) {
            Triangle triangle1 = new Triangle(vertices[0],vertices[1],vertices[3]);
            Triangle triangle2 = new Triangle(vertices[1],vertices[2],vertices[3]);
            area = triangle1.getArea() + triangle2.getArea();
        }
        return area;
    }



}
