package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import draw.Renderer;
import draw.DrawableShapeCollection;
import draw.options.CircleRenderOptions;
import draw.options.PointRenderOptions;
import draw.options.RenderOptions;
import shapes.*;


public class GeoEngine extends ApplicationAdapter {
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
	@Override
	public void create () {//Init
		Gdx.graphics.setContinuousRendering(false);
		Gdx.graphics.requestRendering();

		renderer = new Renderer();

		circle = new Circle(new Point(0,0),0.4);
		point = new Point(0.5,0.5);

		shapes = new DrawableShapeCollection();
//		shapes.add("point",point,new PointRenderOptions(Color.BLUE,true));
		shapes.add("circle",circle,new CircleRenderOptions(Color.RED,0));

//
//		List shapes = new ...
//		shapes.Add("point1", new DrawableShape(point, options);
//		shapes.Add("point2", point);
//		shapes.Remove("point1");
//
//class DrawableShape
//	Shape Shape;
//	RenderOptions Options;
//}
//
//		renderer.draw(shapes);
//			foreach shape in shapes
//				lines = shape.GetLineSegments();
//				if lines != null
//					foreach line in lines
//						drawLine(line);
//
//				circles = shape.GetCircles();
//				if circles != null
//					foreach circle in circles
//						drawPoint(circle);
//
//				points = shape.GetPoints();
//				if points != null
//					foreach point in points
//						drawPoint(point);
//





	}

	@Override
	public void render () { //Ran every frame
		//set background
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.render(shapes);

	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
}
