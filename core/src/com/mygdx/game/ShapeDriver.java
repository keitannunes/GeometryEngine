package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;

public class ShapeDriver {
private ShapeRenderer shapes;
private OrthographicCamera camera;
private Color colour;

    public ShapeDriver() {
        shapes = new ShapeRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(0,0,0);
        shapes.setProjectionMatrix(camera.combined);
    }

    /**
     * Draws a point
     * @param point Point
     */
    public void drawPoint(Point point) {
        shapes.begin(ShapeType.Filled);
        shapes.setColor(colour);
        shapes.circle((float)point.getXValue(),(float)point.getYValue(),5);
        shapes.end();
    }

    /**
     * Draws a Line Segment
     * @param line Line Segment
     */
    public void drawLineSegment(LineSegment line) {
        shapes.begin(ShapeType.Filled);
        shapes.setColor(colour);
        shapes.rectLine((float) line.getStart().getXValue(),(float) line.getStart().getYValue(), (float) line.getEnd().getXValue(),(float) line.getEnd().getYValue(),2);
        shapes.end();
    }

    /**
     * Draws a line
     * @param line Line
     */
    public void drawLine(Line line) {
        Point p1;
        Point p2;
        double screenHeight = Gdx.graphics.getHeight();
        double screenWidth = Gdx.graphics.getWidth();
        if (line.getSlope() == Double.POSITIVE_INFINITY) {
            //Bottom Point
            p1 = new Point(line.getPoint().getXValue(),screenHeight/-2);
            //Top Point
            p2 = new Point(line.getPoint().getXValue(),screenHeight/2);
        } else {
            //Left Point
            p1 = new Point( screenWidth / -2, screenWidth / -2 * line.getSlope() + line.getYIntercept().getYValue());
            //Right Point
            p2 = new Point(screenWidth / 2, screenWidth / 2 * line.getSlope() + line.getYIntercept().getYValue());
        }


        shapes.begin(ShapeType.Filled);
        shapes.setColor(colour);
        shapes.rectLine((float) p1.getXValue(),(float) p1.getYValue(), (float) p2.getXValue(),(float) p2.getYValue(),2);
        shapes.end();
    }

    /**
     * Draws a triangle
     * @param triangle Triangle
     */
    public void drawTriangle(Triangle triangle) {
        drawLineSegment(triangle.getAB());
        drawLineSegment(triangle.getAC());
        drawLineSegment(triangle.getBC());
    }

    /**
     * Draws a circle
     * @param circle Circle
     */
    public void drawCircle(Circle circle) {
        Gdx.gl.glLineWidth(2); //set line thickness to 2
        shapes.begin(ShapeType.Line);
        shapes.setColor(colour);
        shapes.circle((float)circle.getCenter().getXValue(),(float)circle.getCenter().getYValue(),(float)circle.getRadius());
        shapes.end();
    }


    /**
     * disposes ShapeRenderer
     */
    public void dispose() {
        shapes.dispose();
    }

    /**
     * Returns active colour
     * @return colour
     */
    public Color getColour() {
        return colour;
    }

    /**
     * Sets active colour
     * @param colour colour
     */
    public void setColour(Color colour) {
        this.colour = colour;
    }
}
