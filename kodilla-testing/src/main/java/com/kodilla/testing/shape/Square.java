package com.kodilla.testing.shape;

public class Square implements Shape {
    public String shapeName;
    public double field;

    public Square(String figureName, double figureField) {
        this.shapeName = figureName;
        this.field = figureField;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return field;
    }
}