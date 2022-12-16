package draw.options;

import com.badlogic.gdx.graphics.Color;

public class RenderOptions {
    public Color color;
    public boolean drawCoords;
    public int circleStyle; //0 - Filled, 1 - Outline
    public int lineStyle; //0 - Regular, 1 - Dotted, 2 - Dashed

    public RenderOptions(Color color, boolean drawCoords, int circleStyle, int lineStyle) {
        this.color = color;
        this.drawCoords = drawCoords;
        this.circleStyle = circleStyle;
        this.lineStyle = lineStyle;
    }
}
