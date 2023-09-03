package draw.options;

import com.badlogic.gdx.graphics.Color;

public class LineRenderOptions extends RenderOptions {

    public LineRenderOptions(Color color, LineStyle lineStyle) {
        super(color,false,CircleStyle.FILLED,lineStyle);
    }

    public LineRenderOptions(Color color) {
        super(color,false,CircleStyle.FILLED,LineStyle.SOLID);
    }

    public LineRenderOptions() {
        super(Color.BLACK,false,CircleStyle.FILLED,LineStyle.SOLID);
    }

}
