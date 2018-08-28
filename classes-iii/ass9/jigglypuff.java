// Colby Gilbert
// TA:Michelle Cho
// 12/1/2014
// 1362877
// Assingment 9
//
// comments

import java.awt.*;
import java.util.*;

public class jigglypuff extends Critter {
   private int count;
   boolean[] binary = new boolean[4];
   Random rand = new Random(); 
   private int type = rand.nextInt(3);
     
   public Action getMove(CritterInfo info) {   
      binary[0] = (info.getFront() == Neighbor.SAME || info.getFront() == Neighbor.WALL);   
      binary[1] = (info.getBack() == Neighbor.SAME || info.getBack() == Neighbor.WALL);
      binary[2] = (info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL);
      binary[3] = (info.getRight() == Neighbor.SAME || info.getRight() == Neighbor.WALL);
      
      if (info.getFront() == Neighbor.OTHER) {
         count++;
         return Action.INFECT;
      } else if (info.getLeft() == Neighbor.OTHER || info.getLeft() == Neighbor.OTHER || info.getLeft() == Neighbor.OTHER) {
         count++;
         return Action.HOP;
      } else if(info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
                 
      } else if(binary[0] && binary[2]){
         return Action.RIGHT;
      } else {
         int move1 = rand.nextInt(2);
         if (move1 == 0) {  
            return Action.LEFT;
         } else {
            return Action.RIGHT;
         }      
      }           
   }
   public Color getColor() {
       return Color.PINK; 
   }
      public String toString() {
      return "b";    
   }
}