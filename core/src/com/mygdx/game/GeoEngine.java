package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import draw.Renderer;
import draw.DrawableShapeCollection;
import draw.options.*;
import shapes.*;

public class GeoEngine extends ApplicationAdapter {
	int i = 0;
	Renderer renderer;
	LineSegment lineSeg;
	LineSegment lineSeg2;
	Line xAxis;
	Line yAxis;
	Line line1;
	Line line2;
	Line line3;
	Triangle triangle;
	Triangle triangle2;
	Circle circle;
	Point point;
	Quadrilateral quad;
	DrawableShapeCollection shapes;
	DrawableShapeCollection axis;
	@Override
	public void create () {//Init
		Gdx.graphics.setContinuousRendering(false);
		renderer = new Renderer();

		lineSeg = new LineSegment(Point.origin,new Point(-50,-50));
		triangle = new Triangle(new Point(-25,-50),new Point(-75,25),new Point(10,-25));
		line1 = new Line(new Point(0,0), 1);
		xAxis = new Line(Point.origin, new Point(1,0));
		yAxis = new Line(Point.origin, new Point(0,1));


		axis = new DrawableShapeCollection();
		axis.add("xAxis", xAxis, new LineRenderOptions());
		axis.add("yAxis", yAxis, new LineRenderOptions());

		shapes = new DrawableShapeCollection();
		shapes.add("tri",triangle,new LineRenderOptions(Color.RED));
		shapes.add("line", line1, new LineRenderOptions(Color.RED));
		shapes.add("p", new Point(50,50),new PointRenderOptions(Color.BLUE,true));

		for (Point p : Point.intersect(triangle,line1)) {
			shapes.add("intersects",p,new PointRenderOptions(Color.BLUE,true));
		}
	}

	@Override
	public void render () { //Ran every frame
		//set background
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render(axis);
		renderer.render(shapes);
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
}
