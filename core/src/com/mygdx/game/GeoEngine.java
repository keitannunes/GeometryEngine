package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;


public class GeoEngine extends ApplicationAdapter {
	ShapeDriver shapeDriver;
	LineSegment lineSeg;
	LineSegment lineSeg2;
	Line xAxis;
	Line yAxis;
	Line line1;
	Line line2;
	Line line3;
	Triangle triangle;
	Circle circle;

	@Override
	public void create () {//Init
		shapeDriver = new ShapeDriver();
		lineSeg = new LineSegment(new Point(-75,100), new Point(300,200));
		lineSeg2 = new LineSegment(new Point(-50, -127), new Point(100,300));
		xAxis = new Line(new Point(0,0), new Point(1,0));
		yAxis = new Line(new Point(0,0), new Point(0,1));
		line1 = new Line(new Point(0,1), 0.125);
		line2 = new Line(new Point(0,76.34789),-0.125);
		triangle = new Triangle(new Point(100,-200),new Point(125,200), new Point(-100, 25));
		circle = new Circle(new Point(200,0),100);
		line3 = new Line(new Point(0,0),10);
	}

	@Override
	public void render () { //Ran every frame
		//set background
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//set axis
		shapeDriver.setColour(Color.BLACK);
		shapeDriver.drawLine(xAxis);
		shapeDriver.drawLine(yAxis);

		shapeDriver.setColour(Color.BLUE);
		shapeDriver.drawLineSegment(lineSeg);
		shapeDriver.drawLineSegment(lineSeg2);

		//shapeDriver.setColour(Color.GREEN);
		//shapeDriver.drawLine(line1);

		//shapeDriver.setColour(Color.BLUE);
		//shapeDriver.drawLine(line2);

		//shapeDriver.setColour(Color.GRAY);
		//shapeDriver.drawLine(line3);

		//shapeDriver.setColour(Color.ORANGE);
		//shapeDriver.drawTriangle(triangle);

		//shapeDriver.setColour(Color.BROWN);
		//shapeDriver.drawCircle(circle);

		//GL1, BL2, GRL3
		shapeDriver.setColour(Color.RED);
		shapeDriver.drawPoint(lineSeg2.pointOfIntersection(lineSeg));
		//shapeDriver.drawPoint(circle.getCenter());

	}
	
	@Override
	public void dispose () {
		shapeDriver.dispose();
	}
}
