package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;


public class GeoEngine extends ApplicationAdapter {
	ShapeDriver shapeDriver;
	LineSegment line;
	Line xAxis;
	Line yAxis;
	Line line3;

	@Override
	public void create () {//Init
		shapeDriver = new ShapeDriver();
		line = new LineSegment(new Point(-100,100), new Point(300,200));
		xAxis = new Line(new Point(0,0), new Point(1,0));
		yAxis = new Line(new Point(0,0), new Point(0,1));
		line3 = new Line(new Point(0,0), 0.123);


	}

	@Override
	public void render () { //Ran every frame
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeDriver.setColour(Color.BLACK);
		shapeDriver.drawLine(xAxis);
		shapeDriver.drawLine(yAxis);

		shapeDriver.setColour(Color.BLUE);
		shapeDriver.drawLineSegment(line);
		shapeDriver.setColour(Color.RED);
		shapeDriver.drawLine(line3);
	}
	
	@Override
	public void dispose () {
		shapeDriver.dispose();
	}
}
