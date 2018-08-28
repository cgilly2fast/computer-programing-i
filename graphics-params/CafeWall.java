// Colby Gilbert
// 10/08/14
// TA: Michelle Cho
// CSE 142
// Assignment 3 (part 2)
//
// this programs draws differnt rows/grids according to user specification

import java.awt.*;

public class CafeWall { 
   public static final int MORTAR = 2; // defines space between rows
   
   public static void main(String[] args) { // the method that calls all of the objects to be drawn
      DrawingPanel panel = new DrawingPanel(650,400);
      panel.setBackground(Color.GRAY);
     
      Graphics g = panel.getGraphics();
      drawRow(g,0,0,4,20,0);
      drawRow(g,50,70,5,30,0);
      drawGrid(g,10,150,4,25,0);
      drawGrid(g,250,200,3,25,10);
      drawGrid(g,425,180,5,20,10);
      drawGrid(g,400,20,2,35,35);
   }
   
   public static void drawGrid (Graphics g, int x, int y, int nP, int s, int off) { // nP= number of pairs, s= size, off=offset
         for (int j =1; j<=nP; j++) { // this method use the the draw row method to make the grids
            drawRow(g, x, y + (2 * j * s - 2 * s) + ((2*MORTAR) * j - (2 * MORTAR)), nP, s, 0);
            drawRow(g, x, y + ( 2 * j * s - s) + (( 2 * MORTAR) * j - MORTAR), nP, s, off); 
            // the only differnce in this^ call is that it accounts for the "off"set variable           
         }
   }     
   
   public static void drawRow (Graphics g, int x, int y, int nP, int s, int off) {
      for (int i = 1; i<=nP; i++){ // this method is the meat of the program that draws each indivual row
         g.setColor(Color.BLACK); // everytime threw one cylce of the for loop creates one pair of W/B boxes
         g.fillRect((x - 2 * s) + 2 * (i * s) + off, y, s, s);
         g.setColor(Color.BLUE); // equations are defined in terms of i to place the next pair after the previous
         g.drawLine((x - 2 * s) + (2 * i * s)+ off, y,
                    (x - 2 * s) + (2 * i * s) + s + off, y + s);
         g.drawLine((x - 2 * s) + (2 * i * s) + s + off, y, 
                    (x - 2 * s) + (2 * i * s)+ off, y+s);
         g.setColor(Color.WHITE);
         g.fillRect((x - 2 * s) + s + (i * 2 * s) + off, y, s, s);
      }
   }
}