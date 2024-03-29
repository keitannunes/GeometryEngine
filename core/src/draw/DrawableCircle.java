package draw;

import com.badlogic.gdx.graphics.Color;
import draw.options.CircleStyle;

public class DrawableCircle {
    private final Color color;
    private final double x;
    private final double y;
    private final double radius;
    private final CircleStyle circleStyle;

    public DrawableCircle(Color color, double x, double y, double radius, CircleStyle circleStyle) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.circleStyle = circleStyle;
    }

    public Color getColor() {
        return color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public CircleStyle getCircleStyle() {
        return circleStyle;
    }
}
