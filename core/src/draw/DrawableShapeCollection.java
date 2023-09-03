package draw;

import com.badlogic.gdx.graphics.Color;
import draw.options.CircleStyle;
import draw.options.RenderOptions;
import shapes.*;

import java.util.ArrayList;
import java.util.HashMap;

public class DrawableShapeCollection {
    private final HashMap<String,ArrayList<DrawableCircle>> circles;
    private final HashMap<String,ArrayList<DrawableLineSegment>> lineSegments;

    private final HashMap<String,ArrayList<DrawableText>> texts;
    private final ArrayList<PrimitivePoint> pointsWithUndrawnCoords;


    public DrawableShapeCollection() {
        circles = new HashMap<>();
        texts = new HashMap<>();
        lineSegments = new HashMap<>();
        pointsWithUndrawnCoords = new ArrayList<>();
    }
    private void addToCircles(String id, DrawableCircle circle) {
        if (!circles.containsKey(id)) {
            circles.put(id, new ArrayList<DrawableCircle>());
        }
        circles.get(id).add(circle);
    }
    private void addToLineSegments(String id, DrawableLineSegment lineSegment) {
        if (!lineSegments.containsKey(id)) {
            lineSegments.put(id, new ArrayList<DrawableLineSegment>());
        }
        lineSegments.get(id).add(lineSegment);
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

            DrawableCircle circle = new DrawableCircle(color, x, y, 1.25, CircleStyle.FILLED);
            addToCircles(id, circle);

            if (options.drawCoords) {
                String text = "(" + Math.round(x * 10) / (double)10 + "," + Math.round(y * 10) / (double)10 + ")";
                addToTexts(id, new DrawableText(color, text, x + 1.25, y - 1.25));
            } else {
                pointsWithUndrawnCoords.add(point);
            }
        }

        PrimitiveLineSegment[] lineSegments = shape.GetPrimitiveLineSegments();
        for (PrimitiveLineSegment lineSegment : lineSegments) {
            double x1 = lineSegment.x1;
            double y1 = lineSegment.y1;
            double x2 = lineSegment.x2;
            double y2 = lineSegment.y2;
            DrawableLineSegment drawableLineSegment = new DrawableLineSegment(color,x1,y1,x2,y2, options.lineStyle);
            addToLineSegments(id,drawableLineSegment);
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

    public HashMap<String, ArrayList<DrawableLineSegment>> getLineSegments() {
        return lineSegments;
    }

    public HashMap<String, ArrayList<DrawableText>> getTexts() {
        return texts;
    }

    public ArrayList<PrimitivePoint> getPointsWithUndrawnCoords() {
        return pointsWithUndrawnCoords;
    }
}
