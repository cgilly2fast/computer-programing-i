// Colby Gilbert
// TA:Michelle Cho
// 12/1/2014
// 1362877
// Assingment 9
//
// this critter walks about and foreth betwen walls 

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   private int count;
   private int color;
   
   // tnis criter infect if ther is a criter to infect infornt of it
   // otherwise to hops intill a wall is in front or a another lion 
   // to right and then turns right, otherwse turns left       
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
          return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL || info.getRight() 
                 == Neighbor.WALL) {
          count++;
          return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME) {
          count++;
          return Action.RIGHT;    
      } else {
          count++;
          return Action.HOP;
      }
   }
   
   // this criter randomly chooses a color between BLUE GREEN and RED
   // stays tht same color for 3 moves then random picks again and repeat 
   public Color getColor() {
      Random rand = new Random();
      if((count) % 3 == 0) {
         color = rand.nextInt(3);
      }   
      if (color == 0) {
         return Color.RED;
      } else if (color == 1) {
         return Color.GREEN;
      } else {
         return Color.BLUE;
      }           
           
   }
   // this lion critter is represented with a L
   public String toString() {
      return "L";
   }
}