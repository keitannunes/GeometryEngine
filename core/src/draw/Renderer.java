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

    private double screenHalfSideLength;



    public Renderer() {
        shapes = new ShapeRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera.position.set(0,0,0);
        shapes.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);
        screenHalfSideLength = (double)Gdx.graphics.getHeight()/2;
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

    public void render(DrawableShapeCollection collection) {
        //circles
        for (ArrayList<DrawableCircle> circles : collection.getCircles().values()) {
            for (DrawableCircle circle : circles) {
                if (circle.getCircleStyle() == 0) {
                    shapes.begin(ShapeRenderer.ShapeType.Filled);
                } else {
                    Gdx.gl.glLineWidth(4); //set line thickness to 4
                    shapes.begin(ShapeRenderer.ShapeType.Line);
                }
                float x = (float) (screenHalfSideLength *circle.getX());
                float y = (float) (screenHalfSideLength *circle.getX());
                float radius = (float) (screenHalfSideLength * circle.getRadius());
                shapes.setColor(circle.getColor());
                shapes.circle(x,y,radius);
                shapes.end();
            }
        }

        //texts
        for (ArrayList<DrawableText> texts : collection.getTexts().values()) {
            for (DrawableText text : texts) {
                batch.begin();
                font.setColor(text.getColor());
                float x = (float) (screenHalfSideLength *text.getX());
                float y = (float) (screenHalfSideLength *text.getY());
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
