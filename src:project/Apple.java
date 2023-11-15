package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.Random;

public class Apple {

    private Double[] appleXY;
    public final int x = 0;
    public final int y = 1;

    public Apple(double X, double Y){
        appleXY = new Double[2];
        appleXY[x] = X;
        appleXY[y] = Y;
    }

    public double getX(){
        return appleXY[x];
    }
    public double getY(){

        return appleXY[y];
    }

    public void draw(){
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(this.getX(), this.getY(), .01);
    }

    public void moveApple(){
        appleXY[x] = Math.random();
        appleXY[y] = Math.random();
    }



}
