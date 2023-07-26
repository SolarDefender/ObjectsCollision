package Shapes;

import java.awt.*;

public class Shape {
    protected int x=0;
    protected int y=0;

    protected int width=0;
    protected int height=0;
    protected int xVelocity =0;
    protected int yVelocity =0;
    protected Color color=Color.WHITE;

    public Shape(int x, int y, int width, int height, int xVelocity, int yVelocity) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public Shape() {
    }

    public void move(){
        this.x+= xVelocity;
        this.y+= yVelocity;
    }
    public void reverseVelocity(boolean x)
    {
        if (x)
            this.xVelocity *=-1;
        else
            this.yVelocity *=-1;
    }

    public boolean intersects(Shape s) {
        return false;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }
}
