
import java.awt.Rectangle;

import java.awt.*;

/**
 * Created by chamin wickramarathna on 5/10/17.
 */
public class Ball {



    private static final int RADIUS = 60;


    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    int ballID;
    private Pen pen;



    public Ball(Pen pen) {
        this.pen = pen;
    }

    public Ball(int x, int y,int ballID, Pen pen) {
        this.x = x;
        this.y = y;
        this.ballID = ballID;
        this.pen = pen;
    }

    void move() {
        if (x + xa < 0)
            xa *= -1;
        if (x + xa > pen.getWidth() - 60)
            xa *= -1;
        if (y + ya < 0)
            ya *= -1;
        if (y + ya > pen.getHeight() - 60)
            ya *= -1;
        if (collision()){
            ya *= -1;
            //xa *= -1;
//            y = pen.ball2.getY() - RADIUS;
        }

        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g) {
//        g.fillOval(x, y, 30, 30);
        g.drawImage(pen.image,x,y, null);

    }

    private boolean collision() {
        boolean isCollied =false;
        for (Ball ball : pen.ballArray) {
            if(!isCollied && this.ballID!=ball.ballID ){
                isCollied = ball.getBounds().intersects(this.getBounds());
            }

        }

//        System.out.println(isCollied);
        return isCollied;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, RADIUS,RADIUS);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
