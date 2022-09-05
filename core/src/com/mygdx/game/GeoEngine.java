package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;


public class GeoEngine extends ApplicationAdapter {
	ShapeDriver shapeDriver;
	LineSegment lineSeg;
	Line xAxis;
	Line yAxis;
	Line line3;
	Triangle triangle;
	Circle circle;

	@Override
	public void create () {//Init
		shapeDriver = new ShapeDriver();
		lineSeg = new LineSegment(new Point(-100,100), new Point(300,200));
		xAxis = new Line(new Point(0,0), new Point(1,0));
		yAxis = new Line(new Point(0,0), new Point(0,1));
		line3 = new Line(new Point(0,0), 0.123);
		triangle = new Triangle(new Point(100,-200),new Point(125,200), new Point(-100, 25));
		circle = new Circle(new Point(200,0),100);

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

		shapeDriver.setColour(Color.RED);
		shapeDriver.drawPoint(circle.getCenter());
		shapeDriver.drawPoint(new Point(100,200));

		shapeDriver.setColour(Color.RED);
		shapeDriver.drawLine(line3);

		shapeDriver.setColour(Color.ORANGE);
		shapeDriver.drawTriangle(triangle);

		shapeDriver.setColour(Color.BROWN);
		shapeDriver.drawCircle(circle);
	}
	
	@Override
	public void dispose () {
		shapeDriver.dispose();
	}
}
