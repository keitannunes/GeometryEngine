package draw.options;

import com.badlogic.gdx.graphics.Color;

public class RenderOptions {
    public Color color;
    public boolean drawCoords;
    public CircleStyle circleStyle; //0 - Filled, 1 - Outline
    public LineStyle lineStyle; //0 - Regular, 1 - Dotted, 2 - Dashed

    public RenderOptions(Color color, boolean drawCoords, CircleStyle circleStyle, LineStyle lineStyle) {
        this.color = color;
        this.drawCoords = drawCoords;
        this.circleStyle = circleStyle;
        this.lineStyle = lineStyle;
    }
}

