import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Problem3 extends JFrame {
   private MyPanel panel = new MyPanel();

   public Problem3() {
      setTitle("Problem3");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(panel);
      setSize(500, 500);
      setVisible(true);
   }

   class MyPanel extends JPanel {
      private ImageIcon icon = new ImageIcon("images/image0.jpg");
      private Image image = icon.getImage();
      private Point point = new Point(50, 50);

      public MyPanel() {
         this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
               point = e.getPoint();
               repaint();
            }
         });
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
         g.setColor(Color.GREEN);
         g.fillOval((int) point.getX(), (int) point.getY(), 40, 40);
      }
   }

   public static void main(String[] args) {
      new Problem3();
   }

}