// Colby Gilbert
// TA:Michelle Cho
// 12/1/2014
// 1362877
// Assingment 9
//
// the critter bear has a behavoir of moving to the wall and 
// moving conter clockwise

import java.awt.*;

public class Bear extends Critter {
   private int count;
   private boolean color;
   
   // a contructor that creates the bear, making it either a polar bear(white)
   // or black beear (black)
   public Bear (Boolean color){
      this.color = color;
   }
   
   // this criter infect and oppenrt wehen ever possible, if infection is not 
   // an option the the bear turns left if another bear or wall is infront of
   // it other wise it hops forward   
   public Action getMove(CritterInfo info) {
       if (info.getFront() == Neighbor.OTHER) {
           return Action.INFECT;
       } else if (info.getFront() == Neighbor.SAME || info.getFront() 
                  == Neighbor.WALL) {
           count++;
           return Action.LEFT;
       } else {
           count++;
           return Action.HOP;
       }
   }
   
   // each bear is either polar (white) or black bear(black) this cretes that
   // effect using the field color defined in the contructor
   public Color getColor() {
       if (color) {
         return Color.WHITE;
       } else {
         return Color.BLACK;
       }    
   }
   
   // the bear cyles between a \ and / every move
   public String toString() {
       if ((count + 1) % 2 == 0) {
         return "\\";
       } else { 
         return "/";  
       }
   }
}