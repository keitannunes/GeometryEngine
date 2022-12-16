package draw;

import com.badlogic.gdx.graphics.Color;

public class DrawableText {
    private final Color color;
    private final String text;
    private final double x;
    private final double y;

    public DrawableText(Color color, String text, double x, double y) {
        this.color = color;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
