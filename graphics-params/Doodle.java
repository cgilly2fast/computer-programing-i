// Colby Gilbert
// 10/08/14
// TA: Michelle Cho
// CSE 142
// Assignment 3 (part 1)
//

import java.awt.*;

public class Doodle {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(500,500);
      panel.setBackground(Color.GRAY);
      
      Graphics g = panel.getGraphics();
      
      for (int i = 1; i<=50; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(10*i-10, 10*i-10, -20*i +520, -20*i +520);
         g.setColor(Color.WHITE);
         g.fillOval(10*i-10, 10*i-10, -20*i +520, -20*i +520);
      }
   }
}