// Colby Gilbert
// TA:Michelle Cho
// 12/1/2014
// 1362877
// Assingment 9
//
// this critter is a smart fly trap

import java.awt.*;
import java.util.*;

public class clone extends Critter {
   private int count;
   boolean[] binary;
   Random rand; 
   private int type;
   
   // contructs a clone critter by setting its feild to the desired values.
   public clone() {
      binary = new boolean[4];
      rand = new Random();
      type = rand.nextInt(3);
   }   
   
   // use logic on where wether this is a wall, same or empty in FRONT, LEFT, 
   // RIGHT, or BACK and this uses that information know what way to rotate
   // to increase the likely hood that a my critter is facing the out when 
   // another comes by.   
   public Action getMove(CritterInfo info) {   
      binary[0] = (info.getFront() == Neighbor.SAME || info.getFront() == Neighbor.WALL);   
      binary[1] = (info.getBack() == Neighbor.SAME || info.getBack() == Neighbor.WALL);
      binary[2] = (info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL);
      binary[3] = (info.getRight() == Neighbor.SAME || info.getRight() == Neighbor.WALL);
     
         if (info.getFront() == Neighbor.OTHER) {
            count++;
            return Action.INFECT;
         } else if (info.getLeft() == Neighbor.OTHER) {
            count++;
            return Action.LEFT;
         } else if (info.getRight() == Neighbor.OTHER) {
            count++;
            return Action.RIGHT;      
         } else if (!binary[0] && binary[1] && binary[2]) { 
            if (rand.nextInt(2) == 0) {
               return Action.LEFT;
            } else {   
               return Action.RIGHT;
            }             
         } else if (binary[2] && !binary[3]){      
             count++; 
             return Action.RIGHT;
         } else if (!binary[0] && binary[1] && !binary[2] && !binary[3]){
            int move = rand.nextInt(2);
            if(move == 0) {
               return Action.RIGHT;
            } else {
               return Action.LEFT;
            }      
         } else if((!binary[1] && binary[3]) || (binary[3] && !binary[2]) || (binary[0] && !binary[2])) {
            count++;
            return Action.LEFT;  
         } else if(binary[1] && binary[2] && binary[3]) {
             count++;
             return Action.LEFT;
         } else {    
             count++;
             return Action.HOP;
         }
      } 
   // sets color of criter to CYAN              
   public Color getColor() {
       return Color.CYAN; 
   }
   // set the string or shape of the criter to $
   public String toString() {
      return "$";    
   }
}