// Colby Gilbert
// TA:Michelle Cho
// 12/1/2014
// 1362877
// Assingment 9
//
// comments

import java.awt.*;

public class test extends Critter {
   private int count;
   boolean[] binary = new boolean[4]; 
     
   public Action getMove(CritterInfo info) {
        
      binary[1] = (info.getFront() == Neighbor.SAME || info.getFront() == Neighbor.WALL);
     
      if(info.getRight() == Neighbor.SAME || info.getRight() == Neighbor.WALL) {
         binary[1] = true;
      }
      if(info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL) {
         binary[2] = true;
      }
      if(info.getBack() == Neighbor.SAME || info.getBack() == Neighbor.WALL) {
         binary[3] = true;
      }
   }
   }