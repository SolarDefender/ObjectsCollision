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
    public boolean intersects(Shape s) {
        double dist=Math.sqrt( Math.pow((s.x+s.getWidth()/2)-(this.x+this.radius),2)+Math.pow((s.y+s.getWidth()/2)-(this.y+this.radius),2));
        if (dist<=s.width/2+radius)
            return true;
        return false;
    }

    public int getRadius() {
        return radius;
    }
}
