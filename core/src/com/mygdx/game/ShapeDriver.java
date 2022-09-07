package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;

public class ShapeDriver {
private ShapeRenderer shapes;
private OrthographicCamera camera;
private Color colour;
private BitmapFont font = new BitmapFont();
private SpriteBatch batch = new SpriteBatch();
private int dotDistance;

    public ShapeDriver() {
        shapes = new ShapeRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(0,0,0);
        shapes.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);

        dotDistance = 6; //set default dot distance 2 to px
    }

    /**
     * Draws a point
     * @param point Point
     */
    public void draw(Point point) {
        draw(point, false);
    }

    /**
     * Draws a point
     * @param point Point
     * @param drawCoords Draw the coordinates
     */
    public void draw(Point point, Boolean drawCoords) {
        float x = (float)point.getXValue();
        float y = (float)point.getYValue();
        shapes.begin(ShapeType.Filled);
        shapes.setColor(colour);
        shapes.circle(x,y,5);
        shapes.end();

        //Coordinates
        if (drawCoords) {
            batch.begin();
            font.setColor(colour);
            font.draw(batch, point.toString(), x + 5, y - 5);
            batch.end();
        }
    }

    /**
     * Draws a line segment
     * @param line Line Segment
     */
    public void draw(LineSegment line)
    {
        draw(line, false);
    }

    /**
     * Draws a line segment
     * @param line Line Segment
     * @param dotted Dotted line
     */
    public void draw(LineSegment line, boolean dotted) {
        shapes.begin(ShapeType.Filled);
        shapes.setColor(colour);

        if(dotted) {
            for (int i=0; i < line.getLength(); i+=dotDistance) {
                shapes.circle((float) line.getStart().getXValue() + i, (float) line.getStart().getYValue() + (float)line.getSlope()*i, 2);
            }
        } else {
            shapes.rectLine((float) line.getStart().getXValue(), (float) line.getStart().getYValue(), (float) line.getEnd().getXValue(), (float) line.getEnd().getYValue(), 2);
        }
        shapes.end();
    }

    /**
     * Draws a line
     * @param line Line
     */
    public void draw(Line line) {
        draw(line, false);
    }

    /**
     * Draws a line
     * @param line Line
     * @param dotted Dotted line
     */
    public void draw(Line line, boolean dotted) {
        Point p1;
        Point p2;
        double screenHeight = Gdx.graphics.getHeight();
        double screenWidth = Gdx.graphics.getWidth();
        //Check if it's a vertical line
        if (line.getSlope() == Double.POSITIVE_INFINITY) {
            //Bottom Point
            p1 = new Point(line.getPoint().getXValue(),screenHeight/-2);
            //Top Point
            p2 = new Point(line.getPoint().getXValue(),screenHeight/2);
        } else {
            //Left Point
            p1 = new Point( screenWidth / -2, screenWidth / -2 * line.getSlope() + line.getYIntercept().getYValue()); //(x,mx+b)
            //Right Point
            p2 = new Point(screenWidth / 2, screenWidth / 2 * line.getSlope() + line.getYIntercept().getYValue());//(x,mx+b)
        }

        shapes.begin(ShapeType.Filled);
        shapes.setColor(colour);
        if(dotted) {
            for (int i=0; i < p1.distanceFrom(p2); i+=dotDistance) {
                if (line.getSlope() == Double.POSITIVE_INFINITY) {
                    shapes.circle((float) p1.getXValue(), (float) p1.getYValue() + i, 2);
                } else {
                    shapes.circle((float) p1.getXValue() + i, (float) p1.getYValue() + (float) line.getSlope() * i, 2);
                }
            }
        } else{
                shapes.rectLine((float) p1.getXValue(), (float) p1.getYValue(), (float) p2.getXValue(), (float) p2.getYValue(), 2);
            }
        shapes.end();
    }

    /**
     * Draws a polygon
     * @param polygon Polygon
     */
    public void draw(Polygon polygon) {
        for (LineSegment lineSeg : polygon.getSides())
            draw(lineSeg);
    }

    /**
     * Draws a circle
     * @param circle Circle
     */
    public void draw(Circle circle) {
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
        batch.dispose();
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
