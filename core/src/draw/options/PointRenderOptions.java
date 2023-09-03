package draw.options;

import com.badlogic.gdx.graphics.Color;

public class PointRenderOptions extends RenderOptions {


    public PointRenderOptions(Color color, boolean drawCoords) {
        super(color,drawCoords,CircleStyle.FILLED,LineStyle.SOLID);
    }
}
