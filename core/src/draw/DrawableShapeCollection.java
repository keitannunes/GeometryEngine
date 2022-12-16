package draw;

import com.badlogic.gdx.graphics.Color;
import draw.options.RenderOptions;
import shapes.*;

import java.util.ArrayList;
import java.util.HashMap;

public class DrawableShapeCollection {
    private final HashMap<String,ArrayList<DrawableCircle>> circles;
    private final HashMap<String,ArrayList<DrawableText>> texts;

    public DrawableShapeCollection() {
        circles = new HashMap<>();
        texts = new HashMap<>();
    }
    private void addToCircles(String id, DrawableCircle circle) {
        if (!circles.containsKey(id)) {
            circles.put(id, new ArrayList<DrawableCircle>());
        }
        circles.get(id).add(circle);
    }

    private void addToTexts(String id, DrawableText text) {
        if (!texts.containsKey(id)) {
            texts.put(id, new ArrayList<DrawableText>());
        }
        texts.get(id).add(text);
    }

    public void add(String id, Shape shape, RenderOptions options) {
        Color color = options.color;

        PrimitivePoint[] points = shape.GetPrimitivePoints();
        for (PrimitivePoint point : points) {
            double x = point.x;
            double y = point.y;

            DrawableCircle circle = new DrawableCircle(color, x, y, 0.0125, 0);
            addToCircles(id, circle);

            if (options.drawCoords) {
                String text = "(" + Math.round(x * 100) / 100 + "," + Math.round(y * 100) / 100 + ")";
                addToTexts(id, new DrawableText(color, text, x + 5, y - 5));
            }
        }

        PrimitiveLineSegment[] lineSegments = shape.GetPrimitiveLineSegments();
        for (PrimitiveLineSegment lineSegment : lineSegments) {

        }

        PrimitiveCircle[] circles = shape.GetPrimitiveCircles();
        for (PrimitiveCircle circle : circles) {
            double x = circle.x;
            double y = circle.y;
            double radius = circle.radius;
            DrawableCircle drawableCircle = new DrawableCircle(color, x, y, radius, options.circleStyle);
            addToCircles(id,drawableCircle);
        }
    }

    public HashMap<String, ArrayList<DrawableCircle>> getCircles() {
        return circles;
    }

    public HashMap<String, ArrayList<DrawableText>> getTexts() {
        return texts;
    }
}
