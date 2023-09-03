package draw.options;

import com.badlogic.gdx.graphics.Color;

public class CircleRenderOptions extends RenderOptions {

    public CircleRenderOptions(Color color, CircleStyle circleStyle) {
        super(color,false,circleStyle,LineStyle.SOLID);
    }
}
