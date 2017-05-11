import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by chamin wickramarathna on 5/10/17.
 */
public class Pen extends JPanel {

    Ball[] ballArray;
    public BufferedImage image;
    int ballCount =4;

    public Pen(int ballCount) {
         this.ballCount=ballCount;

        this.ballArray = new Ball[ballCount];
        ImagePanel();

        for (int i =0; i< ballCount; i++) {
            ballArray[i] = new Ball(i*70, i*70, i, this);
        }


//        ballArray[0] = new Ball(0,0 ,0,this);
//        ballArray[1] = new Ball(0,200,1 ,this);
//        ballArray[2] = new Ball(0,100,1 ,this);



    }



    public void move() {
        for (Ball ball : ballArray) {
            ball.move();
        }
    }



    private void ImagePanel() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("images/60.png"));
        } catch (IOException ex) {
            System.out.println(ex);
            // handle exception...
        }
    }


    @Override
    public void paint(Graphics g) {
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (Ball ball : ballArray) {
            ball.paint(g2d);
        }


    }

}
