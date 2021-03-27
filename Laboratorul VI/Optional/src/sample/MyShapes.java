package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class MyShapes {
    private String figure;
    private double x;
    private double y;
    private int size;
    private Color color;
    private int lineWidth;

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public MyShapes(String figure, double x, double y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.figure = figure;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double setX() {
        return x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public String getFigure() {
        return figure;
    }

    public String setFigure() {
        return figure;
    }

    public int getSize() {
        return size;
    }
}
