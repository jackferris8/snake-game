package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class snakeBlock {

    private double x;
    private double y;
    private boolean isHead;

    public snakeBlock(double x, double y){
        this.x = x;
        this.y = y;

    }


    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void draw() {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(this.getX(), this.getY(), .01, .01);
    }


}
