package Shapes;
import java.lang.Math;
public class Oval extends Shape{

    private int radius;


    public Oval(int x, int y, int width, int xVelosity, int yVelosity) {
        super(x, y, width, width, xVelosity, yVelosity);
        this.radius = width/2;
    }

    public Oval( int x, int y, int width) {
        super(x, y, width, width);
        this.radius = width/2;
    }

    public Oval(int width) {
        super(width,width);
        this.radius = width/2;
    }

    @Override
    public double getDistance(Shape shape) {
        return Math.sqrt( Math.pow((shape.x+shape.getWidth()/2)-(this.x+this.radius),2)+Math.pow((shape.y+shape.getWidth()/2)-(this.y+this.radius),2));
    }

    @Override
    public boolean intersects(Shape shape) {
        if (this.getDistance(shape)<=shape.width/2+this.radius)
            return true;
        return false;
    }

    public int getRadius() {
        return radius;
    }
}
