// Colby Gilbert
// 10/2/14
// CSE 142
// TA: Michelle Cho
// Assignment 2
//
/* This program creates ASCII rocket image that can be 
expanded or contracted by changing of one constant */

public class DrawRocket{ // this method pieces (calls) all the others together to produce the final picture
   public static final int SIZE = 6; // Change to set size of rocket
   public static void main(String[] args) {
      drawPiont();
      drawSec1();
      drawSec2();
      drawPiont();
   }
   
   public static void drawPiont() { // this method creates the start/end of the rocket
      for(int i= 1; i<=(2*SIZE-1); i++) {
         for(int k=1; k<=-1*i+(2*SIZE); k++) {
            System.out.print(" ");
         }
         for(int k=1; k<=i; k++) {
            System.out.print("/");
         }
         System.out.print("**");
         for(int k=1; k<=i; k++) {
            System.out.print("\\");
         }
         for(int k=1; k<=-1*i+(2*SIZE); k++) {
            System.out.print(" ");
         }
         System.out.println();
      }
   }
   
   public static void drawSec1() { // this method calls other methods to make a mid section of the rocket
      drawBelt();
      drawMid1();
      drawMid2();
      drawBelt();
   }
   
   public static void drawSec2() { // this method calls other methods to make a mid section of the rocket
      drawMid2();
      drawMid1();
      drawBelt();
   }
   
   public static void drawBelt() { // this method expilitly cretes the dividing "belt" betweeen sections
      System.out.print("+");
      for(int i=1;i<=SIZE*2; i++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }
   
   public static void drawMid1() { // this method creates a portion of the body the rocket
      for(int i=1; i<=SIZE; i++) {
         System.out.print("|");
         for(int j=1; j<=-1*i+SIZE;j++) {
            System.out.print(".");
         }
         for(int j=1;j<=i; j++) {
            System.out.print("/\\");
         } 
         for(int j=1; j<=-2*i+(2*SIZE);j++) {
            System.out.print(".");
         }
         for(int j=1;j<=i; j++) {
            System.out.print("/\\");
         }
         for(int j=1; j<=-1*i+SIZE;j++) {
            System.out.print(".");
         }
         System.out.print("|");
         System.out.println();
      }
   }
   
   public static void drawMid2() { // this method creates a portion of the body the rocket
      for(int i=1; i<=SIZE; i++) {
         System.out.print("|");
         for(int j=1; j<=i-1;j++) {
            System.out.print(".");
         }
         for(int j=1;j<=-1*i+(SIZE+1); j++) {
            System.out.print("\\/");
         }
         for(int j=1; j<=2*i-2;j++) {
            System.out.print(".");
         }
         for(int j=1;j<=-1*i+(SIZE+1); j++) {
            System.out.print("\\/");
         }
         for(int j=1; j<=i-1;j++) {
            System.out.print(".");
         }
         System.out.print("|");
         System.out.println();
      }
   }
}