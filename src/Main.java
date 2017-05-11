import javax.swing.*;

/**
 * Created by chamin wickramarathna on 5/10/17.
 */

public class Main  {



    public static void main(String[] args) {


        String ballCountStr = JOptionPane.showInputDialog("Tortoise count?");
        int ballcount =Integer.parseInt(ballCountStr);

        JFrame frame = new JFrame("Tortoise Pen");
        Pen pen = new Pen(ballcount);
        frame.add(pen);
//        frame.setSize(300, 300);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            pen.move();
            pen.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
