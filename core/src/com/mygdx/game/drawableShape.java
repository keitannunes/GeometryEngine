package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import shapes.Shape;

public class drawableShape {
    private final Color colour;
    private final Shape shape;
    private final boolean dotted;
    private final boolean drawCoords;

    public drawableShape(Shape shape, Color colour, boolean dotted) {
        this.shape = shape;
        this.colour = colour;
        this.dotted = dotted;
        this.drawCoords = dotted;
    }
    public drawableShape(Shape shape, Color colour) {
        this.shape = shape;
        this.colour = colour;
        this.dotted = false;
        this.drawCoords = false;
    }

    public drawableShape(Shape shape) {
        this.shape = shape;
        this.colour = Color.BLACK;
        this.dotted = false;
        this.drawCoords = false;
    }

    public Color getColour() {
        return colour;
    }

    public Shape getShape() {
        return shape;
    }

    public boolean isDotted() {
        return dotted;
    }

    public boolean isDrawCoords() {
        return drawCoords;
    }
}
