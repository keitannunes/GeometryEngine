package draw;

import com.badlogic.gdx.graphics.Color;
import draw.options.LineStyle;
import shapes.Line;

public class DrawableLineSegment {
    private final Color color;
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final LineStyle lineStyle;

    public DrawableLineSegment(Color color, double x1, double y1, double x2, double y2, LineStyle lineStyle) {
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.lineStyle = lineStyle;
    }

    public Color getColor() {
        return color;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public LineStyle getLineStyle() {
        return lineStyle;
    }
}
