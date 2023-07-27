import Shapes.Oval;
import Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainPanel extends JPanel implements ActionListener {

    /////////////////////////////////   Settings
    private int NUMBER_OF_BUBBLES=1000;
    private boolean PSYCHO=false;

    private boolean AGARIO=false;
    ////////////////////////////////
    private final int PANEL_WIDTH=1920;
    private final int PANEL_Height=1000;
    private final Timer timer;
    private List<Oval> bubbles;

    public MainPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_Height));
        this.setBackground(Color.BLACK);
        bubbles=new ArrayList<>();
        timer=new Timer(10,this);


        Random rand = new Random();
        int renderXCoord =10;
        int renderYCoord =10;
        int renderWidth =100;
        for (int i = 0; i < NUMBER_OF_BUBBLES; i++) {
            int width =rand.nextInt(100);
            if (renderXCoord + renderWidth +100>=PANEL_WIDTH){
                 renderXCoord =10;
                renderYCoord +=110;
            }
            else if (renderYCoord + renderWidth >=PANEL_Height) {
                System.out.println("You gain maximum number od bubbles for current frame size: "+i);
                break;
            }
            int x= renderXCoord + renderWidth;
            int y= renderYCoord;

            renderXCoord+=100;

            int xVel=rand.nextInt(2)+1;
            int yVel=rand.nextInt(2)+1;

            int xDirection=rand.nextInt(2)==0?-1:1;
            int yDirection=rand.nextInt(2)==0?-1:1;
            Oval oval=new Oval(x, y, width,xVel*xDirection,yVel*yDirection);
            oval.setColor(randomColor());
            bubbles.add(oval);

        }
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D=(Graphics2D) g;
        for (Oval o : bubbles) {
            g2D.setPaint(o.getColor());

            if (PSYCHO) {
                g2D.setPaint(randomColor());
                this.setBackground(randomColor());
            }

            g2D.fillOval(o.getX(),o.getY(),o.getWidth(),o.getWidth());
        }

    }

    public Color randomColor()
    {

        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(236)+20;
        int green = randomGenerator.nextInt(236)+20;
        int blue = randomGenerator.nextInt(236)+20;
        return new Color(red,green,blue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < bubbles.size(); i++) {
            Shape s = bubbles.get(i);
            for (int j = 0; j < bubbles.size(); j++) {
                Shape s2 = bubbles.get(j);
                if (s != s2) {
                    if(s.intersects(s2)&& !AGARIO){
                                  int tempX=s.getxVelocity();
                                  int tempY=s.getyVelocity();

                                  s.setxVelocity(s2.getxVelocity());
                                  s.setyVelocity(s2.getyVelocity());

                                  s2.setxVelocity(tempX);
                                  s2.setyVelocity(tempY);
                                  s.move();
                                  s2.move();
                              }
                    if (s.intersects(s2) && s.getHeight()> s2.getHeight() - 50 && s.getDistance(s2)<30 && AGARIO) {
                        s.setWidth(s.getWidth() + s2.getWidth() / 4);
                        s.setHeight(s.getHeight() + s2.getHeight() / 4);
                        bubbles.remove(j); // Удаляем элемент из списка по индексу j
                        break;
                    }
                }
            }
            if (s.getX() >= PANEL_WIDTH - s.getWidth() || s.getX() <= 0)
                s.reverseVelocity(true);
            else if (s.getY() >= PANEL_Height - s.getHeight() || s.getY() <= 0)
                s.reverseVelocity(false);
            s.move();
        }
        repaint();
    }


}
