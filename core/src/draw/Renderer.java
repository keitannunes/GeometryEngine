package draw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


import java.util.ArrayList;

public class Renderer {
    private final ShapeRenderer shapes;
    private final OrthographicCamera camera;
    private final BitmapFont font;
    private final SpriteBatch batch;

    private static final double screenHalfSideLength = (double)Gdx.graphics.getHeight()/2;



    public Renderer() {
        shapes = new ShapeRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera.position.set(0,0,0);
        shapes.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);
    }

//    public void render() {
//        for (DrawableCircle circle : circleList) {
//            if (circle.getCircleStyle() == 0) {
//                shapes.begin(ShapeRenderer.ShapeType.Filled);
//            } else {
//                Gdx.gl.glLineWidth(4); //set line thickness to 4
//                shapes.begin(ShapeRenderer.ShapeType.Line);
//            }
//            shapes.setColor(circle.getColor());
//            shapes.circle(circle.getX(),circle.getY(),circle.getRadius());
//            shapes.end();
//        }
//
//        for (DrawableText text : textList) {
//            batch.begin();
//            font.setColor(text.getColor());
//            font.draw(batch, text.getText(), text.getX(), text.getY());
//            batch.end();
//        }
//    }
    private static float convertToPixels(double num) {
        return (float) (num/(double)100*screenHalfSideLength);
    }
    public void render(DrawableShapeCollection collection) {
        //Line Segments
        for (ArrayList<DrawableLineSegment> lineSegments : collection.getLineSegments().values()) {
            for (DrawableLineSegment lineSegment : lineSegments) {
                shapes.begin(ShapeRenderer.ShapeType.Filled);
                shapes.setColor(lineSegment.getColor());
                float x1 = convertToPixels(lineSegment.getX1());
                float y1 = convertToPixels(lineSegment.getY1());
                float x2 = convertToPixels(lineSegment.getX2());
                float y2 = convertToPixels(lineSegment.getY2());
                switch (lineSegment.getLineStyle()) {
                    case SOLID: {
                            shapes.rectLine(x1, y1, x2, y2, 2);
                            break;
                    }
                    case DOTTED:
                    case DASHED: {
                        //add code here
                        break;
                    }
                }
                shapes.end();
            }
        }
        //circles
        for (ArrayList<DrawableCircle> circles : collection.getCircles().values()) {
            for (DrawableCircle circle : circles) {
                switch (circle.getCircleStyle()) {
                    case FILLED: {
                        shapes.begin(ShapeRenderer.ShapeType.Filled);
                        break;
                    }
                    case SHELL: {
                        Gdx.gl.glLineWidth(4); //set line thickness to 4
                        shapes.begin(ShapeRenderer.ShapeType.Line);
                        break;
                    }
                }
                float x = convertToPixels(circle.getX());
                float y = convertToPixels(circle.getY());
                float radius = convertToPixels(circle.getRadius());
                shapes.setColor(circle.getColor());
                shapes.circle(x, y, radius);
                shapes.end();
            }
        }
        //texts
        for (ArrayList<DrawableText> texts : collection.getTexts().values()) {
            for (DrawableText text : texts) {
                batch.begin();
                font.setColor(text.getColor());
                float x = convertToPixels(text.getX());
                float y = convertToPixels(text.getY());
                font.draw(batch, text.getText(), x, y);
                batch.end();
            }
        }
    }

    public void dispose() {
        shapes.dispose();
        batch.dispose();
    }

}
