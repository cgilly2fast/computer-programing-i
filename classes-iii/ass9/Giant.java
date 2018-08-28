// Colby Gilbert
// TA:Michelle Cho
// 12/1/2014
// 1362877
// Assingment 9
//
// this critter has a behaivor is go to the walls then 
// moving clockwise arount the area

import java.awt.*;

public class Giant extends Critter {
   private int count;
   private boolean color;
   
   // this critter infect an oopent when ever possible, if not it turns
   // right if the it runs in another giant or wall other wise Hop   
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
          return Action.INFECT;
      } else if (info.getFront() == Neighbor.SAME || info.getFront()                   
                 == Neighbor.WALL) {
          count++;
          return Action.RIGHT;
      } else {
          count++;
          return Action.HOP;
      }
   }
   // gaintd are represented with a GRAY color
   public Color getColor() {
       return Color.GRAY; 
   }
   
   // gaints rotate between "fee" "fie "foe" "fum" every sick moves
   // ot changes to the next phrae, repeating.
   public String toString() {
      int word = ((count / 6) + 1) % 4;
      if (word == 1) {
        return "fee";
      } else if (word == 2) {
        return "fie";
      } else if (word == 3) {
        return "foe";
      } else {
        return "fum";
      }    
   }
}